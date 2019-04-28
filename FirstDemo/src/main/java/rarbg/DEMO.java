package rarbg;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
public class DEMO {

	public static String resp=null;
    public static void main(String[] args) throws InterruptedException, UnirestException, AWTException, IOException, BiffException, ClassNotFoundException, SQLException
    {
        // NEED TO CHECK DATE WISE ... AND NEED TO CHECK FOR PREF DATE WISE SEARCH AND DOWNLOAD ...
    	//AND NEED TO HANDEL CAPTCHE WRONGE EXCEPTION ..BY ID
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
    	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date tdate = new Date();
		
		System.out.println("Date is " + dateFormat.format(tdate) );
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("load-extension="+"C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\3.5.2_0");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		ChromeDriver driver = new ChromeDriver(capabilities);
		
    	
		
		
		
        String baseUrl = "https://rarbgmirror.com/index70.php";
        
        driver.get(baseUrl);
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String Parent_window = driver.getWindowHandle();
        System.out.println("parent window is ="+Parent_window+" ==name==  "+driver.getTitle());
        
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
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/form/div/div/table[1]/tbody/tr[2]/td[1]/b")));	
		
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
		Sendingpost.main(args);
		System.out.println(resp);
		
		
		//Logic to separate the Captcha value
		int beginIndex=resp.indexOf("continue")+13;
		int endIndex=resp.indexOf("Enter")-5;
		String CAPTCHA=resp.substring(beginIndex, endIndex);
		System.out.println(CAPTCHA);
		driver.findElement(By.xpath("//*[@id=\"solve_string\"]")).sendKeys(CAPTCHA);
		driver.findElement(By.xpath("//*[@id=\"button_submit\"]")).click();
		System.out.println(driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/b")).getText());
		driver.findElement(By.xpath("//a[@href='/top10']")).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[4]/button")));
//		/driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[2]/button")).click();//100 MOVIES
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[4]/button")).click();//100 xxx
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/b")));
		List<WebElement> filename= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[2]/a[1]"));
		List<WebElement> date= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[3]"));
		List<WebElement> size= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[4]"));
		
		//to save all the the top10 list. 
		System.out.println("Creating EXCEL");
		CreateExlFile.start(filename, date, size);
		System.out.println("CREATING EXCEL DONE");
		
		//to send to DB.
		try{System.out.println("DB Insertion started");
		insert.main(args);
		System.out.println("DB Insertion Finished");
		
		}catch(Exception E){
		System.out.println(E);
		}
		 
		
		for(int i=2;i<102;i++)
		{
			if(driver.findElement(By.xpath("//table[@class='lista2t']/tbody/tr["+i+"]")).getText().contains(dateFormat.format(tdate).toString()))
			{	
				
				//System.out.println(i);
				driver.findElement(By.xpath("//table[@class='lista2t']/tbody/tr["+i+"]/td[2]/a[1]")).click();
				
				
				driver.findElement(By.xpath("//img[@src='https://dyncdn.me/static/20/img/magnet.gif']")).click();
				Thread.sleep(2000);
				//System.out.println("robert started");
				Robot robot = new Robot();	
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				//System.out.println("TAB Pressed");
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				//System.out.println("ENter pressed");
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
				Thread.sleep(1000);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				
				Winium_FDM.main(args);
				System.out.println((i)+" success full PaRTy YoU ShoUlD GiVe ");
		      		
				driver.navigate().back();
				
		  
		
			}
		}
		
		/**
		for(int i=2;i<102;i++)
		{
			
			driver.manage().window().maximize();
			
			if(driver.findElement(By.xpath()))
			{
			driver.findElement(By.xpath("//table[@class='lista2t']/tbody/tr["+i+"]/td[2]/a[1]")).click();
			
			
			driver.findElement(By.xpath("//img[@src='https://dyncdn.me/static/20/img/magnet.gif']")).click();
			Thread.sleep(2000);
			System.out.println("robert started");
			Robot robot = new Robot();	
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			System.out.println("TAB Pressed");
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			System.out.println("ENter pressed");
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			Winium_FDM.main(args);
			System.out.println((i-1)+" success full PaRTy YoU ShoUlD GiVe ");
	      		
			driver.navigate().back();
			
			}
		}
		
		**/
		
		
		
     //   driver.close();
        
        
       
    }
}

