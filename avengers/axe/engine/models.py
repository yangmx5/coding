from django.db import models

# Create your models here.
from django.db import models


class Task(models.Model):
    title = models.CharField(max_length=255, blank=False)
    desc = models.CharField(max_length=255, blank=True)
    status = models.IntegerField(blank=False, default=0)
    is_important = models.BooleanField()
    is_urgent = models.BooleanField()

    class Meta:
        db_table = "engine_task"
