package rarbg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;
//import org.testng.annotations.Test;

public class Winium_FDM {
 
 public static void main(String [] args) throws IOException, InterruptedException, AWTException, UnreachableBrowserException
 {
	 
		 Process p = Runtime.getRuntime().exec("C:\\Users\\Vikash\\git\\Frameworks\\FirstDemo\\src\\main\\java\\rarbg\\WiniumDesktopDriver.exe");
		 System.out.println("PROCESS OPENED"); 
		 Thread.sleep(1000);
		 DesktopOptions options= new DesktopOptions();
		 options.setApplicationPath("C:\\Program Files\\FreeDownloadManager.ORG\\Free Download Manager\\fdm.exe");
		  try {
		  WiniumDriver driver=new WiniumDriver(new URL("http://localhost:9999"),options);
		  
		
		  
		
			
			Thread.sleep(3000);
			click(driver);
			System.out.println("Click on download,winium PROCESS distroyed");
		  }
		  finally
		  {
			  p.destroy();
		  }
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ALT);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_ALT);
			System.out.println("ALT+TAB PRESSED");
			
			
		
		 
		
	 }
 
 public static void click (WiniumDriver driver)
 {System.out.println("trying to click on DOWNLOAD");
	 driver.findElement(By.name("Download")).click();
 }
 
 
}
