import ssl
import urllib.request
import html2text
import os

from django.contrib.auth.decorators import login_required
from django.http import JsonResponse
from django.shortcuts import render, redirect
from django.db import transaction
from django.contrib.auth import authenticate
from django.contrib.auth import login

from rest_framework.response import Response
from rest_framework import viewsets

from bs4 import BeautifulSoup

from ancestor.models import Resource, RichResource


def index(request):
    return render(request, template_name=os.path.join('login.html'))


def editor(request):
    return render(request, template_name=os.path.join('editor.html'))


class AncestorViewSet(viewsets.ViewSet):
    queryset = Resource.objects

    authentication_classes = ()
    permission_classes = ()

    def retrieve(self, request):
        return Response({"hello": "test"})

    def login(self, request):
        username = request.data.get('username', '')
        password = request.data.get('password', '')
        user = authenticate(username=username, password=password)
        if user and user.is_active:
            login(request, user)
            return redirect('/engine/show/')
        return JsonResponse({"success": False, "detail": "wrong user or password"}, status=200)


class GrabViewSet(viewsets.ViewSet):
    def more(self, request):
        index = request.data.get("index", "")
        web_content = self._get_web_content(index)
        with transaction.atomic():
            resource = Resource.objects.create(index=index, type=0, content=web_content)
            # serializer = ResourceSerializer(instance=resource, data={'index': index, 'content': web_content})
            # if serializer.is_valid():
            #     serializer.save()
            #     print("content-data {}".format(serializer.data))
            # resource.save()
            return Response({"success": True, "index": index, "content": web_content})

    def _get_web_content(self, index):
        context = ssl._create_unverified_context()
        headers = {'User-Agent': 'Mozilla/5.0 (Windows NT 6.1; WOW64; rv:23.0) Gecko/20100101 Firefox/23.0'}
        req = urllib.request.Request(index, headers=headers)
        text = None
        with urllib.request.urlopen(req, context=context) as response:
            html = response.read()
            text = html2text.html2text(html=html.decode("utf-8", "ignore"), baseurl=index)
            bs_text = BeautifulSoup(html, features="lxml").get_text().replace('\n', '')
            print("bs_text {}".format(bs_text))
        return text


class EditorViewSet(viewsets.ViewSet):
    authentication_classes = ()
    permission_classes = ()

    queryset = RichResource

    def create(self, request):
        content = request.data['content']
        try:
            resource = RichResource.objects.create(content=content)
            resource.save()
        except Exception as e:
            print(e)
            return JsonResponse({'success': False, "info": e})
        return JsonResponse({'success': True, 'id': resource.id})

    def retieve(self, request):
        pk = request.GET.get('id')
        pk = 9
        content = RichResource.objects.get(pk=pk).content

        return JsonResponse({"content": content})
