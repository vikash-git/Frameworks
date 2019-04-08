package Reusable_Methode;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import TOPGEAR.TopCoader.Retro_tool_scenario_26_test.RETRO_TC344_TO_TC358;


public class Utill {
	public static WebDriver driver;
	public static int i=1; // to make every screen shot different

	
	public static void pause(Integer milliseconds)   // Pause Methode
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
	
	public static void capturescreen(WebDriver driver, String screenShotName) //Capture Screen Methode
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
			//String str=RETRO_TC344_TO_TC358.driver.getTitle();
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
	
	public static String add_Screen_toReport(String screenShotName) //Return Sting in report
	    	    
	    {	
		    if (screenShotName.equals(""))
		    {
			
				TakesScreenshot ts = (TakesScreenshot)driver;
				File f = (File) ts.getScreenshotAs(OutputType.FILE);
				String str=driver.getTitle();
				String str2= "./test-output/screenshots/"+str+".png";
				
				File f1 = new File (str2); 
				try {
					FileUtils.copyFile(f,f1);
					} 
				catch (IOException e)
					{
					e.printStackTrace();
					}
				return str2;
			}
			else
			{
				TakesScreenshot ts = (TakesScreenshot)driver;
				File f = (File) ts.getScreenshotAs(OutputType.FILE);
				//String str=RETRO_TC344_TO_TC358.driver.getTitle();
				String str2= "./test-output/screenshots/"+screenShotName+".png";
				
				
				File f1 = new File (str2); 
				try {
					FileUtils.copyFile(f,f1);
					} 
				catch (IOException e)
					{
					e.printStackTrace();
					}
				return str2;
			}
	    	
	    	
	    	
	    	
	    	
	    }
		
	public static void openURL(String URL)
	{	System.out.println("launching Chrome browser"); 
	System.setProperty("webdriver.chrome.driver", Path.driverPath);
	driver = new ChromeDriver();
	driver.get(URL);
    driver.manage().window().maximize();
    
		
		
	}
	
	public static void addScreenshot() throws IOException
	{
		RETRO_TC344_TO_TC358.report.addScreenCaptureFromPath(Utill.add_Screen_toReport(Integer.toString(i)));i++; // WE can add screen shot like this syntax
	}
	

	public static void closeDriver() {
		driver.close(); 
		
		
	}
		
	       

	    
}
