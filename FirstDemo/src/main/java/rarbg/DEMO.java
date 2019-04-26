package rarbg;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.mashape.unirest.http.exceptions.UnirestException;
public class DEMO {

	public static String resp=null;
    public static void main(String[] args) throws InterruptedException, UnirestException, AWTException
    {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
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
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/a[2]/button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[1]/td/b")));
		List<WebElement> all= driver.findElements(By.xpath("//table[@class='lista2t']/tbody/tr/td[2]/a"));
		
		//to print all the top10 list 
		for(WebElement ele:all)
		{
			System.out.println(ele.getText());
		}
		
		
		
		
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).click();
		driver.findElement(By.xpath("/html/body/table[3]/tbody/tr/td[2]/div/table/tbody/tr[2]/td/div/table/tbody/tr[1]/td[2]/a[2]/img")).click();
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

      
      
     //   driver.close();
        
        
       
    }
}

