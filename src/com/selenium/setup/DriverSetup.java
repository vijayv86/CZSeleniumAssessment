package com.selenium.setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


// Please do not change following code

public class DriverSetup {
	private WebDriver driver;
	public static String baseUrl = "http://apps.qa2qe.cognizant.e-box.co.in/Agent_Registration/";
	
	public WebDriver getDriver() {
		ExcelUtils.setExcelFile();
		//If launching FireFox is trouble, uncomment the next line.
		System.setProperty("webdriver.gecko.driver", "lib/geckodriver");
		driver = new FirefoxDriver();
		driver.navigate().to(DriverSetup.baseUrl);
		return driver;
	}

	
}
