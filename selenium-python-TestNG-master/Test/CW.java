package demopackage;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.lang.*;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Select;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;


class CW 
{
	public static void main(String[] args) throws InterruptedException 
	{	
		//System.setProperty("webdriver.ie.driver", "C:\\Users\\vx00783\\workspace\\vikash\\driver\\IEDriver.exe");
		//WebDriver driver=new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vx00783\\eclipse-workspace\\Project_name_java\\src\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://cwv2proxy.lnh.bislab.pwj.com:8080/CWM/launch/cw3start.html");
		String Base_win = driver.getWindowHandle();
						
		
		Sc.pause(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cw2dummy_1']")));
		
		driver.findElement(By.xpath("//input[@name='USID']")).clear();
		driver.findElement(By.xpath("//input[@name='USID']")).sendKeys("aaac");
		driver.findElement(By.xpath("//input[@name ='UUNM']")).clear();
		driver.findElement(By.xpath("//input[@name='UUNM']")).sendKeys("de05845");
		driver.findElement(By.xpath("//input[@name='SUBMIT']")).click();
		
		System.out.println("Base id ="+Base_win);
		
		
		Sc.pause(10000);		
		System.out.println("timeout for 3sec ");
		Set<String> uniqueID = driver.getWindowHandles();
		String CWrks_Window_Id="";
		for(String str:uniqueID)
		{
			driver.switchTo().window(str);
		
		if (driver.getTitle().equals("ConsultWorks User: de05845"))
		{
			CWrks_Window_Id=str;
		}
		
		}
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='cwv2navigation']")));
		
		driver.findElement(By.id("1841")).click();
		driver.switchTo().parentFrame();
		
		driver.findElement(By.xpath("//a[@id='4841']")).click();
		driver.findElement(By.xpath("//a[@id='5837']")).click();
		Sc.pause(7000);
		driver.switchTo().frame("IFR_1841");
		Select dropdown = new Select(driver.findElement(By.id("fundId")));//Create a Select variable 
		dropdown.selectByVisibleText("CAMPBELL TRUST FUND");
		//dropdown.selectByIndex(2);
				
		/*
		 System.out.println("*********LIST OF WEB ELEMENTS IN THE DROPDOWN ******");
		List<WebElement> dd = dropdown.getOptions();
		for (int j = 0; j < dd.size(); j++) 
		{	System.out.println(dd.get(j).getText());	}
		*/
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
				
		
		
		driver.findElement(By.partialLinkText("47221")).click();
		Sc.pause(2000);
		uniqueID = driver.getWindowHandles();
		for(String str:uniqueID)
		{			
			System.out.println(str+"==NAME== "+driver.getTitle());
				
		}
		
		
		
		

	}
	
	
	
	

}
