package com.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//To check if you have followed the right naming convention for the methods as mentioned in the case study.

public class AgentForm {
	// fill the code
	public WebDriver driver;

	public AgentForm(WebDriver driver) {
		this.driver = driver;
	}

	public void setFirstName(String fnameTxt) {
		driver.findElement(By.name("firstname")).sendKeys(fnameTxt);
	}

	public void setLastName(String lnameTxt) {
		driver.findElement(By.name("lastname")).sendKeys(lnameTxt);
	}

	public void setUserName(String unameTxt) {
		driver.findElement(By.name("username")).sendKeys(unameTxt);
	}

	public void setPassword(String passwordTxt) {
		driver.findElement(By.name("password")).sendKeys(passwordTxt);
	}

	public void setPhoneNumber(String phoneNumberTxt) {
		driver.findElement(By.name("phonenumber")).sendKeys(phoneNumberTxt);
	}

	public void setEmail(String emailTxt) {
		driver.findElement(By.name("email")).sendKeys(emailTxt);
	}

	public void submitForm() {
		driver.findElement(By.id("submit")).click();
	}

	public String getErrorMessage() {
		return driver.findElement(By.id("message")).getText();
	}
}