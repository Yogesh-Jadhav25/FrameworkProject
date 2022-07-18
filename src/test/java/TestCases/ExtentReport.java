package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import Pages.LoginPage;

public class ExtentReport extends TestBase {
	
	LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException
	{
		initialization();
	    login  = new LoginPage(); 
	}
	
	@Test
	
	public void verifyTitleTest ()
	{
		ExtentTest test = extent.createTest("Zerodha App Test", "Verify Title Test");
		test.log(Status.INFO, "Strarting Test Case");
		
		String value = login.verifyTitle();
		Assert.assertEquals(value, "Kite - Zerodha's fast and elegant flagship trading platform");
		
		test.pass("Verify title");
	}

	@AfterMethod
	public void exit ()
	{
		driver.close();
		extent.flush();
	}
}
