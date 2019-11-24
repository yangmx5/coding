from rest_framework import serializers, fields
from ancestor.models import Resource


class ResourceSerializer(serializers.ModelSerializer):
    class Meta:
        model = Resource
        field = ["index", "type", "content"]


class ResourceCreateSerializer(serializers.Serializer):
    index = fields.URLField(required=True)

    def create(self, validated_data):
        pass

    def update(self, instance, validated_data):
        pass
