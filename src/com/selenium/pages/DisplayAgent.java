package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//To check if you have followed the right naming convention for the methods as mentioned in the case study.

public class DisplayAgent {
	public WebDriver driver;

	public DisplayAgent(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitle() {
		return driver.findElement(By.tagName("h2")).getText();
	}

	public String getName() {
		return driver.findElement(By.xpath("//table//tr[1]//td[2]")).getText();
	}

	public String getUserName() {
		return driver.findElement(By.xpath("//table//tr[2]//td[2]")).getText();
	}

	public String getNumber() {
		return driver.findElement(By.xpath("//table//tr[3]//td[2]")).getText();
	}

	public String getEmail() {
		return driver.findElement(By.xpath("//table//tr[4]//td[2]")).getText();
	}
}