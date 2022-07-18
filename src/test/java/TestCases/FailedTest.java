package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;


public class FailedTest extends TestBase{
	
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
		String value = login.verifyTitle();
		Assert.assertEquals(value, "Kite - Zerodha's fast and elegant flagship trading platform");
		
	}
	
	@Test 
	public void verifyKiteLogoTest ()
	{
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, false);
		
	}
	
	@Test 
	public void verifyZerodhaLogoTest ()
	{
		boolean value = login.verifyZerodhaLogo();
		Assert.assertEquals(value, false);
		
	}
	
	@Test  (enabled = false)
	public void openToAppTest () throws IOException, InterruptedException
	{
		boolean value = login.openToApp();
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod
	public void exit (ITestResult it) throws IOException
	{
		driver.close();
	}

}
