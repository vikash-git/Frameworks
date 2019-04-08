package package_TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;



public class PrestigeConstruction {

	public static void main(String[] args) throws InterruptedException 
	{
		  System.out.println("launching Chrome browser"); 
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\vx00783\\Downloads\\Eclips_All\\Eclips_All_Workspace\\eclipse-workspace\\TestNG\\src\\package_TestNG\\chromedriver.exe");
	      ChromeOptions options = new ChromeOptions();
	      options.setExperimentalOption("useAutomationExtension", false);
	      
	      WebDriver driver = new ChromeDriver(options);
	      driver.manage().window().maximize();
	      JavascriptExecutor js = (JavascriptExecutor) driver;

	      driver.get("https://www.prestigeconstructions.com/");
	      driver.findElement(By.xpath("//*[@id=\"ageEnterButton\"]")).click();
	      Actions action = new Actions(driver);
	      WebElement we = driver.findElement(By.xpath(("//*[@id=\"menu-item-57644\"]/a")));
	      action.moveToElement(we).build().perform();
	      Thread.sleep(5000);
	     // driver.findElement(By.xpath(("//*[@href=\"https://www.prestigeconstructions.com/residential-portfolio/\"]"))).click();
	      driver.findElement(By.xpath(("//*[@id=\"menu-item-10086\"]/a"))).click();
	      System.out.println("**** Residental Portfolio Details *****");
	      System.out.println(driver.findElement(By.xpath("//*[@id=\"overview\"]/div[2]/div[1]")).getText());
	      System.out.println("**** Residental Portfolio Details End *****");
	      driver.findElement(By.xpath("//*[@id=\"menu-item-3330\"]/a")).click();
	      Thread.sleep(3000);
	      System.out.println();System.out.println();
	      System.out.println("**** Ready to Move In Info *****");
	      js.executeScript("window.scrollBy(0,1000)");
	      List <WebElement> allElements=driver.findElements(By.xpath("//*[@class=\"info-row\"]"));
	      System.out.println("There are total "+allElements.size()+" Ready ot move in flats present in the Bangaluru :");
	      System.out.println("");
	      for (WebElement element: allElements) 
		     {
		         System.out.println(element.getText());
		         System.out.println();
		     }
	      System.out.println("**** Ready to Move In Info End *****");
	      
	      
	      
	      
	      
	}

}
