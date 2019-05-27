package lambda_test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;




import java.net.MalformedURLException;
import java.net.URL;
 
 
public class TestNGTodo {
     public String username = "vikashkumarsahoo";
    public String accesskey = "KpjNBch0ljBiyHnOonZlAG3q8HQTq2LxGIUMXJWu0fvxsZtxO8";
    public static RemoteWebDriver driver = null;
    public String gridURL = "@hub.lambdatest.com/wd/hub";
    boolean status = false;
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    @BeforeClass
    @org.testng.annotations.Parameters(value={"browser","version","platform"})
    public void setUp() throws Exception {
       DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("version", "70.0");
        capabilities.setCapability("platform", "win10"); // If this cap isn't specified, it will just get the any available one
        capabilities.setCapability("build", "LambdaTestSampleApp");
        capabilities.setCapability("name", "LambdaTestJavaSample");
        capabilities.setCapability("network", true); // To enable network logs
        capabilities.setCapability("visual", true); // To enable step by step screenshot
        capabilities.setCapability("video", true); // To enable video recording
        capabilities.setCapability("console", true); // To capture console logs
        try {
            driver = new RemoteWebDriver(new URL("https://" + username + ":" + accesskey + gridURL), capabilities);
        } catch (MalformedURLException e) {
            System.out.println("Invalid grid URL");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
  
    
    @Test(priority = 1)
    public void verifyHomepageTitle() 
    {
         
        
        driver.get(baseUrl);
        
        String expectedTitle = driver.getTitle();
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
         
            
        
    }
    @Test(priority = 2)
    public void creataccount() 
    {
  	  driver.findElement(By.xpath("//a[@href='register.php']")).click();
  	  driver.findElement(By.name("firstName")).sendKeys("Vikash");
  	  driver.findElement(By.name("lastName")).sendKeys("Sahoo");
  	  driver.findElement(By.name("phone")).sendKeys("8260203091");
  	  driver.findElement(By.name("userName")).sendKeys("vikash.sahoo@gmail.com");
  	  driver.findElement(By.name("address1")).sendKeys("Qrtno-b/1057,nalconagar,");
  	  driver.findElement(By.name("city")).sendKeys("Angul");
  	  driver.findElement(By.name("state")).sendKeys("Odisha");
  	  driver.findElement(By.name("postalCode")).sendKeys("vikash.sahoo@gmail.com");
  	  Select dropdown = new Select(driver.findElement(By.name("country")));
  	  dropdown.selectByValue("INDIA");
  	  driver.findElement(By.name("email")).sendKeys("cuttack110");
  	  driver.findElement(By.name("password")).sendKeys("123@kiit");
  	  driver.findElement(By.name("confirmPassword")).sendKeys("123@kiit");
  	  driver.findElement(By.name("submit")).click();
  	  Sc.capturescreen(driver,"details");
  	//span[contains(text(), 'Thank you for registering')]   
  	  String str=driver.findElement(By.xpath("//font[@face='Arial, Helvetica, sans-serif']" )).getText();
  	  System.out.println(str);
        
        
    }
  
    @AfterClass
    public void tearDown() throws Exception {
       if (driver != null) {
            ((JavascriptExecutor) driver).executeScript("lambda-status=" + status);
            driver.quit();
        }
    }
}