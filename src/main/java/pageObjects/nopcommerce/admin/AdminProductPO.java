package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.admin.AdminProductPUI;

public class AdminProductPO extends BasePage {
    WebDriver driver;

    public AdminProductPO(WebDriver driver) {
        this.driver = driver;
    }

    public void sendKeyToProductNameTextbox(WebDriver driver, String productName) {
        waitForElementClickable(driver, AdminProductPUI.PRODUCT_NAME_SEARCH_TEXTBOX);
        sendKeysToElement(driver,AdminProductPUI.PRODUCT_NAME_SEARCH_TEXTBOX,productName);
    }

    public void clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver, AdminProductPUI.SEARCH_BUTTON);
        clickToElement(driver,AdminProductPUI.SEARCH_BUTTON);
    }

    public int getDisplayedProductSearchResultCount(WebDriver driver) {
        return getListElementsSize(driver,AdminProductPUI.LIST_DISPLAYED_PRODUCT_ROW);
    }

    public void selectItemInCategoryDropdownByText(WebDriver driver, String categoryText) {
        waitForElementClickable(driver,AdminProductPUI.CATEGORY_DROPDOWN);
        selectItemInDropdownByVisibleText(driver,AdminProductPUI.CATEGORY_DROPDOWN,categoryText);
    }

    public void uncheckToSearchSubCategoriesCheckbox(WebDriver driver) {
        waitForElementClickable(driver,AdminProductPUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
        uncheckToCheckboxOrRadio(driver,AdminProductPUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public String getSearchMessageInTable(WebDriver driver) {
        return getTextElement(driver,AdminProductPUI.SEARCH_MESSAGE_IN_TABLE);
    }

    public void checkToSearchSubCategoriesCheckbox(WebDriver driver) {
        waitForElementClickable(driver,AdminProductPUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
        checkToCheckboxOrRadio(driver,AdminProductPUI.SEARCH_SUB_CATEGORIES_CHECKBOX);
    }

    public void selectItemInManufacturerDropdownByText(WebDriver driver, String manufacturerName) {
        waitForElementClickable(driver,AdminProductPUI.MANUFACTURER_DROPDOWN);
        selectItemInDropdownByVisibleText(driver,AdminProductPUI.MANUFACTURER_DROPDOWN,manufacturerName);
    }

    public void sendKeyToGoDirectLyProductSKU(WebDriver driver, String skuText) {
        waitForElementClickable(driver,AdminProductPUI.GO_DIRECTLY_SKU_TEXTBOX);
        sendKeysToElement(driver,AdminProductPUI.GO_DIRECTLY_SKU_TEXTBOX,skuText);
    }

    public void clickToGoSKUButton(WebDriver driver) {
        waitForElementClickable(driver,AdminProductPUI.GO_DIRECTLY_SKU_BUTTON);
        clickToElement(driver,AdminProductPUI.GO_DIRECTLY_SKU_BUTTON);
    }
}
