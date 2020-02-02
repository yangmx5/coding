from django.conf.urls import url
from django.views.generic import RedirectView

from ancestor.views import index, editor, AncestorViewSet, GrabViewSet, EditorViewSet

urlpatterns = [
    url(r'^$', index),
    url(r'^run/', AncestorViewSet.as_view({'get': 'retrieve'})),
    url(r'^put/', GrabViewSet.as_view({'post': 'more'})),
    url(r'^login/', AncestorViewSet.as_view({'post': 'login'})),
    url(r'^editor/', editor),
    url(r'^rich_resource/', EditorViewSet.as_view({
        'post': 'create',
        'get': 'retieve'
    }))
]
