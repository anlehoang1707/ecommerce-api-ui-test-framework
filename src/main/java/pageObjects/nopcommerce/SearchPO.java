package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.SearchPUI;

public class SearchPO extends BasePage {
    WebDriver driver;

    public SearchPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver, SearchPUI.SEARCH_BUTTON);
        clickToElement(driver,SearchPUI.SEARCH_BUTTON);
    }

    public String getSearchErrorMessageText(WebDriver driver) {
        waitForElementVisible(driver,SearchPUI.SEARCH_ERROR_MESSAGE);
        return getTextElement(driver,SearchPUI.SEARCH_ERROR_MESSAGE);
    }

    public void inputToSearchKeywordTextbox(WebDriver driver, String searchTerm) {
        waitForElementClickable(driver,SearchPUI.SEARCH_KEYWORD_TEXTBOX);
        sendKeysToElement(driver,SearchPUI.SEARCH_KEYWORD_TEXTBOX,searchTerm);
    }

    public int getListProductSize(WebDriver driver) {
        return getListElementsSize(driver,SearchPUI.PRODUCT_LIST_ITEM);
    }

    public String getProductNameByIndex(WebDriver driver, int index) {
        return getTextElement(driver,SearchPUI.DYNAMIC_PRODUCT_ITEM_LINK_BY_INDEX,String.valueOf(index));
    }

    public void checkToAdvancedSearchCheckbox(WebDriver driver) {
        waitForElementClickable(driver,SearchPUI.ADVANCED_SEARCH_CHECKBOX);
        checkToCheckboxOrRadio(driver,SearchPUI.ADVANCED_SEARCH_CHECKBOX);
    }

    public void selectItemInCategoryDropdown(WebDriver driver, String visibleText) {
        waitForElementClickable(driver,SearchPUI.CATEGORY_SELECTION);
        selectItemInDropdownByVisibleText(driver,SearchPUI.CATEGORY_SELECTION,visibleText);
    }

    public void uncheckToAutomaticallySearchSubCategories(WebDriver driver) {
        uncheckToCheckboxOrRadio(driver,SearchPUI.AUTOMATICALLY_SUB_CATEGORY_SEARCH_CHECKBOX);
    }

    public void checkToAutomaticallySearchSubCategories(WebDriver driver) {
        checkToCheckboxOrRadio(driver,SearchPUI.AUTOMATICALLY_SUB_CATEGORY_SEARCH_CHECKBOX);
    }

    public void selectItemInManufacturerDropdown(WebDriver driver, String visibleText) {
        selectItemInDropdownByVisibleText(driver,SearchPUI.MANUFACTURER_SELECTION,visibleText);
    }

}
