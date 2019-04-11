package demopackage;
import org.testng.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;



public class Mercury_Torous 
{ 
	public static void main(String[] args) 
	{
		 String baseUrl = "http://demo.guru99.com/test/newtours/";
		    String driverPath = "C:\\Users\\vx00783\\eclipse-workspace\\Project_name\\src\\chromedriver.exe";
		     WebDriver driver ; 
		     
		      System.out.println("launching firefox browser"); 
		      System.setProperty("webdriver.chrome.driver", driverPath);
		      driver = new ChromeDriver();
		      driver.get(baseUrl);
		      
		      String expectedTitle = driver.getTitle();
		      String actualTitle = driver.getTitle();
		      Assert.assertEquals(actualTitle, expectedTitle);
		      driver.findElement(By.xpath("//a[@href='register.php']")).click();
			  driver.findElement(By.name("firstName")).sendKeys("Vikash");
			  driver.findElement(By.name("lastName")).sendKeys("Sahoo");
			  driver.findElement(By.name("phone")).sendKeys("8260203091");
			  driver.findElement(By.name("userName")).sendKeys("vikash.sahoo@gmail.com");
			  driver.findElement(By.name("address1")).sendKeys("Qrtno-b/1057,nalconagar,");
			  driver.findElement(By.name("city")).sendKeys("Angul");
			  driver.findElement(By.name("state")).sendKeys("Odisha");
			  driver.findElement(By.name("postalCode")).sendKeys("vikash.sahoo@gmail.com");
			  Select dropdown = new Select(driver.findElement(By.name("country")));
			  dropdown.selectByValue("INDIA");
			  driver.findElement(By.name("email")).sendKeys("cuttack110");
			  driver.findElement(By.name("password")).sendKeys("123@kiit");
			  driver.findElement(By.name("confirmPassword")).sendKeys("123@kiit");
			  driver.findElement(By.name("submit")).click();
			  Sc.capturescreen(driver,"details");
			  driver.close();
	
	}
   
      
      
 
}