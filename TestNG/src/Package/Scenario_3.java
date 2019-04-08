package Package;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.*;


public class Scenario_3 
{
	String driverPath = "C:\\Users\\vx00783\\eclipse-workspace\\TestNG\\src\\package_TestNG\\chromedriver.exe";
	
	public WebDriver driver;
	public String username;
	public String password;
	public float int_flight_cost;
	public float int_total;
	public String comments;
	public String invoice;
	public String Booking_id;
	
	@Test(priority=1)
	public void open_Website() throws InterruptedException
	 {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vx00783\\eclipse-workspace\\Project_name\\src\\chromedriver.exe");     
        driver = new ChromeDriver();
        driver.manage().window().maximize();
		driver.get("https://phptravels.com/demo/");
		String s=driver.findElement(By.xpath("//div[@data-wow-delay='0.5s']//*[@class='col-md-8']")).getText();
		System.out.println(s);
		
		String str[]=s.split("\\s+"); 
			//		System.out.println("0 "+str[0]);
			//		System.out.println("1 "+str[1]);
			//		System.out.println("2 "+str[2]);
			//		System.out.println("3 "+str[3]);
		username=str[1];
		password=str[3];
		System.out.println("Username is = "+username);
		System.out.println("Password is = "+password);
		driver.findElement(By.xpath("//a[@href='//www.phptravels.net']")).click();
		Set <String> allelem =driver.getWindowHandles(); 
		for (String ele:allelem )
		driver.switchTo().window(ele);
			
			
			
	}
	
	@Test(priority=2)
	public void perform_Login() throws InterruptedException
	{	
		
		System.out.println();
		System.out.println();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav navbar-right hidden-sm go-left']//a[@href='javascript:void(0);']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='container']//a[@href='https://www.phptravels.net/login']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']")).sendKeys(password);
		driver.findElement(By.id("remember-me")).click();
		driver.findElement(By.xpath("//button[text()='Login' and @type='submit']")).click();
		Thread.sleep(7000);
//		WebDriverWait wait = new WebDriverWait(driver,60);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='https://www.phptravels.net/flights']")));	
		driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/flights']")).click();
	}
	
	@Test(priority=3)
		public void search_Flight() throws InterruptedException{
			//		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vx00783\\eclipse-workspace\\Project_name_java\\src\\chromedriver.exe");     
			//         WebDriver driver = new ChromeDriver();
			//         driver.manage().window().maximize();
			//		
			//			driver.get("https://www.phptravels.net/flights");
			//			Thread.sleep(5000);
			//			driver.manage().window().maximize();
			//	      	driver.get("https://www.phptravels.net/flights");
			System.out.println();
			System.out.println();
			Thread.sleep(7000);
			
	      	driver.findElement(By.xpath("//*[@id='s2id_location_from']")).click();
	      	driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("BLR");
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
	      	
	      	driver.findElement(By.xpath("//*[@id='s2id_location_to']")).click();
	      	driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys("BBI");
	      	Thread.sleep(3000);
	      	driver.findElement(By.xpath("//*[@id='select2-drop']/div/input")).sendKeys(Keys.ENTER);
	      	driver.findElement(By.xpath("//*[@id='body-section']/div[2]/div/form/div[3]/div/input")).sendKeys("2018-10-19");
	      	driver.findElement(By.xpath("//*[@id='body-section']/div[2]/div/form/div[5]/div/input")).click();
	      	Thread.sleep(5000);
	      	//driver.switchTo().alert();
	      	Select dropdown = new Select(driver.findElement(By.xpath("//*[@id='manual_flightTravelers']/div/div/div[2]/section/div/div[1]/div[1]/select")));
	      	dropdown.selectByVisibleText("2");
	      	driver.findElement(By.xpath("//*[@id='sumManualPassenger']")).click();
	      	Thread.sleep(2000);
	      	driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Search')]")).click();
	      	Thread.sleep(10000);// use explicit wait()
				
		
	
}
	@Test(priority=4)
		public void Select_Flight() throws InterruptedException 
		{
				/*System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe");     
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();
					driver.get("https://www.phptravels.net/flights/BLR/BBI/2018-10-19/0/oneway/economy/2/0/0/0/0/0");*/
			System.out.println();
			System.out.println();
			
	         System.out.println("Date Acitivated check for :");
	         System.out.println(driver.findElement(By.xpath("//*[@class='col-md-12']//li[@class='active']")).getText());
	        // ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	         for (int i=0;i<5;i++)
	         { 
	         driver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/form/div[3]/div/input")).sendKeys(Keys.PAGE_DOWN);
	         }
	         List <WebElement> price = driver.findElements(By.xpath("//span[@class='strong']"));
	         List <WebElement> Flightno = driver.findElements(By.xpath("//*[@id='load_data']//*[@class='col-md-2 col-xs-4 text-center']//small"));
	         List <WebElement> departure = driver.findElements(By.xpath("//*[@id='load_data']//*[@class='col-md-4 col-sm-3 col-xs-4']//small"));
	        
	         for (int i=0;i<price.size();i++)
	         {
	        	System.out.println("Flight Number : "+Flightno.get(i).getText()+" Departure Time : "+departure.get(i).getText()+" Price : "+price.get(i).getText());
	         }
	         System.out.println("Click ON NON STOP");
	         driver.findElement(By.xpath("//label[contains(.,'Non-Stop')]")).click();
	         //System.out.println("Wating 60 for NONSTop");
	        // WebDriverWait wait = new WebDriverWait(driver, 60);
	        // wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//label[contains(.,'Non-Stop')]"))));
	        //driver.findElement(By.xpath("//label[contains(.,'KLM')]")).click();// KLM NOT AVALABLE FOR THIS DAY 
	         Thread.sleep(5000);
	         String Flight_cost = driver.findElement(By.xpath("//tr[1]//span[@class='strong']")).getText();
	         //System.out.println("Cost of the selected flight is "+Flight_cost);
	         Flight_cost=Flight_cost.substring(0,Flight_cost.length()-1);
	         int_flight_cost=Float.valueOf(Flight_cost);
	         
	         driver.findElement(By.xpath("//tr[1]//button[@id=\"bookbtn\"]")).click();
	         
	         
	         
		}
	
	
	@Test(priority=5)
	public void Book_Flight() throws InterruptedException
	{	// Need to login for the same...just add a small login function then we can start from here 
		
			/*System.setProperty("webdriver.chrome.driver", "C:\\Users\\vx00783\\eclipse-workspace\\Project_name_java\\src\\chromedriver.exe");     
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
			driver.get("https://www.phptravels.net/login");
			driver.findElement(By.xpath("//input[@type='email' and @placeholder='Email']")).sendKeys("user@phptravels.com");
			driver.findElement(By.xpath("//input[@type='password' and @placeholder='Password']")).sendKeys("demouser");
			driver.findElement(By.id("remember-me")).click();
			driver.findElement(By.xpath("//button[text()='Login' and @type='submit']")).click();
			Thread.sleep(7000);
			driver.findElement(By.xpath("//a[@href='https://www.phptravels.net/flights']")).click();
			driver.findElement(By.xpath("//tr[1]//button[@id=\"bookbtn\"]")).click();
			*/
			
			
			
		System.out.println();
		System.out.println();
			
			
		
		
		if(driver.findElement(By.xpath("//*[@value=\"Johny\"]")).isEnabled())
			System.out.println("FAIL");
		else
			System.out.println("First name is not visible =PASSED");
		if(driver.findElement(By.xpath("//*[@value=\"Smith\"]")).isEnabled())
			System.out.println("FAIL");
		else
			System.out.println("last naem is not visible =PASSED");
		comments= "Comments By The User";
		driver.findElement(By.xpath("//*[@name=\"additionalnotes\"]")).sendKeys(comments);
		
		String total =driver.findElement(By.xpath("//*[@class=\"tr10\"]//*[@class=\"text-right\"]")).getText();
		//System.out.println(total);
		String arr[]=total.split(" ");
		//System.out.println(arr[0]);
		//System.out.println(arr[1]);
		total=arr[1].substring(0,arr[1].length()-1);
		//System.out.println(total);
		int_total=Float.valueOf(total);
		
		//System.out.println("Total additional taxes added is := "+(int_total-int_flight_cost));
		driver.findElement(By.xpath("//*[@name=\"logged\"]")).click();
		Thread.sleep(10000);
		
		
	}
	
	@Test(priority=6)
	public void Payment_Check() throws InterruptedException
	{
		
		System.out.println();
		System.out.println();
		/*System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe");     
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.phptravels.net/invoice?id=123&sessid=7205");
        
        **********.... NOT WORKING BECAUSE OF SESSION ISSUES ...*******
        */
        
        if (driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//tr[1]")).getText().contains("UNPAID"))
        	System.out.println("Status is Unpaid , Pass");
        else
        	System.out.println("FAIL");
        if (driver.findElement(By.xpath("//*[@class=\"panel-body\"]")).getText().contains(comments))
			System.out.println("Comments is appearing in the INvoice");
			else 
				System.out.println("Comments are not showing ");
        
        System.out.println(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[4]")).getText());//can comment these two lines 
        System.out.println(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[5]")).getText()); //can comment these two lines
        invoice = driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[4]")).getText() ;
    	Booking_id = driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[5]")).getText();
        
        driver.findElement(By.xpath("//*[@aria-controls=\"pay\"]")).click();
        Select dropdown = new Select(driver.findElement(By.xpath("//*[@id=\"gateway\"]")));
        dropdown.selectByIndex(3);
        System.out.println("                  :BANK DEtAILS:");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//*[@id=\"response\"]")).getText());
        		
        
		
	}
	
	
	@Test(priority=7)
	public void Payment_Done() throws InterruptedException
	{System.out.println();
	System.out.println();
		driver.findElement(By.xpath("//*[@data-module=\"flights\"]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		System.out.println("Status is : "+driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div/b")).getText());
		//*******need to capture from top and compair  **** //
       	System.out.println(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[1]//div[4]")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[1]//div[5]")).getText());
        if (invoice.equals(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[1]//div[4]")).getText()))
        System.out.println("Invoice_Id : Matched ");
        else
        	System.out.println("Invoice_ID : not matched");
        if (Booking_id.equals(driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div[1]//div[5]")).getText()))
        	System.out.println("Booking_id : Matched");
        else
        	System.out.println("Booking_ID : NOT MATCHED");
        
        driver.findElement(By.xpath("//a[@href=\"https://www.phptravels.net/\"]")).click();
        Thread.sleep(7000);
    
	}
	
	
		@Test(priority=8)
		public void Verfy_Booking () throws InterruptedException
		{
		 System.out.println();
		 System.out.println();
			driver.findElement(By.xpath("//nav//a[contains(.,'Johny')]")).click();
			driver.findElement(By.xpath("//nav//*[@href=\"https://www.phptravels.net/account/\"]")).click();
			Thread.sleep(3000);
			System.out.println("CURRENT TIME IS : " + driver.findElement(By.id("txt")).getText());
			System.out.println("Price IS : "+driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[2]/div[1]/span[2]/strong")).getText());
			System.out.println("Booking ID and Booking Code :  "+driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[2]/div[2]/span")).getText());
			System.out.println("Booking Status is : "+driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[2]/div[3]/h5")).getText());
			driver.findElement(By.xpath("//*[@id=\"bookings\"]/div[2]/div[4]/a")).click();
			Set <String> allelem =driver.getWindowHandles(); 
			for (String ele:allelem )
			{	
					driver.switchTo().window(ele);
			}
			System.out.println("Ststus in INVOICE is : "+driver.findElement(By.xpath("//*[@id=\"invoiceTable\"]//div/b")).getText());
			
			driver.close();
				System.out.println("FINALLY ENDED WELL :p");
		
			
			
			
		}
	
	
	
	
	
	}
