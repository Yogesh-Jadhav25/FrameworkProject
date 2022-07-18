package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.LoginPage;
import Utility.Utility2;

public class GroupsTest extends TestBase {
	
LoginPage login;
	
	@BeforeMethod (groups = {"Sanity","Regression"})
	
	public void setUp() throws IOException
	{
		initialization();
	    login  = new LoginPage();
	}
	
	@Test  (groups = "Sanity")
	public void verifyTitleTest ()
	{
		String value = login.verifyTitle();
		Assert.assertEquals(value, "Kite - Zerodha's fast and elegant flagship trading platform");
	}
	
	@Test  (groups = "Sanity")
	public void verifyKiteLogoTest ()
	{
		boolean value = login.verifyKiteLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test   (groups = "Sanity")
	public void verifyZerodhaLogoTest ()
	{
		boolean value = login.verifyZerodhaLogo();
		Assert.assertEquals(value, true);
	}
	
	@Test  (groups = "Regression")
	public void openToAppTest () throws IOException, InterruptedException
	{
		boolean value = login.openToApp();
		Assert.assertEquals(value, true);
	}
	
	@AfterMethod (groups = {"Sanity","Regression"})
	public void exit (ITestResult it) throws IOException
	{
		if(ITestResult.FAILURE == it.getStatus())
		{
			Utility2.takeScreenshot(it.getName());
		}
		driver.close();
	}

}
