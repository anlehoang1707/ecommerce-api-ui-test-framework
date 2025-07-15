package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.CartPUI;

import java.util.List;

public class CartPO extends BasePage {
    WebDriver driver;
    public CartPO(WebDriver driver) {
        this.driver = driver;
    }

    public Float getCartTotalInfoByAttribute(WebDriver driver, String attributeName) {
        waitForElementVisible(driver,CartPUI.DYNAMIC_CART_TOTAL_INFO_BY_ATTRIBUTE_NAME,attributeName);
        String elementPriceString = getTextElement(driver,CartPUI.DYNAMIC_CART_TOTAL_INFO_BY_ATTRIBUTE_NAME,attributeName).replaceAll("[$;,]","");
        return Float.parseFloat(elementPriceString);
    }

    public String getFirstProductName(WebDriver driver) {
        List<WebElement> listElements = getListElements(driver,CartPUI.LIST_PRODUCT_NAME);
        return listElements.get(0).getText();
    }


    public String getFirstProductAttribute(WebDriver driver) {
        List<WebElement> listElements = getListElements(driver,CartPUI.LIST_PRODUCT_ATTRIBUTE);
        return listElements.get(0).getText();
    }

    public void clickToEditLinkAtProductName(WebDriver driver, String productName) {
        waitForElementClickable(driver, CartPUI.DYNAMIC_EDIT_PRODUCT_LINK_BY_PRODUCT_NAME,productName);
        clickToElement(driver,CartPUI.DYNAMIC_EDIT_PRODUCT_LINK_BY_PRODUCT_NAME,productName);
    }

    public void clickToRemoveIconAtProductName(WebDriver driver, String productName) {
        waitForElementClickable(driver, CartPUI.DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME,productName);
        clickToElement(driver,CartPUI.DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME,productName);
    }

    public String getOrderContentSummary(WebDriver driver) {
        return getTextElement(driver, CartPUI.CART_ORDER_SUMMARY);
    }

    public void clickToAgreeTermAndServiceCheckbox(WebDriver driver) {
        waitForElementClickable(driver, CartPUI.TERMS_OF_SERVICE_CHECKBOX);
        clickToElement(driver,CartPUI.TERMS_OF_SERVICE_CHECKBOX);
    }

    public void clickToCheckoutButton(WebDriver driver) {
        waitForElementClickable(driver, CartPUI.CHECKOUT_BUTTON);
        clickToElement(driver,CartPUI.CHECKOUT_BUTTON);
    }

    public boolean isEditLinkAtProductNameDisplayed(WebDriver driver, String productName) {
        return isControlDisplayed(driver,CartPUI.DYNAMIC_EDIT_PRODUCT_LINK_BY_PRODUCT_NAME,productName);
    }

}
