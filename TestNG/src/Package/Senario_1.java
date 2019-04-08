package Package;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

	
public class Senario_1
{	
	
String driverPath = "D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe";
public WebDriver driver ;
ExtentReports reports;
static ExtentTest testInfo;
ExtentHtmlReporter htmlReporter;
ITestResult result;
@BeforeTest
public void setup()
{
	htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("C:\\Users\\1308045\\workspace\\viku\\")+"AutomationREport.html"));
	htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
	reports=new ExtentReports();
	reports.setSystemInfo("Environment", "QA");
	reports.attachReporter(htmlReporter);
		
}
	
	@Test(priority=1)
	public void click_On_New_Browser_Window() throws IOException{
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	driver.get("http://toolsqa.com/automation-practice-switch-windows");
	driver.findElement(By.xpath("//button[@id='button1']")).click();
	
	Set<String> allWHs=driver.getWindowHandles();
	String parentWH=driver.getWindowHandle();
	
	
	for(String wh :allWHs)
	{	driver.switchTo().window(wh);
		if(!wh.equals(parentWH))
		{
			System.out.println("TC:01 = "+driver.getTitle());
			driver.close();
		
	     }
		
      }
	  driver.switchTo().window(parentWH);
	  testInfo.log(Status.INFO,"TEstCAse For click_On_New_Browser_Window");
	  testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,"Tc01" ));
	  
	  
    }
	  @Test(priority=2)
	  public void click_On_New_Message_Window() throws InterruptedException{
		
			driver.findElement(By.xpath("//button[@onclick='newMsgWin()']")).click();
			Thread.sleep(3000);
			Set<String> allWHs=driver.getWindowHandles();
			String parentWH=driver.getWindowHandle();
			
			
			for(String wh :allWHs){
				
				driver.switchTo().window(wh);
				
				if(!wh.equals(parentWH)){
				System.out.println("TC:02  =  "+driver.findElement(By.xpath("//body[1]")).getText());
				driver.close();
				
			     }
			
		       }
			driver.switchTo().window(parentWH);
			testInfo.log(Status.INFO,"TEstCAse For click_On_New_Message_Window");
	  }	
	  
	  
	  @Test(priority=3)
	  public void click_On_New_Browser_Tab() throws InterruptedException{
			
		  
			driver.findElement(By.xpath("//button[@onclick='newBrwTab()']")).click();
			
			Thread.sleep(3000);
			
			Set<String> allWHs=driver.getWindowHandles();
			String parentWH=driver.getWindowHandle();
			
			
			for(String wh :allWHs){
				
				driver.switchTo().window(wh);
				
				if(!wh.equals(parentWH)){
				System.out.println("TC:03  =  "+driver.getTitle());
				driver.close();
				
			     }
			
		       }
			driver.switchTo().window(parentWH);
			testInfo.log(Status.INFO,"click_On_New_Browser_Tab");
	  }	
	  
	  @Test(priority=4)
	  public void print_Random_Id(){
		 
		driver.get("http://toolsqa.com/automation-practice-switch-windows/");

		String id=driver.findElement(By.xpath("//p[contains(@id,'0.')]")).getAttribute("id");
		System.out.println("TC : 04 = "+driver.findElement(By.xpath("//p[contains(text(),'I will')]")).getText()+ " : "+id);
		testInfo.log(Status.INFO,"print_Random_Id()");
	  }
	  
	 @Test(priority=5)  
	 public void click_On_Alert_Box() throws InterruptedException{
		 
		 String parentWH=driver.getWindowHandle();
		 driver.manage().window().maximize();
		 driver.findElement(By.xpath("//button[@onclick='newAlert()']")).click();
		 System.out.println("TC : 05 =Normal Alert= "+driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();

		 
		 driver.switchTo().window(parentWH);
		 Thread.sleep(25000);   //Please scrool down manually a bit 
		 testInfo.log(Status.INFO,"click_On_Alert_Box()");
	 }
	 
	 @Test(priority=6)  
	 public void click_On_Timing_Alert() throws InterruptedException {
		 
		 String parentWH=driver.getWindowHandle();
		 //driver.manage().window().maximize();
		 
		 driver.findElement(By.xpath("//button[@onclick='newTimingAlert()']")).click();
		 Thread.sleep(5000);
		 
		 
		 
		 System.out.println("TC : 06 =Timing alert= "+driver.switchTo().alert().getText());
		 driver.switchTo().alert().accept();

		 
		 driver.switchTo().window(parentWH);
		 testInfo.log(Status.INFO,"click_On_Timing_Alert()");
		 
		 driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS );
		 
		 
	 }
	 
	@Test(priority=7)
	public void Wait_for_Button() 
	{
	 driver.get("http://toolsqa.com/automation-practice-switch-windows/");
		WebDriverWait wait = new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Visible')]")));
		System.out.println("TC07 ==Output = "+ driver.findElement(By.xpath("//button[contains(text(),'Visible')]")).getText());
		testInfo.log(Status.INFO,"Wait_for_Button() ");
	}
	
	@BeforeMethod
	public void register(Method method)
		{
		String testName=method.getName();
		testInfo=reports.createTest(testName);
						
		}
	
	@AfterMethod
	public void captureStatus(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.SUCCESS){
			testInfo.log(Status.PASS,"The Test Method naem as :"+result.getName()+"  is passed" );
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			testInfo.log(Status.FAIL,"The Test Method naem as :"+result.getName()+"  is Failled" );
			testInfo.log(Status.FAIL, "Test failuer : "+result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			testInfo.log(Status.PASS,"The Test Method naem as :"+result.getName()+"is passed" );
		}
		
	}
	
	@AfterTest
	public void cleanup()
	{
		reports.flush();
	}





}


