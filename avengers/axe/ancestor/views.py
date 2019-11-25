from django.shortcuts import render
from django.http import HttpResponse
import os

from django.template.loader import get_template
from rest_framework.response import Response
from rest_framework import viewsets

from ancestor.serializers import ResourceCreateSerializer


def index(request):
    return render(request, template_name=os.path.join('index.html'))


class AncestorViewSet(viewsets.ViewSet):
    def __init__(self):
        self.model = None

    def retrieve(self, request):
        # print(request.GET)
        return Response({"hello": "test"})

    def more(self, request):
        serializer = ResourceCreateSerializer(data=request.data)
        if serializer.is_valid():
            print("content {}".format(serializer.validated_data.get("web_content")))
            print("content-data {}".format(serializer.data))
            return Response({"success": True})
        else:
            return Response({"success": False})
