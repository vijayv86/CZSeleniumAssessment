package com.selenium.tests;

import static org.testng.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.selenium.pages.AgentForm;
import com.selenium.pages.DisplayAgent;
import com.selenium.setup.DriverSetup;
import com.selenium.setup.ExcelUtils;

//To check if the results have been stored in the appropriate static variables as mentioned in the case study.
public class TestDisplayPage extends DriverSetup {
	AgentForm agentForm;
	WebDriver driver;
	DisplayAgent welcomepage;
	public static String titletxt;
	public static String nametxt;
	public static String unametxt;
	public static String phonenumbertxt;
	public static String emailtxt;

	@BeforeClass
	public void setUp() {
		driver = getDriver();
	}

	@Test(priority = 3)
	public void testForValidAgent() throws Exception {
		welcomepage = new DisplayAgent(driver);
		agentForm = new AgentForm(driver);
		boolean testCase = true;
		String firstName = ExcelUtils.getCellData(3, 1);
		String lastName = ExcelUtils.getCellData(3, 2);
		String username = ExcelUtils.getCellData(3, 3);
		String password = ExcelUtils.getCellData(3, 4);
		String phoneNumber = ExcelUtils.getCellData(3, 5);
		String email = ExcelUtils.getCellData(3, 6);
		// fill the code here
		agentForm.setFirstName(firstName);
		agentForm.setLastName(lastName);
		agentForm.setUserName(username);
		agentForm.setPassword(password);
		agentForm.setPhoneNumber(phoneNumber);
		agentForm.setEmail(email);
		agentForm.submitForm();
		titletxt = welcomepage.getTitle();
		nametxt = welcomepage.getName();
		unametxt = welcomepage.getUserName();
		phonenumbertxt = welcomepage.getNumber();
		emailtxt = welcomepage.getEmail();

		try {
			assertTrue(titletxt.equalsIgnoreCase("Registered Succesfully"), "Title text doesn't match");
			Reporter.log("Verifying Registration page: successful", true);
		} catch (Exception e) {
			testCase = false;
			Reporter.log("Verifying Registration page: unsuccessful", true);
		}

		try {
			assertTrue(nametxt.equalsIgnoreCase("Sri shobi"), "Name text doesn't match");
			Reporter.log("Verifying Name in Registration page: successful", true);
		} catch (Exception e) {
			testCase = false;
			Reporter.log("Verifying Name in Registration page: unsuccessful", true);
		}

		try {
			assertTrue(unametxt.equalsIgnoreCase("shobi"), "Username text doesn't match");
			Reporter.log("Verifying UserName in Registration page: successful", true);
		} catch (Exception e) {
			testCase = false;
			Reporter.log("Verifying UserName in Registration page: unsuccessful", true);
		}

		try {
			assertTrue(phonenumbertxt.equalsIgnoreCase("8012785789"), "Phonenumber text doesn't match");
			Reporter.log("Verifying Phone number in Registration page: successful", true);
		} catch (Exception e) {
			testCase = false;
			Reporter.log("Verifying Phone number in Registration page: unsuccessful", true);
		}

		try {
			assertTrue(emailtxt.equalsIgnoreCase("sri@gmail.com"), "Title text doesn't match");
			Reporter.log("Verifying Email in Registration page: successful", true);
		} catch (Exception e) {
			testCase = false;
			Reporter.log("Verifying Email in Registration page: unsuccessful", true);
		}
		
		if(testCase == false)
		{
			Reporter.log("Test Failed. Please check log for further details", true);
			Assert.fail();
		}

	}
	
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
}