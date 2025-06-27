package commons;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    // @an.lehoang1707@gmail.com
    // The BaseTest Class will be the one and only that initiates the Driver;
    // The BaseTest Class will centralize common methods that TestCase classes will use; whereas TestCase Classes will focus solely on simulate and assert the test cases/user behaviors
    // Common Methods are getBrowser (by various TestNG parameters use cases, get Random number, Hard Assert and Soft Assert)
    // Explicit Wait & Implicit Wait will also be declared here;

    protected WebDriver driver;
    protected WebDriverWait explicitWait;

    public WebDriver getDriver() {
        return driver;
    }

    protected int generateRandom() {
        return new Random().nextInt(9999);
    }

    protected WebDriver getBrowserDriver(String url, String browserName) {
         BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
         switch(browserList) {
             case EDGE:
                 EdgeOptions edgeOptions = new EdgeOptions();
                 driver = new EdgeDriver(edgeOptions);
                 break;
             case CHROME:
                 ChromeOptions chromeOptions = new ChromeOptions();
                 driver = new ChromeDriver(chromeOptions);
                 break;
             case FIREFOX:
                 driver = new FirefoxDriver();
                 break;
         }
         driver.get(url);
         explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
         return driver;
    }

    protected WebDriver getBrowserDriver(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch (browserList) {
            case EDGE:
                driver = new EdgeDriver();
                break;
            case CHROME:
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Browser Name is not valid");
        }

        driver.get("hardcode url");
        explicitWait = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT));
        return driver;
    }



}
