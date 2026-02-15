package seleniumcodes;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.remote.RemoteWebDriver;


public class AlertgitchecksTest {
    WebDriver driver;
    String text = "sharath";

    @BeforeTest
    public void setup() throws MalformedURLException {
      //  driver.manage().window().maximize();
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--headless=new");
    	options.addArguments("--no-sandbox");
    	options.addArguments("--disable-dev-shm-usage");

    	driver = new RemoteWebDriver(
    	        new URL("http://selenium-chrome:4444"),
    	        options
    	);
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    }

    @Test
    public void testAlerts() {
        // Enter text in the input field
        driver.findElement(By.id("name")).sendKeys(text);
        
        // Click on alert button and handle alert
        driver.findElement(By.id("alertbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        // Click on confirm button and handle alert
        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();
    }

    @AfterTest
    public void tearDown() {
        driver.quit(); // Close the browser after the test
    }
}
