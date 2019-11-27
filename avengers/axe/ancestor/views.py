import ssl
import urllib.request
import html2text
import os

from django.shortcuts import render
from django.db import transaction

from rest_framework.response import Response
from rest_framework import viewsets

from bs4 import BeautifulSoup

from ancestor.models import Resource


def index(request):
    return render(request, template_name=os.path.join('index.html'))


class AncestorViewSet(viewsets.ViewSet):
    queryset = Resource.objects

    def retrieve(self, request):
        # print(request.GET)
        return Response({"hello": "test"})

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
