package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Base.TestBase;

public class Utility  {
		
	public String readPropertyFile (String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("\\Users\\Yogesh\\eclipse-workspace\\New folder\\Project\\src\\main\\java\\Config\\Config.properties");
		prop.load(file);
		return prop.getProperty(value);
	}
	
	public String readExcelFile (int row, int col) throws EncryptedDocumentException, IOException
	{ 
		FileInputStream file = new FileInputStream ("\\Users\\Yogesh\\eclipse-workspace\\New folder\\Project\\TestData\\Test1.xlsx");
		Sheet data = WorkbookFactory.create(file).getSheet("Sheet4");
		return data.getRow(row).getCell(col).getStringCellValue();
	}
	
	
}
