package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DashboardPage;
import Pages.LoginPage;

public class DashboardPageTest extends TestBase {
	
	LoginPage login;
	DashboardPage dash;
	 
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
	    login = new LoginPage();
	    dash = new DashboardPage();
	}
	
	@Test (enabled = false)
	public void verifyUsernameTest() throws InterruptedException, IOException
	{
		login.openToApp();
	  String value = dash.verifyUsername();
	  Assert.assertEquals("Yogesh Bhagwan Jadhav", value);
	}
	@Test (enabled = true)
	public void verifyEmailTest () throws InterruptedException, IOException
	{
		login.openToApp();
		String value = dash.verifyEmail();
		Assert.assertEquals("yogeshbjadhav125@gmail.com", value);
	}
	@Test (enabled = false)
	public void placeGttOrderTest () throws InterruptedException, IOException
	{
		login.openToApp();
		dash.placeGttOrder();
	}
	
	@AfterMethod
	public void exit ()
	{
		driver.close();
	}

}
