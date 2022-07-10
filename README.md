# Google-Keep
Test Automation For Google Keep.

****************Application to Automate Google Keep Apk**********************

###Tools:
1. IDE - Eclipse.
2. Plugins - TestNg from Eclipse Marketplace.
3. Dependencies - In pom File: Selenium, TestNg, Appium Java Client, log4J
4. Framework - Selenium with Page Object Model.
5. Languages - Selenium Java.
6. Engine  - Appium
7. Element Locator - UIAutomator.
8. Testing Devices - PIXEL 5 emulator, Real Device Samsung SM-M115F.
9. Logging - log4j2 
10. Access to Emulators - Android Studio.
11. Environments - JDK 8 build 202, JRE 8 build 202


###Google Keep Automated Functionalities:
1. Launching app to home page.
2. Adding a note.
3. Searching a note.
4. Deleting a note.
5. Adding a new list.
6. Searching a new list.
7. Checking an item in a list.
8. Unchecking an item in a list.
9. Deleting an item in a list.
10. Deleting the whole list.

###How to Install.
1. Ensure Tools mentioned above are installed/configured. 
2. Import project from your IDE of choice.
3. Ensure Appium Driver Server is running.
4. Open BaseTests.java Class under src/main/resources folder, com.googlekeep.nala.base package.
5. Modify the following variables to match your test artifacts: "PLATFORM_VERSION", "DEVICE_NAME", "UDID".
6. Open TestSuites under src/test/resources folder.
7. Right Click the TestSuites you wish to execute. Select "Run As - TestNG Suite"
*Currently tests are clustered into List and Notes Tests.
*If option TestNG Suite is not available, install TestNG from Eclipse MarketPlace.
8. Open Sample Test Report "emailable-report.html" under tes-output folder.

![image](https://user-images.githubusercontent.com/35455769/178160711-06c37998-6b7c-4a0e-b58c-1e08628735b3.png)

![image](https://user-images.githubusercontent.com/35455769/178160717-5143c0b7-5563-4306-a7f0-9ff7f17e3f9e.png)


