from django.conf.urls import url
from django.urls import path
from django.views.generic import RedirectView

from engine.views import index, detail
from engine.views import EngineViewSet

urlpatterns = [
    url(r'^$', index),
    url(r'^show/', EngineViewSet.as_view({'get': 'retrieve'})),
    url(r'^list/', EngineViewSet.as_view({'get': 'list_view'})),
    url(r'^edit/', EngineViewSet.as_view({'post': 'edit'})),
    path('del/<int:pk>', EngineViewSet.as_view({'post': 'delete'})),
    path('detail/<int:pk>', detail),
    # url(r'^show/', EngineViewSet.as_view()),
    # url(r'^edit/', EngineViewSet.as_view()),
    # url(r'^del/', EngineViewSet.as_view()),
]
