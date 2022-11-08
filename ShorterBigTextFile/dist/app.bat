::echo %USERPROFILE%
::java -jar %USERPROFILE%\Workspace_eclipse-java-2022-09-R-win32-x86_64\ShorterBigTextFile\ShorterBigTextFile\target\shorterBigTextFile-0.0.1-SNAPSHOT.jar sdfs asdf
@echo off

set JAVA_PATH=C:\"Program Files"\Java\jdk-15.0.2\bin\
set SHORT_TEXT_FILE_APP=shorterBigTextFile-0.0.1-SNAPSHOT.jar
set SOURCE_FILE_PATH=bigTextFile.txt
set DESTINATION_FILE_PATH=shorterBigTextFile.txt
set DESTINATION_FILE_SIZE=1200

::java -jar %USERPROFILE%\git\repository\ShorterBigTextFile\target\shorterBigTextFile-0.0.1-SNAPSHOT.jar C:\Users\20624\git\repository\ShorterBigTextFile\src\test\resources\bigTextFile.txt %USERPROFILE%\Desktop\shorterBigTextFile.txt
java.exe -jar %SHORT_TEXT_FILE_APP% %SOURCE_FILE_PATH% %DESTINATION_FILE_PATH% %DESTINATION_FILE_SIZE%
::java -cp %USERPROFILE%\Workspace_eclipse-java-2022-09-R-win32-x86_64\shorterBigTextFile\target\shorterBigTextFile-0.0.1-SNAPSHOT.jar com.slawomirkaczmarek.shorterBigTextFile.Application blabla blex
Pause&Exit
