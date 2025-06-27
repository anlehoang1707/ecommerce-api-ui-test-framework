package commons;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.Date;
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

    public void sleepInSeconds(int timeInSeconds) throws InterruptedException {
        Thread.sleep(timeInSeconds * 1000);
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

    public By getByLocator(String prefixLocator, String... restParatemeter) {
        if (prefixLocator.toUpperCase().startsWith("ID")) {
            return By.id(String.format(prefixLocator.substring(3), restParatemeter));
        } else if (prefixLocator.toUpperCase().startsWith("CLASS")) {
            return By.className(String.format(prefixLocator.substring(6), restParatemeter));
        } else if (prefixLocator.toUpperCase().startsWith("NAME")) {
            return By.name(String.format(prefixLocator.substring(5), restParatemeter));
        } else if (prefixLocator.toUpperCase().startsWith("XPATH")) {
            return By.xpath(String.format(prefixLocator.substring(6), restParatemeter));
        } else if (prefixLocator.toUpperCase().startsWith("CSS")) {
            return By.cssSelector(String.format(prefixLocator.substring(4), restParatemeter));
        } else {
            throw new RuntimeException("Please input valid locator.");
        }
    }

    public String castRestParameter(String locator, String... restParameter) {
        return String.format(locator, (Object[]) restParameter);
    }

    public WebElement getElement(WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getElement(WebDriver driver, String locator, String... restParameter) {
        return driver.findElement(getByLocator(castRestParameter(locator, restParameter)));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListElements(WebDriver driver, String locator, String... restParameter) {
        return driver.findElements(getByLocator(castRestParameter(locator, restParameter)));
    }

    public void switchToWindowByID(WebDriver driver, String parentID) {
        Set<String> allWindows = driver.getWindowHandles();
        for (String runWindow : allWindows) {
            if (!runWindow.equals(parentID)) {
                driver.switchTo().window(runWindow);
                break;
            }
        }
    }

    public void switchToWindowByTitle(WebDriver driver, String title) {
        Set<String> allWindows = driver.getWindowHandles();

    }

    public void clickToElement(WebDriver driver, String locator) {
        getElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... restParameter) {
        getElement(driver, locator, restParameter).click();
    }

    public void clickToElementByJS(WebDriver driver, String locator) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement(driver, locator));
        sleepInSeconds(2);
    }

    public void clickToElementByJS(WebDriver driver, String locator, String... restParameter) throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", getElement(driver, locator, restParameter));
        sleepInSeconds(2);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String keysToSend) {
        getElement(driver, locator).clear();
        getElement(driver, locator).sendKeys(keysToSend);
    }

    public void sendKeysToElement(WebDriver driver, String locator, String keysToSend, String... restParameter) {
        getElement(driver, locator, restParameter).clear();
        getElement(driver, locator, restParameter).sendKeys(keysToSend);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value) {
        new Select(getElement(driver, locator)).selectByValue(value);
    }

    public void selectItemInDropdown(WebDriver driver, String locator, String value, String... restParameter) {
        new Select(getElement(driver, locator, restParameter)).selectByValue(value);
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).getFirstSelectedOption();
    }

    public WebElement getSelectedItemInDropdown(WebDriver driver, String locator, String... restParameter) {
        return new Select(getElement(driver, locator, restParameter)).getFirstSelectedOption();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getElement(driver, locator)).isMultiple();
    }

    public boolean isDropdownMultiple(WebDriver driver, String locator, String... restParameter) {
        return new Select(getElement(driver, locator, restParameter)).isMultiple();
    }

    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
        getElement(driver, parentLocator).click();

        List<WebElement> allItems = new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childItemLocator)));

        for (WebElement item : allItems) {
            if (item.getText().trim().equals(expectedItem)) {
                item.click();
                break;
            }
        }
    }

    public String getAttributeValue(WebDriver driver, String locator, String value) {
        return getElement(driver, locator).getAttribute(value);
    }

    public String getAttributeValue(WebDriver driver, String locator, String value, String... restParameter) {
        return getElement(driver, locator, restParameter).getAttribute(value);
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, locator, restParameter).getText();
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName) {
        return getElement(driver, locator).getCssValue(propertyName);
    }

    public String getCssValue(WebDriver driver, String locator, String propertyName, String... restParameter) {
        return getElement(driver, locator, restParameter).getCssValue(propertyName);
    }

    public String getHexaColorByRgbaColor(String rgbaValue) {
        return Color.fromString(rgbaValue).asHex().toUpperCase();
    }

    public int getListElementsSize(WebDriver driver, String locator) {
        return getListElements(driver, locator).size();
    }

    public int getListElementsSize(WebDriver driver, String locator, String... restParameter) {
        return getListElements(driver, locator, restParameter).size();
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator) {
        if (!getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void checkToCheckboxOrRadio(WebDriver driver, String locator, String... restParameter) {
        if (!getElement(driver, locator, restParameter).isSelected()) {
            getElement(driver, locator, restParameter).click();
        }
    }

    public void uncheckToCheckboxOrRadio(WebDriver driver, String locator) {
        if (getElement(driver, locator).isSelected()) {
            getElement(driver, locator).click();
        }
    }

    public void uncheckToCheckboxOrRadio(WebDriver driver, String locator, String... restParameter) {
        if (getElement(driver, locator, restParameter).isSelected()) {
            getElement(driver, locator, restParameter).click();
        }
    }

    public boolean isControlDisplayed(WebDriver driver, String locator) {
        return getElement(driver, locator).isDisplayed();
    }

    public boolean isControlDisplayed(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, locator, restParameter).isDisplayed();
    }

    public boolean isControlSelected(WebDriver driver, String locator) {
        return getElement(driver, locator).isSelected();
    }

    public boolean isControlSelected(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, locator, restParameter).isSelected();
    }

    public boolean isControlEnabled(WebDriver driver, String locator) {
        return getElement(driver, locator).isEnabled();
    }

    public boolean isControlEnabled(WebDriver driver, String locator, String... restParameter) {
        return getElement(driver, locator, restParameter).isEnabled();
    }

    public void switchToFrame(WebDriver driver, String locator) {
        driver.switchTo().frame(getElement(driver, locator));
    }

    public void switchToFrame(WebDriver driver, String locator, String... restParameter) {
        driver.switchTo().frame(getElement(driver, locator, restParameter));
    }

    public void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    public void doubleClickToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).doubleClick().perform();
    }

    public void doubleClickToElement(WebDriver driver, String locator, String... restParameter) {
        new Actions(driver).moveToElement(getElement(driver, locator, restParameter)).doubleClick().perform();
    }

    public void moveToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator));
    }

    public void moveToElement(WebDriver driver, String locator, String... restParameter) {
        new Actions(driver).moveToElement(getElement(driver, locator, restParameter));
    }

    public void rightClickToElement(WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getElement(driver, locator)).contextClick().perform();
    }

    public void rightClickToElement(WebDriver driver, String locator, String... restParameter) {
        new Actions(driver).moveToElement(getElement(driver, locator, restParameter)).contextClick().perform();
    }

    public void dragAndDrop(WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator) {
        new Actions(driver).scrollToElement(getElement(driver, locator)).perform();
    }

    public void scrollToElement(WebDriver driver, String locator, String... restParameter) {
        new Actions(driver).scrollToElement(getElement(driver, locator, restParameter)).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keysToSend) {
        new Actions(driver).sendKeys(getElement(driver, locator), keysToSend).perform();
    }

    public void sendKeyboardToElement(WebDriver driver, String locator, Keys keysToSend, String... restParameter) {
        new Actions(driver).sendKeys(getElement(driver, locator, restParameter), keysToSend).perform();
    }

    public void highlightElementByJS(WebDriver driver, String locator) throws InterruptedException {
        WebElement element = getElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style',arguments[1])", element, "border: 2px solid red; border-style: dashed;");
        sleepInSeconds(2);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator));
    }

    public void scrollToElementOnTopByJS(WebDriver driver, String locator, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getElement(driver, locator, restParameter));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator));
    }

    public void scrollToElementOnDownByJS(WebDriver driver, String locator, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getElement(driver, locator, restParameter));
    }

    public void scrollToBottomPageByJS(WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void setAttributeInDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "','" + attributeValue + "');", getElement(driver, locator));
    }

    public void setAttributeInDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "','" + attributeValue + "')", getElement(driver, locator, restParameter));
    }

    public void removeAttributeInDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "','" + attributeValue + "')", getElement(driver, locator));
    }

    public void removeAttributeInDOMByJS(WebDriver driver, String locator, String attributeName, String attributeValue, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "','" + attributeValue + "')", getElement(driver, locator, restParameter));
    }

    public void sendKeysToElementByJS(WebDriver driver, String locator, String keysToSend) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", getElement(driver, locator));
    }

    public void sendKeysToElementByJS(WebDriver driver, String locator, String keysToSend, String... restParameter) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value','" + keysToSend + "')", getElement(driver, locator, restParameter));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator));
    }

    public String getAttributeInDOMByJS(WebDriver driver, String locator, String attributeName, String... restParameter) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getElement(driver, locator, restParameter));
    }

    public String getElementValidationMessage(WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator));
    }

    public String getElementValidationMessage(WebDriver driver, String locator, String... restParameter) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getElement(driver, locator, restParameter));
    }

    public boolean isImageLoaded(WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator));
    }

    public boolean isImageLoaded(WebDriver driver, String locator, String... restParameter) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete " +
                        "&& typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
                getElement(driver, locator, restParameter));
    }

    public void waitForElementVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator, restParameter)));
    }

    public void waitForListElementsVisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForListElementsVisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator, restParameter)));
    }

    public void waitForElementSelected(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator)));
    }

    public void waitForElementSelected(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeSelected(getByLocator(locator, restParameter)));
    }

    public void waitForElementClickable(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator, restParameter)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator, restParameter)));
    }

    public void waitForListElementsInvisible(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator)));
    }

    public void waitForListElementsInvisible(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.invisibilityOfAllElements(getListElements(driver, locator, restParameter)));
    }

    public void waitForElementPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator)));
    }


    public void waitForElementPresence(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfElementLocated(getByLocator(locator, restParameter)));
    }

    public void waitForListElementsPresence(WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator)));
    }

    public void waitForListElementsPresence(WebDriver driver, String locator, String... restParameter) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(locator, restParameter)));
    }

    public void waitForAlertPresence(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalConstants.LONG_TIMEOUT)).until(ExpectedConditions.alertIsPresent());
    }

    public void overrideGlobalTimeout(WebDriver driver, long timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public boolean isElementUndisplayed(WebDriver driver, String locator) {
        System.out.println("START time = " + new Date().toString());
        List<WebElement> elements = getListElements(driver, locator);
        try {
            if (elements.size() == 0) {
                System.out.println("Element is not in DOM");
                System.out.println("END time = " + new Date().toString());
                return true;
            } else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
                System.out.println("Element is in DOM but not Displayed");
                return true;
            } else {
                System.out.println("Element is in DOM and visible");
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void uploadMultipleFiles(WebDriver driver, String uploadFileInputLocator, String... fileNames) {
        String filePath = GlobalConstants.UPLOAD_PATH;
        String fullFileName = "";

        for (String file : fileNames) {
            fullFileName += filePath + file + "\n";
        }

        fullFileName = fullFileName.trim();

        getElement(driver, uploadFileInputLocator).sendKeys(fullFileName);
    }

}

