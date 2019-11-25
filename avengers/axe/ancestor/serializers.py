# coding=utf-8
import ssl
import urllib.request
import html2text

from rest_framework import serializers, fields
from ancestor.models import Resource


class ResourceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Resource
        field = ["index", "type", "content"]


class ResourceCreateSerializer(serializers.Serializer):
    index = fields.URLField(required=True)
    web_content = fields.SerializerMethodField()

    def get_web_content(self, instance):
        print(instance)
        context = ssl._create_unverified_context()
        with urllib.request.urlopen(instance.get("index", ""), context=context) as response:
            html = response.read()
            print(html)
            text = html2text.html2text(html=html.decode("utf-8", "ignore"))
        return text

    def is_valid(self, raise_exception=False):
        return super(ResourceCreateSerializer, self).is_valid(raise_exception=raise_exception)

    def create(self, validated_data):
        pass

    def update(self, instance, validated_data):
        pass
