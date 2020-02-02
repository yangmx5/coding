"""axe URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.11/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.conf.urls import url, include
    2. Add a URL to urlpatterns:  url(r'^blog/', include('blog.urls'))
"""
from django.conf.urls import url, include
from django.contrib import admin
from django.views.generic import RedirectView
from django.contrib.staticfiles.urls import staticfiles_urlpatterns
from django.views.static import serve

from ancestor import urls as ancestor_url
from axe import settings
from engine import urls as engine_url

urlpatterns = [
    url(r'^$', RedirectView.as_view(url='ancestor', permanent=False)),
    url(r'^surface/(?P<path>.*)$', serve, {'document_root': settings.STATICFILES_DIRS[0]}, name='surface'),
    url(r'^ancestor/', include(ancestor_url)),
    url(r'^admin/', admin.site.urls),
    url(r'^engine/', include(engine_url)),
]

urlpatterns += staticfiles_urlpatterns()
