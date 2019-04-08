package Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SetHeadless_Chrome {

@Test
public void myfirst()
{
// Set the chrome driver
	System.setProperty("webdriver.chrome.driver","D:\\eclipse-workspace\\TestNG\\src\\chromedriver.exe");

// Create Object of ChromeOption Class
ChromeOptions option=new ChromeOptions();

//Set the setHeadless is equal to true which will run test in Headless mode
option.setHeadless(true);

// pass the option object in ChromeDriver constructor
WebDriver driver=new ChromeDriver(option);

// Provide any url
driver.get("http://learn-automation.com");

System.out.println("Title is "+driver.getTitle());

// Close the instance
driver.quit();

}

}
