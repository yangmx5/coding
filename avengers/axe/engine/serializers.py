from rest_framework import serializers
from engine.models import Task
from engine.enums import TaskStatus


class TaskSerializers(serializers.Serializer):
    id = serializers.IntegerField(read_only=True)
    title = serializers.CharField()
    desc = serializers.CharField()
    status = serializers.IntegerField()
    is_important = serializers.BooleanField()
    is_urgent = serializers.BooleanField()

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
