package com.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.AgentForm;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

//To check if the results have been stored in the appropriate static variables as mentioned in the case study.
public class TestAgentForm extends DriverSetup {
	WebDriver driver;
	AgentForm agentForm;
	public static String invalidEmailTxt;
	public static String blankErrtxt;

	
	@BeforeClass
	public void setUp() {

		driver = getDriver();
	}

	@Test(priority = 1)
	public void testInvalidEmailId() throws Exception {		
		agentForm = new AgentForm(driver);
		String firstName = ExcelUtils.getCellData(1, 1);
		String lastName = ExcelUtils.getCellData(1, 2);
		String username = ExcelUtils.getCellData(1, 3);
		String password = ExcelUtils.getCellData(1, 4);
		String phoneNumber = ExcelUtils.getCellData(1, 5);
		String email = ExcelUtils.getCellData(1, 6);
		agentForm.setFirstName(firstName);
		agentForm.setLastName(lastName);
		agentForm.setUserName(username);
		agentForm.setPassword(password);
		agentForm.setPhoneNumber(phoneNumber);
		agentForm.setEmail(email);
		agentForm.submitForm();
		invalidEmailTxt = agentForm.getErrorMessage();
		try {
			AssertJUnit.assertEquals(invalidEmailTxt.toUpperCase(), "ENTER A VALID EMAIL ID");
			Reporter.log("Verifying invalid email error message: successful", true);
		} catch (Exception e) {
			Reporter.log("Verifying invalid email error message: unsuccessful", true);
			AssertJUnit.fail();
		}
	}

	@Test(priority = 2)
	public void testBlankForPasswordAndEmail() throws Exception {
		agentForm = new AgentForm(driver);
		String firstName = ExcelUtils.getCellData(2, 1);
		String lastName = ExcelUtils.getCellData(2, 2);
		String username = ExcelUtils.getCellData(2, 3);
		String password = ExcelUtils.getCellData(2, 4);
		String phoneNumber = ExcelUtils.getCellData(2, 5);
		String email = ExcelUtils.getCellData(2, 6);

		agentForm.setFirstName(firstName);
		agentForm.setLastName(lastName);
		agentForm.setUserName(username);
		agentForm.setPassword(password);
		agentForm.setPhoneNumber(phoneNumber);
		agentForm.setEmail(email);
		agentForm.submitForm();
		blankErrtxt = agentForm.getErrorMessage();
		if (blankErrtxt.equalsIgnoreCase("Password cannot be blank" + "\n" + "Email cannot be blank")) {
			Reporter.log("Verifying blank error message: successful", true);
		} else {
			Reporter.log("Verifying blank error message: unsuccessful", true);
			AssertJUnit.fail();
		}
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	

}
