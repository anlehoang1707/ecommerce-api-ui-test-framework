package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.admin.AdminDetailProductPUI;
import pageUIs.nopcommerce.admin.AdminProductPUI;

import java.util.Collection;

public class AdminDetailProductPO extends BasePage {
    WebDriver driver;

    public AdminDetailProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public String getTextInPageTitle(WebDriver driver) {
        return getTextElement(driver, AdminDetailProductPUI.DETAIL_PRODUCT_PAGE_TITLE);
    }

    public String getTextInProductNameTextbox(WebDriver driver) {
        return getAttributeValue(driver,AdminDetailProductPUI.PRODUCT_NAME_TEXTBOX,"value");
    }

    public void clickBackToProductListLink(WebDriver driver) {
        waitForElementClickable(driver,AdminDetailProductPUI.BACK_TO_PRODUCT_LIST_LINK);
        clickToElement(driver, AdminDetailProductPUI.BACK_TO_PRODUCT_LIST_LINK);
    }
}
