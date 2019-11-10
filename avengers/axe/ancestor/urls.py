from django.conf.urls import url
from django.views.generic import RedirectView

from ancestor.views import index, AncestorViewSet

urlpatterns = [
    url(r'^$', index),
    url(r'^run/', AncestorViewSet.as_view({'get': 'retrieve'}))
]
