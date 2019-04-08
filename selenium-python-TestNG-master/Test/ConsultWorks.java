/**
 * 
 */
package demopackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

/**
 * @author vx00090
 *
 */
public class ConsultWorks 
{

	
	public WebDriver driver;
	
	public ConsultWorks()
	{
		// TODO Auto-generated constructor stub
	}
	
	private void init(){
		System.setProperty("webdriver.ie.driver", "C:\\Users\\vx00783\\workspace\\vikash\\driver\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
	}
	
	private void launchCW(){
		
		driver.manage().window().maximize();
		//driver.get("http://dahe08sv01kwd.ash.pwj.com:8080/CWM/launch/cw3start.html");
		//driver.get("http://dahe08sv01kwd.ash.pwj.com:8080/GCS/servlet/gcsCreate?UUNM=pe06003&ENTY=A&ACCN=PT00020");
		//driver.get("http://dahe08sv01kwd.ash.pwj.com:8080/GAS/pagegroup/HomePage?PTFM=CWV2&ENV=CE");
		//driver.get("http://cwv2proxy.lnh.bislab.pwj.com:8080/GCS/servlet/gcsCreate?UUNM=se06893");
				
		driver.get("http://cwv2proxy.lnh.bislab.pwj.com:8080/CWM/launch/cw3start.html");
		String window = driver.getWindowHandle();
		//driver.get("http://cwv2proxy.lnh.bislab.pwj.com:8080/CWM/launch/cw3start.html?SCW=IFR");
		//driver.findElement(By.name("UUNM")).sendKeys("se06893");
		//driver.findElement(By.name("PASSWORD")).sendKeys("Mart4433");
		
		
		//driver.get("http://cwv2proxy.lnh.bislab.pwj.com:8080/CW/servlet/MainServlet?UUNM=se06893");
		
		JavascriptExecutor js= null;
		if (driver instanceof JavascriptExecutor) 
		{
		    js = (JavascriptExecutor)driver;
		} // else throw...
		//js.executeScript("document.forms['login'].style.backgroundColor='red'");
		//js.executeScript("alert(document.forms['login'].style.backgroundColor)");
		//js.executeScript("setForm('se06893','Mart4433')");
		//js.executeScript("loadGCSW()");

		
		
				// later on...
		try {
			Thread.sleep(3000);
			//js.executeScript("setForm()");
			js.executeScript("document.getElementById('cw2dummy_1').contentWindow.sb()");
			//Thread.sleep(3000);
			//driver.switchTo().window(window);
			//js.executeScript("openCW2()");
			//js.executeScript("alert(document.getElementById('cw2dummy'))");
			Thread.sleep(5000);
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File("C:\\Users\\vx00783\\Documents\\workspace\\SeleniumAutomation\\Test.png"));
			//driver.switchTo().window(window);
			//js.executeScript("loadMainW()");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	

	
	public static void main(String[] args) {
		ConsultWorks cwObj  = new ConsultWorks();
		cwObj.init();
		
		cwObj.launchCW();

	}

}
