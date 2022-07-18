package Pages;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class DashboardPage extends TestBase {
	
	@FindBy (xpath = "//div[@class='avatar']") private WebElement avatar;
	@FindBy (xpath = "//h4[@class='username']") private WebElement username;
	@FindBy (xpath = "//div[@class='email']") private WebElement email;
	
	@FindBy (xpath = "//button[text()='Start investing ']") private WebElement startInvestBtn;
	@FindBy (xpath = "(//input[@icon='search'])[2]") private WebElement searchBox;
	@FindBy (xpath = "//span[@class='tradingsymbol']") private WebElement selectShare;
	@FindBy (xpath = "//button[text()='Create GTT ']") private WebElement createGTT;
	@FindBy (xpath = "//input[@label='Trigger price']") private WebElement triggerPrice;
	@FindBy (xpath = "//input[@label='Qty.']") private WebElement qty;
	@FindBy (xpath = "//input[@label='Price']") private WebElement price;
	@FindBy (xpath = "//button[normalize-space(text())='Cancel']") WebElement cancelBtn;
	
	 
	public DashboardPage ()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyUsername ()
	{
		avatar.click();
		return username.getText();
	}
	
	public String verifyEmail()
	{
		avatar.click();
		return email.getText();
	}
	
	public void placeGttOrder () throws InterruptedException, EncryptedDocumentException, IOException
	{
		startInvestBtn.click();
		//Thread.sleep(2000);
		searchBox.sendKeys(readExcelFile(0, 0));
		//Thread.sleep(2000);
		selectShare.click();
		//Thread.sleep(2000);
		createGTT.click();
		//Thread.sleep(2000);
		triggerPrice.clear();
		//Thread.sleep(2000);
		triggerPrice.sendKeys(readExcelFile(0, 1));
		//Thread.sleep(2000);
		qty.clear();
		//Thread.sleep(2000);
		qty.sendKeys(readExcelFile(0, 2));
		//Thread.sleep(2000);
		price.clear();
		//Thread.sleep(2000);
		price.sendKeys(readExcelFile(0, 3));
		//Thread.sleep(2000);
		cancelBtn.click();
		
	}

}
