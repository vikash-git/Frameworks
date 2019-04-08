package Package;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class DummyForExReport 
{	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";
	String driverPath = "D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe";
	public WebDriver driver ; 

	ExtentReports reports;
	static ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	public String SC_Path; // dint use oit 
	public int i=1; // to make every screen shot different
	
@BeforeTest
	public void setup()
	{	
		htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("C:\\Users\\1308045\\workspace\\viku\\")+"AutomationREport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports=new ExtentReports();
		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);			
	}
	
@Test(priority = 1)
	public  void verifyHomepageTitle() throws IOException
	{		
		  System.out.println("launching firefox browser"); 
	      System.setProperty("webdriver.chrome.driver", driverPath);
	      driver = new ChromeDriver();
	      driver.get(baseUrl);
	      driver.manage().window().maximize();
	      String expectedTitle = driver.getTitle();
	      String actualTitle = "Welcome: Mercury Tours";
	      Assert.assertEquals(actualTitle, expectedTitle);
	      testInfo.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
		  testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i)));i++; // WE can add screen shot like this syntax
		  
		  
		  
		  
	}
	
@Test(priority = 2)
	public  void creataccount() throws IOException
	{	  testInfo.log(Status.INFO,"TEstCAse started executing for createaccount ");
		  driver.findElement(By.xpath("//a[@href='register.php']")).click();          		 testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i)));i++;
		  driver.findElement(By.name("firstName")).sendKeys("Vikash");        				testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,"i" ));i++;
		  driver.findElement(By.name("lastName")).sendKeys("Sahoo");						testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("phone")).sendKeys("8260203091");						testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("userName")).sendKeys("vikash.sahoo@gmail.com");		testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("address1")).sendKeys("Qrtno-b/1057,nalconagar,");		testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("city")).sendKeys("Angul");							testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("state")).sendKeys("Odisha");							testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("postalCode")).sendKeys("vikash.sahoo@gmail.com");		testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  Select dropdown = new Select(driver.findElement(By.name("country")));
		  dropdown.selectByValue("INDIA");													testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("email")).sendKeys("cuttack110");						testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("password")).sendKeys("123@kiit");						testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("confirmPassword")).sendKeys("123@kiit");				testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  driver.findElement(By.name("submit")).click();									testInfo.addScreenCaptureFromPath(Sc.add_Screen_toReport(driver,Integer.toString(i) ));i++;
		  Sc.capturescreen(driver,"details");
		  testInfo.log(Status.INFO,driver.findElement(By.xpath("//font[contains(.,'Thank you for registering')]")).getText());
		  driver.close();
		  
	}
	
	@Test (priority = 3)
	public  void TC03()
	{
		testInfo.log(Status.DEBUG,"TC03");
	}
	
	@Test (priority = 4)
	public void TC04()
	{
	testInfo.log(Status.PASS,"TC04");
	
		
	}
	@BeforeMethod
	public void register(Method method)
		{
		String testName=method.getName();
		testInfo=reports.createTest(testName);
						
		}
	
	
	@AfterMethod
	public void captureStatus(ITestResult result) throws IOException 
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			testInfo.log(Status.PASS," written in after methodeThe Test Method naem as :"+result.getName()+"  is passed" );
			
		}
		else if (result.getStatus()==ITestResult.FAILURE)
		{
			testInfo.log(Status.FAIL,"The Test Method naem as :"+result.getName()+"  is Failled" );
			testInfo.log(Status.FAIL,"Throwing This Error : "+result.getThrowable());
		}
		else if (result.getStatus()==ITestResult.SKIP)
		{
			testInfo.log(Status.SKIP,"The Test Method naem as :"+result.getName()+"is Skipped" );
		}
		
	}
	
	@AfterTest
	public void cleanup()
	{
		reports.flush();
	}

}
