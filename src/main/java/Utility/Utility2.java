package Utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import Base.TestBase;

public class Utility2 extends TestBase{
	
	public static void takeScreenshot (String name) throws IOException
	{
		File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("\\Users\\Yogesh\\eclipse-workspace\\New folder\\Project\\Screenshots\\"+ name +".png");
	    FileHandler.copy(source, dest);
	}

}
