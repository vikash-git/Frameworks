package IGG.sample;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


/**
 * @author vipul
 *
 */
public class Read_Excel 
{
	/**
	 * @param args
	 * @throws IOException 
	 * @throws BiffException 
	 */
	public static void main(String[] args) throws BiffException, IOException {
		Workbook w = Workbook.getWorkbook(new File("C:\\Users\\vipul\\Downloads\\Book1.xls"));
		 Sheet sheet = w.getSheet(0);
		System.out.println("launching Chrome browser"); 
	      System.setProperty("webdriver.chrome.driver", "C:\\Users\\vipul\\Downloads\\chromedriver.exe");
	      //ChromeOptions options = new ChromeOptions();
	      //options.setExperimentalOption("useAutomationExtension", false);
	      
	      WebDriver driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://www.google.com/");
	      
	      System.out.println(driver.getTitle());
	    
	      for (int i = 0; i < sheet.getRows(); i++)
          {
	    	  
          	Cell cell = sheet.getCell(1, i);
          	
          	driver.findElement(By.name("q")).sendKeys(cell.getContents());
   	     driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
          	//System.out.println(cell.getContents());
   	  System.out.println(driver.getTitle());
	     driver.navigate().back();
          	
          	
          }
	      
	      
	     
	     //driver.findElement(By.name("btnK")).click();
	     System.out.println(driver.getTitle());
	     driver.navigate().back();
	     System.out.println("after back"+driver.getTitle());
	     
	    
	     
	     
	     
	      
		
		
	}

}
