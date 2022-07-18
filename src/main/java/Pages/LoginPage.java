package Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	
	@FindBy(xpath = "//img[@alt='Kite']") private WebElement kiteLogo;
	@FindBy(xpath = "//img[@alt='Zerodha']") private WebElement zerodhaLogo;
	@FindBy(xpath = "//input[@id='userid']") private WebElement userIdTextBox;
	@FindBy(xpath = "//input[@id='password']") private WebElement passTextBox;
	@FindBy(xpath = "//button[@type='submit']") private WebElement loginBtn;
	@FindBy(xpath = "//input[@id='pin']") private WebElement pinBtn;
	@FindBy(xpath = "//button[@type='submit']") private WebElement continueBtn;
	@FindBy(xpath = "//h1[@class='page-title big']") private WebElement text;
	
	public LoginPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitle ()
	{
		return driver.getTitle();
	}
	
	public boolean verifyKiteLogo ()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean verifyZerodhaLogo ()
	{
		return kiteLogo.isDisplayed();
	}
	
	public boolean openToApp () throws IOException, InterruptedException
	{
		userIdTextBox.sendKeys(readPropertyFile("userid"));
		//Thread.sleep(1000);
		passTextBox.sendKeys(readPropertyFile("password"));
		//Thread.sleep(1000);
		loginBtn.click();
		//Thread.sleep(1000);
		pinBtn.sendKeys(readPropertyFile("pin"));
		//Thread.sleep(1000);
		continueBtn.click();
		//Thread.sleep(3000);
		
		return text.isDisplayed();
		
	}

}
