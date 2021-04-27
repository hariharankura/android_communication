# Remote Control Raspberry Pi with Android App

This repo has a basic remote control code for Raspberry Pi 3B using an Android App. Here, the Pi acts as server and android app as the client.

## Server:

Server is run on the Raspberry Pi using Django framework. Following are the steps to develop the server code:

1) Install Djano - Follow the steps from the link below to install Django framework on Pi
   https://medium.com/ristek-fasilkom/controlling-raspberry-pi-with-django-a91940fc3f4d
   
2) Install REST framework: pip install djangorestframework

3) Create a Django Project: django-admin startproject my_project

4) Navigate to my_project and setup Django Application: 
   cd my_project
   python manage.py startapp androidApp
   
5) Add REST and androidApp application to settings.py
   INSTALLED_APPS = [
   'rest_framework',
   'androidApp'
   ]
   
6) Add our Pi's IP to ALLOWED_HOSTS list in settings.py

7) Update urls.py file to import views.py and add 'run' method from views.py

8) views.py has all the actual code to run functions on Pi.

9) Add serializers.py if the server wants to send data to client. The python data from the Server is converted to JSON format by serializers.py file and sent to the Android App.


## Client:

Here, Android App acts the client


   
