from django.contrib.auth.models import User
from django.db import models

# Create your models here.
from django.db import models

from ancestor.models import RichResource
from ckeditor_uploader.fields import RichTextUploadingField


class ValideTaskManager(models.Manager):

    def get_queryset(self):
        return super(ValideTaskManager, self).get_queryset().filter(active=True)


class Task(models.Model):
    title = models.CharField(max_length=255, blank=False)
    desc = RichTextUploadingField()
    status = models.IntegerField(blank=False, default=0)
    is_important = models.BooleanField()
    is_urgent = models.BooleanField()
    user = models.ForeignKey(User, on_delete=models.PROTECT)
    # rich_doc = models.ManyToManyField(RichResource)
    active = models.BooleanField(default=True)
    finished_time = models.DateTimeField(blank=True, auto_now=True)
    plan_time = models.DateTimeField(blank=True)
    modified_time = models.DateTimeField('修改时间', auto_now=True)
    created_time = models.DateTimeField('创建时间', auto_now_add=True)

    objects = ValideTaskManager()

    class Meta:
        db_table = "engine_task"
