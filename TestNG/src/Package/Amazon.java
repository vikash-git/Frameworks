
package Package;



import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
public class Amazon 
     {
 	 	public static void main(String[] args) throws InterruptedException 
 	 		{
	    	   	System.out.println("launching Chrome browser"); 
	            System.setProperty("webdriver.chrome.driver", "C:\\Users\\vx00783\\eclipse-workspace\\Project_name_java\\src\\chromedriver.exe");     
	            WebDriver driver = new ChromeDriver();
	            driver.manage().window().maximize();
	          	driver.get("https://www.amazon.in/");
	          	Actions action=new Actions(driver);
	    		action.moveToElement(driver.findElement(By.xpath("//span[@class='nav-line-1' and text()='Shop by']"))).perform();
	    		Thread.sleep(3000);
	    		action.moveToElement(driver.findElement(By.xpath("//*[@id='nav-flyout-shopAll']/div[2]/span[8]"))).perform();
	    		driver.findElement(By.xpath("//span[@class='nav-text' and text()='T-shirts & Polos']")).click();
	    		
	    		
	    		Thread.sleep(3000);
	    		driver.findElement(By.xpath("//*[@id='low-price']")).sendKeys("10000");
	    		driver.findElement(By.xpath("//*[@id='high-price']")).sendKeys("11000");
	    		driver.findElement(By.xpath("//input[@aria-labelledby='a-autoid-12-announce']")).click();
	    		
	    		Select dropdown=new Select(driver.findElement(By.xpath("//*[@id='sort']")));
	    		dropdown.selectByVisibleText("Price: High to Low");
	    		
	    		Thread.sleep(3000);
	    		List <WebElement> goods = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li/div/div[4]/div[1]/a"));
	            List <WebElement> price = driver.findElements(By.xpath("//ul[@id='s-results-list-atf']/li/div/div[4]/div[2]/a/span[2]"));
	            System.out.println(goods.size());
	            System.out.println(price.size());
	            
	          
	            
	            for (int i=1;i<goods.size();i++)
	    	    {
	    	    	System.out.println("PRICE =  "+price.get(i).getText()+"  T-SHIRT NAME = "+goods.get(i).getText());
	    	    }
	            
	            driver.findElement(By.xpath("//*[@id='result_10']/div/div[2]/div/a/img")).click();
	            
	            driver.getWindowHandle();
	            Set<String> whs=driver.getWindowHandles();
	            for(String wh:whs){
	            	
	            	driver.switchTo().window(wh);
	            }
	            Thread.sleep(4000);
	            Select dropdown2=new Select(driver.findElement(By.xpath("//*[@id='native_dropdown_selected_size_name']")));
	    		dropdown2.selectByIndex(2);
	    		System.out.println("BEfore By nowCompleted");
	    		Thread.sleep(3000);
	    	    driver.findElement(By.xpath("//*[@id='buy-now-button']")).click();
	    	    
	    	    System.out.println("After Bye NOWCompleted");
	           
	            
	    	    
	    	    
	    	}
	    }
