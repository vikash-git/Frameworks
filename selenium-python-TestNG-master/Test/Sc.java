package demopackage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

class Sc
{
	public static void pause(Integer milliseconds)
	{
	    try 
	    {
	        TimeUnit.MILLISECONDS.sleep(milliseconds);
	    } 
	    catch (InterruptedException e)
	    {
	        e.printStackTrace();
	    }
	}
	public static void capturescreen(WebDriver driver, String screenShotName)
	{ 
	    if (screenShotName.equals(""))
	    {
		
			TakesScreenshot ts = (TakesScreenshot)driver;
			File f = (File) ts.getScreenshotAs(OutputType.FILE);
			String str=driver.getTitle();
			String str2= "./screenshots/"+str+".jpg";
			
			File f1 = new File (str2); 
			try {
				FileUtils.copyFile(f,f1);
				} 
			catch (IOException e)
				{
				e.printStackTrace();
				}
		}
		else
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File f = (File) ts.getScreenshotAs(OutputType.FILE);
			String str=driver.getTitle();
			String str2= "./screenshots/"+screenShotName+".png";
			
			
			File f1 = new File (str2); 
			try {
				FileUtils.copyFile(f,f1);
				} 
			catch (IOException e)
				{
				e.printStackTrace();
				}
		}
		
		
		
	       

	    
	    

	}
}

