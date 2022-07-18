package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Utility2;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	ExtentTest test;
	
	@BeforeMethod
	
	public void setUp() throws IOException
	{
		initialization();
	    login  = new LoginPage();
	    
	}
	
	@Test  
	public void verifyTitleTest ()
	{
		
		
		String value = login.verifyTitle();
		Assert.assertEquals(value, "Kite - Zerodha's fast and elegant flagship trading platform");
		Reporter.log("Verify Title Test");
		
		
	}
	
	@Test 
	public void verifyKiteLogoTest ()
	{
		
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, true);
		Reporter.log("Verify Kite Logo Test");
		
		
		
	}
	
	@Test  
	public void verifyZerodhaLogoTest ()
	{
		
		boolean value = login.verifyZerodhaLogo();
		Assert.assertEquals(value, true);
		Reporter.log("Verify Zerodha logo Test");
		
	}
	
	@Test  
	public void openToAppTest () throws IOException, InterruptedException
	{
		
		boolean value = login.openToApp();
		Assert.assertEquals(value, true);
	
	}
	
	@AfterMethod
	public void exit (ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			Utility2.takeScreenshot(it.getName());
		}
		driver.close();
		
	}
	
}
