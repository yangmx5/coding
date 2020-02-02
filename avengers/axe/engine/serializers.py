from django.contrib.auth.models import User
from rest_framework import serializers

from ancestor.models import RichResource
from engine.models import Task
from engine.enums import TaskStatus


class UserSerialilzers(serializers.Serializer):
    def create(self, validated_data):
        pass

    def update(self, instance, validated_data):
        pass

    class Meta:
        model = User
        field = ('id', 'username', 'email')


class TaskSerializers(serializers.Serializer):
    id = serializers.IntegerField(read_only=True)
    title = serializers.CharField()
    desc = serializers.CharField()
    status = serializers.IntegerField()
    is_important = serializers.BooleanField()
    is_urgent = serializers.BooleanField()
    user = serializers.SlugRelatedField(queryset=User.objects.all(), slug_field='id')
    active = serializers.BooleanField(default=True)

    def create(self, validated_data):
        return Task.objects.create(**validated_data)

    def update(self, instance, validated_data):
        instance.title = validated_data.get('title', instance.title)
        instance.desc = validated_data.get('desc', instance.desc)
        instance.status = TaskStatus(validated_data.get('status', instance.status)).value
        instance.is_important = validated_data.get('is_important', instance.is_important)
        instance.is_urgent = validated_data.get('is_urgent', instance.is_urgent)
        instance.save()
        return instance

    def to_representation(self, instance):
        if False:
            instance.status = TaskStatus(instance.status).name

        return super(TaskSerializers, self).to_representation(instance)
