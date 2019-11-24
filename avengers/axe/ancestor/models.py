from django.db import models


class Resource(models.Model):
    index = models.CharField(max_length=255, blank=False)
    type = models.IntegerField(blank=False, default=0)
    content = models.TextField(blank=True)

    class Meta:
        db_table = "axe_resource"
