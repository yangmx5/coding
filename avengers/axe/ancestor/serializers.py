# coding=utf-8


from rest_framework import serializers, fields
from ancestor.models import Resource


class ResourceSerializer(serializers.Serializer):
    # index = fields.URLField(required=True)
    # content = fields.CharField(required=False)

    def is_valid(self, raise_exception=False):
        return super(ResourceSerializer, self).is_valid(raise_exception=raise_exception)

    def create(self, validated_data):
        return Resource.objects.create(**validated_data)

    def update(self, instance, validated_data):
        instance.index = validated_data.get("index", "")
        instance.content = validated_data.get("content", "")
        return instance

    class Meta:
        model = Resource
        field = ["index", "type", "content"]
