#!/bin/bash

# Script that automates the creation of javadocs for the files listed in
# the function generate_docs()

function create_javadoc_dir()
{
       mkdir -p docs/javadoc
}

function generate_docs()
{
       javadoc -d docs/javadoc \
               -sourcepath src \
               -author \
               -version \
               -private \
               src/Data/Car.java \
               src/Data/Database.java \
               src/Data/CSVParser.java \
               src/Gui/GUIManager.java \
               src/Gui/MainFrame.java \
               src/Gui/MenuFrame.java \
               src/Gui/SearchFrame.java \
               src/Gui/SliderFrame.java
}

function print_status()
{
       echo "Javadocs generated in docs/javadoc/"
       echo "Documentation includes core data classes and GUI components"
}

function main()
{
       create_javadoc_dir
       generate_docs
       print_status
}

main
