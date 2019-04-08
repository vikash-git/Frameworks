
import java.io.File;
import java.lang.reflect.Method;


import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DummyForExReport 
{
	ExtentReports reports;
	static ExtentTest testInfo;
	ExtentHtmlReporter htmlReporter;
	@BeforeTest
	public void setup()
	{
		htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("C:\\Users\\1308045\\workspace\\viku\\")+"AutomationREport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports=new ExtentReports();
		reports.setSystemInfo("Environment", "QA");
		reports.attachReporter(htmlReporter);
			
	}
	@Test
	public static void TestCase1()
	{
		Assert.assertTrue(true);
		testInfo.log(Status.INFO,"TEstCAse For Login");
		
	}
	@Test
	public static void TestCase2()
	{
		Assert.assertTrue(false);
		testInfo.log(Status.INFO,"TestCasse For Creating Account");
		
		
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
