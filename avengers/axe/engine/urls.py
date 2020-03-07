from django.conf.urls import url
from django.urls import path
from django.views.generic import RedirectView

from engine.views import index, detail, retrieve, list_view
from engine.views import EngineViewSet

urlpatterns = [
    url(r'^$', index),
    url(r'^show/', retrieve),
    url(r'^list/', list_view),
    url(r'^all_tasks/', EngineViewSet.as_view({'get': 'all_user_task'})),
    url(r'^edit/', EngineViewSet.as_view({'post': 'edit'})),
    url(r'^update/', EngineViewSet.as_view({'post': 'update'})),
    path('del/<int:pk>', EngineViewSet.as_view({'post': 'delete'})),
    path('detail/<int:pk>', detail),
]
