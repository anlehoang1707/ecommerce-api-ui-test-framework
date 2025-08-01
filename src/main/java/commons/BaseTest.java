package commons;
import commons.factoryBrowser.BrowserNotSupportedException;
import commons.factoryBrowser.ChromeDriverManager;
import commons.factoryBrowser.EdgeDriverManager;
import commons.factoryBrowser.FirefoxDriverManager;
import model.nopcommerce.users.AddAddressPOJO;
import model.nopcommerce.users.RegisterPOJO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import pageObjects.nopcommerce.users.MyAccountPO;
import pageObjects.nopcommerce.users.HomePO;
import pageObjects.nopcommerce.users.RegisterPO;

import java.io.File;
import java.time.Duration;
import java.util.Random;

public class BaseTest {
    // @an.lehoang1707@gmail.com
    // The BaseTest Class will be the one and only that initiates the Driver;
    // The BaseTest Class will centralize common methods that TestCase classes will use; whereas TestCase Classes will focus solely on simulate and assert the test cases/user behaviors
    // Common Methods are getBrowser (by various TestNG parameters use cases, get Random number, Hard Assert and Soft Assert)
    // Explicit Wait & Implicit Wait will also be declared here;

    @BeforeSuite
    public void deleteFileInReport() {
        // Remove all file in ReportNG screenshot (image)

        // Remove all file in Allure attachment (json file)
        deleteAllFileInFolder("allure-results");
    }

    public void deleteAllFileInFolder(String folderName) {
        try {
            String pathFolderDownload = GlobalConstants.RELATIVE_PROJECT_PATH + File.separator + folderName;
            System.out.println("Deleting files in: " + pathFolderDownload);
            File file = new File(pathFolderDownload);
            File[] listOfFiles = file.listFiles();
            if (listOfFiles.length != 0) {
                for (int i = 0; i < listOfFiles.length; i++) {
                    if (listOfFiles[i].isFile() && !listOfFiles[i].getName().equals("environment.properties")) {
                        new File(listOfFiles[i].toString()).delete();
                    }
                }
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }

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
        RegisterPO registerPO = homePO.clickToRegisterNavLink(driver);
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
        MyAccountPO myAccountPO = homePO.clickToMyAccountNavLink(driver);
        return registerPOJO;
    }

    public RegisterPOJO registerUser(WebDriver driver, HomePO homePO,RegisterPOJO pojo) {
        RegisterPO registerPO = homePO.clickToRegisterNavLink(driver);
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

    protected static AddAddressPOJO getBillingAddressPOJO() {
        AddAddressPOJO billingAddressPOJO = new AddAddressPOJO();
        billingAddressPOJO.setFirstName("Automation");
        billingAddressPOJO.setLastName("FC");
        billingAddressPOJO.setEmail("automationfc.vn@gmail.com");
        billingAddressPOJO.setCompany("Automation FC");
        billingAddressPOJO.setCountry("United States of America");
        billingAddressPOJO.setStateProvince("Alaska");
        billingAddressPOJO.setCity("Da Nang");
        billingAddressPOJO.setAddress1("123/04 Le Lai");
        billingAddressPOJO.setAddress2("234/05 Hai Phong");
        billingAddressPOJO.setZipPostalCode("550000");
        billingAddressPOJO.setPhoneNumber("0123456789");
        billingAddressPOJO.setFaxNumber("0987654321");
        return billingAddressPOJO;
    }

    protected static AddAddressPOJO getShippingAddressPOJO() {
        AddAddressPOJO shippingAddressPOJO = new AddAddressPOJO();
        shippingAddressPOJO.setFirstName("Auto");
        shippingAddressPOJO.setLastName("Mation");
        shippingAddressPOJO.setEmail("automationfc.vn@gmail.com");
        shippingAddressPOJO.setCompany("Automation FC");
        shippingAddressPOJO.setCountry("United States of America");
        shippingAddressPOJO.setStateProvince("Alaska");
        shippingAddressPOJO.setCity("Ho Chi Minh");
        shippingAddressPOJO.setAddress1("123/04 Le Lai");
        shippingAddressPOJO.setAddress2("234/05 Hai Phong");
        shippingAddressPOJO.setZipPostalCode("550000");
        shippingAddressPOJO.setPhoneNumber("0123456789");
        shippingAddressPOJO.setFaxNumber("0987654321");
        return shippingAddressPOJO;
    }



}
