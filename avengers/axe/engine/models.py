from django.contrib.auth.models import User
from django.db import models

# Create your models here.
from django.db import models


class ValideTaskManager(models.Manager):

    def get_queryset(self):
        return super(ValideTaskManager, self).get_queryset().filter(active=True)


class Task(models.Model):
    title = models.CharField(max_length=255, blank=False)
    desc = models.CharField(max_length=255, blank=True)
    status = models.IntegerField(blank=False, default=0)
    is_important = models.BooleanField()
    is_urgent = models.BooleanField()
    user = models.ForeignKey(User, on_delete=models.PROTECT)
    active = models.BooleanField(default=True)

    objects = ValideTaskManager()

    class Meta:
        db_table = "engine_task"
