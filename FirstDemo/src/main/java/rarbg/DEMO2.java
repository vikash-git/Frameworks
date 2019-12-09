package rarbg;
import java.awt.AWTException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mashape.unirest.http.exceptions.UnirestException;

import jxl.read.biff.BiffException;
public class DEMO2 {
	
	public static String resp=null;
	public static ChromeDriver driver;
    public static void main(String[] args) throws InterruptedException, UnirestException, AWTException, IOException, BiffException, ClassNotFoundException, SQLException
    {
			/***
			 * New Require Ment: at the end while DB updating, we need to write a condition that :
			 * 1) if file name is present please update respective added_date coloumn and file_size coloumn.
			 * 
			 */
		
    	
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tdate = new Date();
		
		
		System.out.println("Date is " + dateFormat.format(tdate) );
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension="+"C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\3.5.2_0");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		 driver = new ChromeDriver(capabilities);
		
    	
		
		
		
        String baseUrl = "https://rarbgmirror.com/index70.php";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(2000);
       // String Parent_window = driver.getWindowHandle();
       // System.out.println("parent window is ="+Parent_window+" ==name==  "+driver.getTitle());
        
        String originalHandle = driver.getWindowHandle();

        //Do something to open new tabs

        for(String handle : driver.getWindowHandles()) {
            if (!handle.equals(originalHandle)) {
                driver.switchTo().window(handle);
                driver.close();
            }
        }

        driver.switchTo().window(originalHandle);   
        
        
        
        
        
      driver.findElement(By.xpath("//*[@href='/top10']")).click();
      WebDriverWait wait = new WebDriverWait(driver,60);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"solve_string\"]")));	
		
      System.out.println("waited successfull ");
      
      Thread.sleep(2000);
      
      
      //taking sc
      TakesScreenshot ts = (TakesScreenshot)driver;
		File f = (File) ts.getScreenshotAs(OutputType.FILE);
		
		String str2= "./screenshots/"+"captcha"+".png";
		
		File f1 = new File (str2); 
		try {
			FileUtils.copyFile(f,f1);
			} 
		catch (IOException e)
			{
			e.printStackTrace();
			}
      
      
      
		Thread.sleep(2000);
		
		Sendingpost.main(args);//DOING POST CALLS
		System.out.println(resp);
		
		
		//Logic to separate the Captcha value
		int beginIndex=resp.indexOf("continue")+12;
		int endIndex=resp.indexOf("Enter")-4;
		String CAPTCHA=resp.substring(beginIndex, endIndex);
		System.out.println(CAPTCHA);
		driver.findElement(By.xpath("//*[@id=\"solve_string\"]")).sendKeys(CAPTCHA);
		driver.findElement(By.xpath("//*[@id=\"button_submit\"]")).click();
		
		
		
		
			if(driver.getTitle().contains("RARBG Torrents , filmi , download"))
				{
					System.out.println("Capthch Successfull");
				}
			else
				{
					Captcha_repeate();
				}
		
		System.out.println("code exe successfully");
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='/top10']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[4]/button")));
		//driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[2]/button")).click();//100 MOVIES
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[4]/button")).click();//100 xxx


		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/b")));
		List<WebElement> filename= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[2]/a[1]"));
		List<WebElement> date= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[3]"));
		List<WebElement> size= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[4]"));

		System.err.println("Creating EXCEL for DB insersetion ");
		CreateExlFile.start(filename, date, size);
		System.err.println("CREATING EXCEL DONE for DB insertion ");
		

		List<String> filenameString = new ArrayList<String>();
		for(WebElement e : filename)
		{
			filenameString.add(e.getText());
		}
		
		Com.CreateXls();
		Com.compair(filenameString,driver);
		
		
		driver.close();
		
		
		//to save all the the top10 list. 
				
				
				//to send to DB.
				try{System.err.println("DB Insertion started");
				
				insert2.main(args);// Just updating all the time and size of the file name 
				
				
				
				System.err.println("DB Insertion Finished");
				
				}catch(Exception E){
				System.out.println(E);
				}
		
		
		
       
        
       
       
    }
	private static void Captcha_repeate() throws InterruptedException, UnirestException {
		WebDriverWait wait = new WebDriverWait(driver,60);
	      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"solve_string\"]")));	
			
	      System.out.println("waited successfull ");
	      
	      Thread.sleep(2000);
	      
	      
	      //taking sc
	      TakesScreenshot ts = (TakesScreenshot)driver;
			File f = (File) ts.getScreenshotAs(OutputType.FILE);
			
			String str2= "./screenshots/"+"captcha"+".png";
			
			File f1 = new File (str2); 
			try {
				FileUtils.copyFile(f,f1);
				} 
			catch (IOException e)
				{
				e.printStackTrace();
				}
	      
	      
	      
			Thread.sleep(2000);
			
			String[] args = null;
			Sendingpost.main(args);//DOING POST CALLS
			System.out.println(resp);
			
			
			//Logic to separate the Captcha value
			int beginIndex=resp.indexOf("continue")+13;
			int endIndex=resp.indexOf("Enter")-5;
			String CAPTCHA=resp.substring(beginIndex, endIndex);
			System.out.println(CAPTCHA);
			driver.findElement(By.xpath("//*[@id=\"solve_string\"]")).sendKeys(CAPTCHA);
			driver.findElement(By.xpath("//*[@id=\"button_submit\"]")).click();
			
		
	}
}

