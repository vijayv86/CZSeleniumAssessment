
**Readme**

This document will allow you to run these assessment related tests locally. 

**Steps to run tests**

1. Import the project into eclipse.
2. Make sure you have TestNG plugin.
3. Right click testng.xml and click Run as TestNG suite.
4. Tests should run without any exceptions.


**Troubleshooting:**

If the tests are throwing an exception when invoking firefox driver like the one below:

    FAILED CONFIGURATION: @BeforeClass setUp
    java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.gecko.driver system property; for more information, see https://github.com/mozilla/geckodriver. The latest version can be downloaded from https://github.com/mozilla/geckodriver/releases

Please open com.selenium.setup.DriverSetup.java
Uncomment line:16

    System.setProperty("webdriver.gecko.driver", ".\\lib\\geckodriver.exe");

Save file; Now rerun the tests.