#!/bin/bash

# Script that handles compiling and moving .class files into a new
# directory

javac -d src/bin/ src/Exception/*.java src/Gui/*.java src/Data/*.java src/DinoMain.java
