package selenium;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Sel {
    public static void main(String[] args) throws IOException
    {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\1308045\\workspace\\viku\\src\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.close();
     }

}