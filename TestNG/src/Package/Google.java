package Package;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;


import org.openqa.selenium.chrome.ChromeDriver;
public class Google {


    public static void main(String[] args)
    {
        
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1308045\\workspace\\viku\\src\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
    	
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("what is my Ip ");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        //WebElement a=
        //String GDP = driver.findElement(By.className("MUxGbd u31kKd gsrt lyLwlc lEBKkf")).getText();
       
        
        System.out.print(driver.findElement(By.cssSelector(".MUxGbd.v0nnCb.lyLwlc.aLF0Z")).getText()+" = ");
        System.out.print(driver.findElement(By.cssSelector(".MUxGbd.u31kKd.gsrt.lyLwlc.lEBKkf")).getText());
        //vikash sahoo nothing
		
        
        
        
        
        
        
        
      
       
       
       
    }

}