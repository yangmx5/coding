# Create your views here.
import ssl
import urllib.request
import html2text
import os
import json

from django.http import JsonResponse, Http404, HttpResponse
from django.shortcuts import render, get_object_or_404
from django.db import transaction
from django.core import serializers
from django.template import loader

from rest_framework.response import Response
from rest_framework import viewsets, mixins

from bs4 import BeautifulSoup

from ancestor.models import Resource
from engine.enums import TaskStatus
from engine.models import Task
from engine.serializers import TaskSerializers


def index(request):
    return render(request, template_name=os.path.join('engine/index.html'))


def detail(request, pk):
    try:
        instance = Task.objects.get(pk=pk)
        ret = TaskSerializers(instance).data
    except Exception as e:
        print(e)
        return JsonResponse({"success": False, "detail": e.__str__()}, status=200)
    return JsonResponse({"success": True, "ret": ret}, status=200)


class EngineViewSet(viewsets.ViewSet):
    queryset = Resource.objects

    def retrieve(self, request):
        # print(request.GET)
        tasks = Task.objects.all()
        tmp = TaskSerializers(tasks, many=True).data
        ret = []
        if tmp:
            for item in tmp:
                item['status_display'] = TaskStatus(item.get('status', 0)).name
                ret.append(dict(item))
        context = {"tasks": ret}
        template = loader.get_template(os.path.join('engine/index.html'))
        return HttpResponse(template.render(context, request))

        # tasks = serializers.serialize('json', tasks)
        # return Response(tmp)

    def list_view(self, request):
        tasks = Task.objects.all()
        tmp = TaskSerializers(tasks, many=True).data
        ret = []
        if tmp:
            for item in tmp:
                item['status_display'] = TaskStatus(item.get('status', 0)).name
                ret.append(dict(item))
        context = {"tasks": ret}
        template = loader.get_template(os.path.join('engine/admin.html'))
        return HttpResponse(template.render(context, request))

    def edit(self, request):
        data = request.data
        if data.get('id'):
            try:
                instance = Task.objects.get(pk=data.get('id'))
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

    def delete(self, request, pk):
        try:
            instance = Task.objects.get(pk=pk)
            instance.delete()
        except Exception as e:
            print(e)
            return JsonResponse({"success": False, "detail": e.__str__()}, status=200)
        return JsonResponse({"success": True}, status=200)
