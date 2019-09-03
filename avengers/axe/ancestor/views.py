from django.shortcuts import render
from django.http import HttpResponse
import os

from django.template.loader import get_template
from rest_framework.response import Response
from rest_framework import viewsets


def index(request):
    return render(request, template_name=os.path.join('index.html'))


class AncestorViewSet(viewsets.ViewSet):
    def retrieve(self, request):
        # print(request.GET)
        return Response({"hello": "test"})
