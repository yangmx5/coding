# Create your views here.
import ssl
import urllib.request
import html2text
import os
import json

from django.contrib.auth.decorators import login_required
from django.core.serializers import serialize
from django.http import JsonResponse, Http404, HttpResponse
from django.shortcuts import render, get_object_or_404
from django.db import transaction
from django.core import serializers
from django.template import loader

from rest_framework.response import Response
from rest_framework import viewsets, mixins
from rest_framework.permissions import IsAuthenticated
from rest_framework.authentication import BasicAuthentication, SessionAuthentication

from bs4 import BeautifulSoup

from ancestor.models import Resource
from engine.enums import TaskStatus
from engine.models import Task
from engine.serializers import TaskSerializers, UserSerialilzers


@login_required(login_url='/')
def index(request):
    return render(request, template_name=os.path.join('engine/index.html'))


@login_required(login_url='/')
def detail(request, pk):
    try:
        instance = Task.objects.get(pk=pk, user=request.user)
        ret = TaskSerializers(instance).data
        # rich_docs = json.loads(serialize('json', instance.rich_doc.all()))
        rich_docs = []
    except Exception as e:
        print(e)
        return JsonResponse({"success": False, "detail": e.__str__()}, status=200)
    return JsonResponse({"success": True, "ret": ret, "rich_docs": rich_docs}, status=200)


@login_required(login_url='/')
def retrieve(request):
    tasks = Task.objects.filter(user=request.user)
    tmp = TaskSerializers(tasks, many=True).data
    ret = []
    if tmp:
        for item in tmp:
            item['status_display'] = TaskStatus(item.get('status', 0)).name
            ret.append(dict(item))
    context = {"tasks": ret}
    template = loader.get_template(os.path.join('engine/index.html'))
    return HttpResponse(template.render(context, request))


@login_required(login_url='/')
def list_view(request):
    tasks = Task.objects.filter(user=request.user)
    tmp = TaskSerializers(tasks, many=True).data
    ret = []
    if tmp:
        for item in tmp:
            item['status_display'] = TaskStatus(item.get('status', 0)).name
            ret.append(dict(item))
    context = {"tasks": ret}
    template = loader.get_template(os.path.join('engine/admin.html'))
    return HttpResponse(template.render(context, request))


class EngineViewSet(viewsets.ViewSet):
    queryset = Resource.objects
    permission_classes = (IsAuthenticated,)
    authentication_classes = (SessionAuthentication,)

    def edit(self, request):
        data = request.data.dict()
        data['user'] = request.user.id
        if data.get('id'):
            try:
                instance = Task.objects.get(pk=data.get('id'), user=request.user)
                serializer = TaskSerializers(instance=instance, data=data)
            except Exception as e:
                print(e)
                serializer = TaskSerializers(data=data)
        else:
            serializer = TaskSerializers(data=data)
        if serializer.is_valid():
            serializer.save()
            return JsonResponse(serializer.data, status=201)
        return JsonResponse(serializer.errors, status=400)

    def update(self, request):
        data = request.data
        if data.get('id') and data.get('status'):
            try:
                instance = Task.objects.get(pk=data.get('id'), user=request.user)
                instance.status = data.get('status')
                instance.save()
            except Exception as e:
                print(e)
                return JsonResponse({"error": e}, status=500)
        else:
            return JsonResponse({"error": "param not valid"}, status=400)
        return JsonResponse({"success": True}, status=200)

    def delete(self, request, pk):
        try:
            instance = Task.objects.get(pk=pk, user=request.user)
            instance.active = False
            instance.save()
        except Exception as e:
            print(e)
            return JsonResponse({"success": False, "detail": e.__str__()}, status=200)
        return JsonResponse({"success": True}, status=200)
