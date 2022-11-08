#!/bin/bash

# bash variables
JAVA_HOME=""
JAVA_APPLICATION_PATH="shorterBigTextFile-0.0.1-SNAPSHOT.jar"
MAIN_CLASS_PATH="com.slawomirkaczmarek.shorterBigTextFile.Application"
SOURCE_FILE_PATH="bigTextFile"
DESTINATION_FILE_PATH="newShorterFile"
DESTINATION_FILE_SIZE="2"

# Running java application wiht class path to the method main(String[] args)
#java -cp shorterBigTextFile-0.0.1-SNAPSHOT.jar com.slawomirkaczmarek.shorterBigTextFile.Application bigTextFile newShorterFile 1
#java -cp $JAVA_APPLICATION_PATH $MAIN_CLASS_PATH $SOURCE_FILE_PATH $DESTINATION_FILE_PATH $DESTINATION_FILE_SIZE

# Running java application. Main-Class path is set in the MANIFEST.MF
#java -jar shorterBigTextFile-0.0.1-SNAPSHOT.jar bigTextFile newShorterFile 1
java -jar $JAVA_APPLICATION_PATH $SOURCE_FILE_PATH $DESTINATION_FILE_PATH $DESTINATION_FILE_SIZE


#$SHELL
#read -p "Press enter to continue"


#echo Unzip application jar file...
#DESTINATION_FOLDER_PATH=ShorterBigTextFile
#unzip $JAVA_APPLICATION_PATH -d$DESTINATION_FOLDER_PATH
