from ckeditor.fields import RichTextField
from ckeditor_uploader.fields import RichTextUploadingField
from django.db import models


class Resource(models.Model):
    index = models.CharField(max_length=255, blank=False)
    type = models.IntegerField(blank=False, default=0)
    content = models.TextField(blank=True)

    class Meta:
        db_table = "axe_resource"


class RichResource(models.Model):
    content = RichTextUploadingField()

    def __str__(self):
        return "RichResource<{}> {}".format(self.id, self.content)
