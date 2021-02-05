# ValentinaIvanovaMobile
To run the project you should:
-	run an emulator by using AVD Manager in Android Studio (or connect a physical device through USB port to your machine but in this case you have to change value for parameter **deviceName** into TestNG xml files: nativeTNG.xml and webTNG.xml)   
-	start the Appium server at your machine 
-	clone repository and run the project from command line by using **mvn clean test -P native** (for native application tests ) or **mvn clean test -P web** (for web test)
