package demopackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DEmo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try{
			//DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			//capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			
			//Invoke IE Web Driver
			System.setProperty("webdriver.ie.driver", "C:\\Users\\vx00783\\Downloads\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver(/*capabilities*/);
			System.out.println("IE started");	
			driver.manage().window().maximize();
			
			//Input MOF Stand Alone URL	        
	        driver.get("http://cwv2proxy.lnh.bislab.pwj.com:70/CWM/launch/support.jsp");
	        
//	        String pageTitle = driver.getTitle();
//	        System.out.println(pageTitle);
	        
	       /* 
	       	// Find the text input element(User Name) by its name
	       	driver.findElement(By.name("UUNM")).isEnabled();
	        
	       	WebDriverWait wait = new WebDriverWait(driver, 20);
	       	WebElement UserName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.ByName.name("UUNM")));
	       	System.out.println("element  "+UserName.getText());	           
	        WebElement element = driver.findElement(By.name("UUNM"));
	        String tagName= UserName.getTagName();
	        System.out.println(tagName);
	        UserName.sendKeys("se06886");
	        System.out.println(driver.findElement(By.name("UUNM")).getText());
	        System.out.println("element1  "+UserName.getText());
	       */

	        driver.findElement(By.name("UUNM")).sendKeys("se06886");
	        driver.findElement(By.name("PASSWORD")).sendKeys("Moftest7");
	        
//	        driver.findElement(By.name("login")).click();
//        WebElement Password = driver.findElement(By.name("PASSWORD"));
//	        
//	        Password.sendKeys("Moftest7");
	        
//	        System.out.println("element2  "+Password.getText());

	        //Login button Click
	        driver.findElement(By.xpath("//input[@value='Login'][@name='login'][@class='button']")).click();
	        
	        //WebDriverWait wait1 = new WebDriverWait(driver,30);
	        
	        Thread.sleep(20000);
	        
	        //System.out.println("Page title is: " + driver.getTitle());
	        
	        //Close the browser
	        //driver.quit();

		}catch(Exception  e)
		{
				e.printStackTrace();		
			//System.out.println("Exception : " + e.getMessage());
			//System.out.println("stacktrace : " + e.getStackTrace());
					
		};

	}

}
