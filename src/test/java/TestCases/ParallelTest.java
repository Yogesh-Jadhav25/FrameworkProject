package TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ParallelTest {
	
	@Test
	public void openFb()
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver =  new ChromeDriver ();
    driver.manage().window().maximize();
    driver.get("https://www.facebook.com/");
    driver.close();
	}
	
	@Test
	public void openAmazon()
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver =  new ChromeDriver ();
    driver.manage().window().maximize();
    driver.get("https://www.amazon.in/");
    driver.close();
	}
	
	@Test
	public void openFlipkart()
	{
	System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    WebDriver driver =  new ChromeDriver ();
    driver.manage().window().maximize();
    driver.get("https://www.flipkart.com/");
    driver.close();
	}

}
