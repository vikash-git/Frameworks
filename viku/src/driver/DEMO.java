package driver;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
public class DEMO {


    public static void main(String[] args)
    {
        // declaration and instantiation of objects/variables
    	//System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1308045\\workspace\\viku\\Selenium\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        String baseUrl = "https://www.naukri.com/";
        
        driver.get(baseUrl);
        String Parent_window = driver.getWindowHandle();
        System.out.println("parent window is ="+Parent_window+" ==name==  "+driver.getTitle());
           
        Set<String> handles = driver.getWindowHandles();
        
        
        for(String handle : handles) 
        {
        	driver.switchTo().window(handle);
            System.out.println(handle+" ==name==  "+driver.getTitle());
          if (driver.getTitle()=="Prokarma"||driver.getTitle()=="Amazon")
          { driver.close();}
            
            }
            
        }
        
       
       
        
        
        
        
        
        
        
        
        /*
        WebElement usname = driver.findElement(By.cssSelector("[name='username']"));
        usname.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("pwd"));
        pass.sendKeys("manager");
         driver.findElement(By.id("loginButton")).clear();
        System.out.println(pass.isDisplayed());
        
 
      
        driver.findElement(By.id("loginButton")).click();
        WebElement seltext = driver.findElement(By.linkText("Start exploring actiTIME"));
        seltext.click();
        */
        
        
        
        
      
       
       
       
    }

