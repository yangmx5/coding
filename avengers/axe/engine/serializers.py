from django.contrib.auth.models import User
from rest_framework import serializers

from ancestor.models import RichResource
from engine.models import Task, TaskItem
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
    plan_time = serializers.DateTimeField(format='%Y-%m-%d %H:%M:%S')

    def create(self, validated_data):
        validated_data["plan_time"] = validated_data["plan_time"].strftime("%Y-%m-%d")
        return Task.objects.create(**validated_data)

    def update(self, instance, validated_data):
        instance.title = validated_data.get('title', instance.title)
        instance.desc = validated_data.get('desc', instance.desc)
        instance.status = TaskStatus(validated_data.get('status', instance.status)).value
        instance.is_important = validated_data.get('is_important', instance.is_important)
        instance.is_urgent = validated_data.get('is_urgent', instance.is_urgent)
        instance.plan_time = validated_data.get('plan_time', instance.plan_time)
        instance.save()
        return instance

    def to_representation(self, instance):
        if False:
            instance.status = TaskStatus(instance.status).name

        instance.finished_time = instance.finished_time.strftime("%Y-%m-%d")
        if not isinstance(instance.plan_time, str):
            instance.plan_time = instance.plan_time.strftime("%Y-%m-%d")

        return super(TaskSerializers, self).to_representation(instance)


class TaskItemSerializers(serializers.Serializer):
    def create(self, validated_data):
        pass

    def update(self, instance, validated_data):
        pass

    id = serializers.IntegerField(read_only=True)
    content = serializers.CharField()
    status = serializers.IntegerField()
    task = serializers.SlugRelatedField(queryset=Task.objects.all(), slug_field='id')
    active = serializers.BooleanField(default=True)
    plan_time = serializers.DateTimeField(format='%Y-%m-%d %H:%M:%S')
    finished_time = serializers.DateTimeField(format='%Y-%m-%d %H:%M:%S')

    class Meta:
        model = TaskItem
        field = ('id', 'content', 'status', 'task', 'plan_time', 'finished_time')
