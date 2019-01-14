package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;
public class BaseTest {

    protected WebDriver driver;

    @Parameters("browser")
    @BeforeTest
    protected WebDriver getDriver(String browser){
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")){
            System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    @AfterTest
    protected void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
