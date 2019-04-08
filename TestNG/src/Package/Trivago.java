
	     
	     package Package;


	     import java.util.List;

	     import org.openqa.selenium.By;
	     import org.openqa.selenium.Keys;
	     import org.openqa.selenium.WebDriver;
	     import org.openqa.selenium.WebElement;
	     import org.openqa.selenium.chrome.ChromeDriver;
	     import org.openqa.selenium.chrome.ChromeOptions;
	     import org.testng.Assert;

	     public class Trivago 
	     {
	     	/**
	     	 * @param args
	     	 */
	     	public static void main(String[] args) {
	     		
	     		System.out.println("launching Chrome browser"); 
	     	      System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe");
	     	      //ChromeOptions options = new ChromeOptions();
	     	      //options.setExperimentalOption("useAutomationExtension", false);
	     	      
	     	      WebDriver driver = new ChromeDriver();
	     	      driver.manage().window().maximize();
	     	      driver.get("https://www.trivago.in/");
	     	      
	     	     System.out.println(driver.getTitle());
	     	     driver.findElement(By.xpath("//input[@name='sQuery']")).sendKeys("Bengaluru");
	     	     driver.findElement(By.xpath("//input[@name='sQuery']")).sendKeys(Keys.ENTER);
	     	     Sc.pause(3000); 
	     	   /*  driver.navigate().refresh();
	     	     Sc.pause(2000);*/
	     	     //driver.findElement(By.xpath("//svg[@xmlns='http://www.w3.org/2000/svg']")).click();
	     	     // driver.findElement(By.xpath("//span[text()='Check-in']")).click();
	     	     // driver.findElement(By.xpath("//span[text()='Check-in']")).click();
	     	     // Sc.pause(2000);
	     	     //driver.findElement(By.xpath("//span[class='icon-ic cal-btn-ic icon-rtl']")).click();
	     	     // Sc.pause(2000);
	     	     driver.findElement(By.cssSelector(".cal-btn-next")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.cssSelector(".cal-btn-next")).click();
	     	     // driver.findElement(By.cssSelector(".icon-ic.cal-btn-ic.icon-rtl")).click();
	     	     // Sc.pause(2000);
	     	     // driver.findElement(By.cssSelector(".icon-ic.cal-btn-ic.icon-rtl")).click();
	     	     driver.findElement(By.xpath("//time[@datetime='2018-12-06']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//time[@datetime='2018-12-09']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//span[text()='Single room']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//button[text()='Done']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//strong[text()='Guest rating']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//span[text()='Excellent']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//button[text()='Done']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//strong[text()='Property type' or text()='Hotel class']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//input[@value='1']")).click();
	     	     Sc.pause(2000);
	     	     driver.findElement(By.xpath("//button[text()='Done']")).click();
	     	     Sc.pause(2000);
	     	     
	     	     /*List <WebElement> allElements = driver.findElements(By.xpath("//ol[@id='js_itemlist']/li/article/div[1]/div[3]/div/div/h3"));
	     	     if(allElements.size()==0)
	     	     {	 allElements = driver.findElements(By.xpath("//ol[@id='js_itemlist']/li/article/div[1]/div[2]/div/div/h3"));}
	     	     */
	     	     
	     	     List <WebElement> allElements = driver.findElements(By.xpath("//h3[@dir='ltr']"));
	     	     
	     	    		 
	     	     System.out.println("There are total "+allElements.size()+" 5star Hotels present in the Bangaluru Between 2018-12-06 to 2018-12-06 ");
	     	     System.out.println("====================");
	     	     	     
	     	     for (WebElement element: allElements) 
	     	     {
	     	         System.out.println(element.getText());
	     	     }
	     	     
	     	
	     	     
	     	     
	     	     
	     	      
	     		
	     		
	     	}

	     }
	     