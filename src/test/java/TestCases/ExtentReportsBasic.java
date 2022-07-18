package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasic {
	
	public static WebDriver driver;
	
	public static void main(String[] args) {
        
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        ExtentTest test = extent.createTest("MyFirstTest", "rediff test");
        
	    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
	    driver.manage().window().maximize();
		   
	    test.log(Status.INFO, "Strarting Test Case");
		   
        driver.get("https://is.rediff.com/signup/register/");
        test.pass("Navigate to Rediff website");
        
        driver.findElement(By.xpath("//input[@id='fullname']")).sendKeys("Yogesh");
        test.pass("Enter the text in fullname Text Box");
        
        driver.close();
        test.pass("Browser close");
        
        test.info("Test Completed");
        
        extent.flush();
	}
}
