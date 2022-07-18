package Base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import Utility.Utility;

public class TestBase extends Utility{
	
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	
	public void initialization () throws IOException
	{
		
	    htmlReporter = new ExtentHtmlReporter("\\Users\\Yogesh\\eclipse-workspace\\New folder\\Project\\ExtentReport\\extent.html");
	    extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		String browser = readPropertyFile("browser");
		if(browser.equalsIgnoreCase("chrome"))
		{
			ChromeOptions ops = new ChromeOptions();        //for disable notification
			ops.addArguments("--disable-notifications");
		    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		    driver = new ChromeDriver(ops);
		    driver.manage().window().maximize();
		    driver.manage().deleteAllCookies();            //for delete all cookies
		    driver.get(readPropertyFile("url"));
		    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
		else if (browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(readPropertyFile("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		else if (browser.equalsIgnoreCase("Edge"))
		{
			System.setProperty("webdriver.edge.driver", "msedgedriver.exe");
			driver = new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(readPropertyFile("url"));
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}

}
