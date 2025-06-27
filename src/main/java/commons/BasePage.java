package commons;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class BasePage {
    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {

    }

    public static BasePage getBasePage() {
        return new BasePage();
    }

    public void openPageUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageUrl(WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getPageTitle(WebDriver driver) {
        return driver.getTitle();
    }

    public String getPageSource(WebDriver driver) {
        return driver.getPageSource();
    }

    public void backToPage(WebDriver driver) {
        driver.navigate().back();
    }

    public void forwardToPage(WebDriver driver) {
        driver.navigate().forward();
    }

    public void refreshCurrentPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    public Alert waitAlertPresence(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.SHORT_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert(WebDriver driver) {
        waitAlertPresence(driver).accept();
    }

    public void cancelAlert(WebDriver driver) {
        waitAlertPresence(driver).dismiss();
    }

    public String getTextAlert(WebDriver driver) {
        return waitAlertPresence(driver).getText();
    }

    public void sendKeysToAlert(WebDriver driver, String keysToSend) {
        waitAlertPresence(driver).sendKeys(keysToSend);
    }

    public String getWindowHandle(WebDriver driver) {
        return driver.getWindowHandle();
    }

    public By getByLocator(String prefixLocator) {
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            return By.id(prefixLocator.substring(3));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            return By.className(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            return By.name(prefixLocator.substring(5));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            return By.xpath(prefixLocator.substring(6));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")) {
            return By.cssSelector(prefixLocator.substring(4));
        } else {
            throw new RuntimeException("Please input valid locator.");
        }
    }

    public String castRestParameter(String locator, String... restParameter) {
        return String.format(locator,(Object[]) restParameter);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElement(getByLocator(castRestParameter(locator,restParameter)));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castRestParameter(locator,restParameter)));
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for(String runWindow : allWindows) {
            if(!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();

    }


}
