#!/bin/bash

# Script to run the application

cd src/bin/
java -cp .:/usr/share/java/mysql-connector-java.jar DinoMain "$@"
