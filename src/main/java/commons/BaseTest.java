package commons;
import commons.factoryBrowser.BrowserNotSupportedException;
import commons.factoryBrowser.ChromeDriverManager;
import commons.factoryBrowser.EdgeDriverManager;
import commons.factoryBrowser.FirefoxDriverManager;
import model.nopcommerce.RegisterPOJO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.MyAccountPO;
import pageObjects.nopcommerce.HomePO;
import pageObjects.nopcommerce.LoginPO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.RegisterPO;

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
//                 EdgeOptions edgeOptions = new EdgeOptions();
                 driver = new EdgeDriver();
                 break;
             case CHROME:
//                 ChromeOptions chromeOptions = new ChromeOptions();
                 driver = new ChromeDriver();
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

    protected WebDriver getBrowserDriverUsingFactory(String browserName) {
        BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
        switch(browserList) {
            case CHROME:
                return new ChromeDriverManager().getBrowserDriver();
            case EDGE:
                return new EdgeDriverManager().getBrowserDriver();
            case FIREFOX:
                return new FirefoxDriverManager().getBrowserDriver();
            default:
                throw new BrowserNotSupportedException(browserName);
        }
    }

    public RegisterPOJO registerFromHomePageAndLoginToMyAccount(WebDriver driver,HomePO homePO,RegisterPOJO registerPOJO) {
        RegisterPO registerPO = homePO.clickToRegisterNavButton(driver);
        String email = "anle" + generateRandom() + "@gmail.com";
        String password = GlobalConstants.NOPCOMMERCE_VALID_LOGIN_PASSWORD;

        registerPOJO.setFirstName("An" + generateRandom());
        registerPOJO.setLastName("Le");
        registerPOJO.setEmail(email);
        registerPOJO.setCompanyName("Alex");
        registerPOJO.setPassword(password);
        registerPOJO.setConfirmPassword(password);
        registerPO.inputRegisterForm(driver, registerPOJO);
        registerPO.clickToRegisterButton(driver);
        homePO = registerPO.clickToLogoutNavButton(driver);
        MyAccountPO myAccountPO = homePO.clickToMyAccountNavButton(driver);
        return registerPOJO;
    }

    public RegisterPOJO registerUser(WebDriver driver, HomePO homePO,RegisterPOJO pojo) {
        RegisterPO registerPO = homePO.clickToRegisterNavButton(driver);
        String email = "anle" + generateRandom() + "@gmail.com";
        String password = GlobalConstants.NOPCOMMERCE_VALID_LOGIN_PASSWORD;

        pojo.setFirstName("An" + generateRandom());
        pojo.setLastName("Le");
        pojo.setEmail(email);
        pojo.setCompanyName("Alex");
        pojo.setPassword(password);
        pojo.setConfirmPassword(password);

        registerPO.inputRegisterForm(driver, pojo);
        registerPO.clickToRegisterButton(driver);
//        registerPO.clickToLogoutNavButton(driver);
        registerPO.logoutUser(driver);

        return pojo;
    }



}
