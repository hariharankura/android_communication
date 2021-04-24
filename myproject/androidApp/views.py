# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.shortcuts import render

from django.http import HttpResponse
from rest_framework.views import APIView
from rest_framework.response import Response
from rest_framework import status
#from . models import employees
#from . serializers import employeesSerializer

""" class employeeList(APIView):
    def get(self, request):
        employee1 = employees.objects.all()
        serializer = employeesSerializer(employee1, many=True)
        print ("Perform operation")
        return Response(serializer.data)

    def post(self):
        pass """

def run(request):
    if 'action' in request.GET:
        action = request.GET['action']
        # ============== Back wheels =============
        if action == 'forward':
            print("Go Forward")
            #Implement Forward function
        elif action == 'stop':
            #Implement Stop function
            print("Stop")

        # ============== Front wheels =============
        elif action == 'left':
            #Implement Left function
            print("Move Left")
        elif action == 'right':
            #Implement Right function
            print("Move Right")
    return HttpResponse('')