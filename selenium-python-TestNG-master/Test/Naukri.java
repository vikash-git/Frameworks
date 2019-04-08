package demopackage ;
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

//import org.openqa.selenium.chrome.ChromeOptions;
public class Naukri 
{ 	
	static int i =1;
	public static void main (String [] args) throws IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\vx00783\\eclipse-workspace\\Project_name_java\\src\\chromedriver.exe");
	//ChromeOptions options = new ChromeOptions();
	ChromeDriver driver = new ChromeDriver();
	driver.get("https://www.naukri.com/");
	driver.manage().window().maximize();
	Sc.capturescreen(driver,"");
	String baseID = driver.getWindowHandle();
	System.out.println("Base ID is"+baseID);
	Set<String> uniqueID = driver.getWindowHandles();
	for(String str:uniqueID)
	{
		driver.switchTo().window(str);
		Sc.capturescreen(driver,"");
		System.out.println(str+"==NAME== "+driver.getTitle());
		if(!baseID.equals(str))
			driver.close();
	}
	driver.switchTo().window(baseID);
	driver.findElement(By.linkText("LOGIN")).click();
	Sc.capturescreen(driver,"");
		Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@href='https://my.naukri.com//manager/resmanpage0.php']")).click();
	Sc.capturescreen(driver,"Create new account");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@title='I am a Fresher']")).click();
	Sc.capturescreen(driver,"Profile Page");
	//Inputing Every thin g
	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Vikash");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("kakera43@gmail.com");
	driver.findElement(By.xpath("//input[@name='password']")).sendKeys("123@kiit");
	driver.findElement(By.xpath("//input[@name='number']")).sendKeys("8260203092");
	driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Kanpur");
	driver.findElement(By.xpath("//a[@ng-click='uploader.status.resumeBox=!uploader.status.resumeBox']")).click();
	driver.findElement(By.xpath("//textarea[@name='textCV']")).sendKeys("This is my CV");
	Sc.capturescreen(driver,"filled profile");
	driver.findElement(By.xpath("//button[@name='basicDetailSubmit']")).click();
	Sc.capturescreen(driver,"Carrier Details");
	baseID = driver.getWindowHandle();
	System.out.println(baseID);
	driver.findElement(By.xpath("//span[@class='srchTxt ng-pristine ng-valid clicked ng-touched']")).click();
	driver.findElement(By.xpath("//li[@ng-repeat-done-notification='2']")).click();
	
}
	
	
		
		
	       

}  
	    


