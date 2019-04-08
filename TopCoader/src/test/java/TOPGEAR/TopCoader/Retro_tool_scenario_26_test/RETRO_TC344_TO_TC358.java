package TOPGEAR.TopCoader.Retro_tool_scenario_26_test;



import Reusable_Methode.*;

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
import static Reusable_Methode.Utill.*;
public class RETRO_TC344_TO_TC358 
{	
	
	

//WebDriver driver= Utill.driver;
ExtentReports test_Info;
public static ExtentTest report;
ExtentHtmlReporter htmlReporter;

@BeforeTest
public void setup()
{	/***
	Report Initiation 
	*/
	htmlReporter=new ExtentHtmlReporter(new File(Path.output_Report));
	htmlReporter.loadXMLConfig(new File(Path.extent_config));
	test_Info=new ExtentReports();
	test_Info.setSystemInfo("Environment", "QA");
	test_Info.attachReporter(htmlReporter);	
	
	
	
	
}

@Test(priority = 1)
public  void RETRO__TS05_TC344() throws IOException
{		
		
		  openURL(Path.appURL);
		  addScreenshot(); // WE can add screen shot  like this syntax 
		  String expectedTitle = driver.getTitle(); 
		  String actualTitle = "Facebook – log in or sign up";
		  Assert.assertEquals(actualTitle, expectedTitle);
		  
		  
		  Utill.closeDriver();
		 
		
		
	  
	  
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	  
}

@Test(priority = 2)
public  void RETRO__TS05_TC345() throws IOException
	{ 
		 openURL("https://www.youtube.com");
		 
		 addScreenshot(); // WE can add screen shot like this syntax
		 
		 closeDriver();
		
	
	
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
}

@Test (priority = 3)
public  void RETRO__TS05_TC346()
{
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	
}

@Test (priority = 4)
public void RETRO__TS05_TC347()
{

	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	
	
}
@Test (priority = 5)
public void RETRO__TS05_TC348()
{


	
}

@Test (priority = 6)
public void RETRO__TS05_TC349()
{


	
}
@Test (priority = 7)
public void RETRO__TS05_TC350()
{


	
}
@Test (priority = 8)
public void RETRO__TS05_TC351()
{


	
}
@Test (priority = 9)
public void RETRO__TS05_TC352()
{


	
}
@Test (priority = 10)
public void RETRO__TS05_TC353()
{

	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	report.log(Status.INFO,"written inside priority 1TEstCAse For verifyHomepageTitle");
	
	
}












@BeforeMethod
public void register(Method method)
	{
	String testName=method.getName();
	report=test_Info.createTest(testName);
					
	}


@AfterMethod
public void captureStatus(ITestResult result) throws IOException 
{
	if(result.getStatus()==ITestResult.SUCCESS)
	{
		report.log(Status.PASS," written in after methodeThe Test Method naem as :"+result.getName()+" is passed" );
		
	}
	else if (result.getStatus()==ITestResult.FAILURE)
	{
		report.log(Status.FAIL,"The Test Method naem as :"+result.getName()+" is Failled" );
		report.log(Status.FAIL,"Throwing This Error : "+result.getThrowable());
	}
	else if (result.getStatus()==ITestResult.SKIP)
	{
		report.log(Status.SKIP,"The Test Method naem as :"+result.getName()+" is Skipped" );
	}
	
}

@AfterTest
public void cleanup() throws IOException
{
	test_Info.flush();
	
	Runtime runtime = Runtime.getRuntime(); 
	String[] s = new String[] {"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe","C:\\Users\\vipul\\eclipse-workspace\\TopCoader\\STMExtentReport.html"};
	runtime.exec(s);
}

}