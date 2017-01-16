set projectLocation=F:\Automation_Windows\pws\
cd %projectLocation%
set classpath=%projectLocation%\bin;%projectLocation%\jars\*
java org.testng.TestNG %projectLocation%\testng.xml
pause