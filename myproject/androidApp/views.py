# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

from django.http import HttpResponse
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
#from . models import employees
#from . serializers import employeesSerializer


def run(request):
    if 'values' in request.GET:
        string = request.GET['values']
        values = string.split(":")
        angle = values[0]
        strength = values[1]
        print ("angle = "+angle+" strength = "+strength)
    return HttpResponse('')

def camera(request):
    if 'angle' in request.GET:
        cam_angle = request.GET['angle']
        print ("camera angle = "+cam_angle)
    
    return HttpResponse('')