package Package;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
public class newclass 
{
    public String baseUrl = "https://www.google.com";
    String driverPath = "C:\\Users\\1308045\\workspace\\viku\\src\\selenium\\chromedriver.exe";
    public WebDriver driver ; 
     @AfterTest                            //Jumbled
      public void terminateBrowser()
      {
          driver.close();
      }
     @BeforeTest                            //Jumbled
      public void launchBrowser() 
      {
          System.out.println("launching firefox browser"); 
          System.setProperty("webdriver.firefox.marionette", driverPath);
          driver = new ChromeDriver();
          driver.get(baseUrl);
      }
      @Test                                //Jumbled
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          Assert.assertEquals(actualTitle, expectedTitle);
     }
      
}