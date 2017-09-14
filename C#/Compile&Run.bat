echo off
cd C:\Users\Stefan\workspace\C#\
color a
cls
dir
echo .
echo=========================================================
echo `
:REDO
SET /P File=Enter the file name (Without extention): 
IF %ERRORLEVEL% NEQ 0 GOTO REDO
C:\Windows\Microsoft.NET\Framework\v2.0.50727\csc.exe %File%.cs
Start %File%.exe
pause
GOTO REDO