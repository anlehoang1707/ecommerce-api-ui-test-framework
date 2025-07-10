package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.ProductPUI;

public class ProductPO extends BasePage {
    WebDriver driver;

    public ProductPO(WebDriver driver) {
       this.driver = driver;
    }


    public void clickToProductItemByText(WebDriver driver, String productItemName) {
        waitForElementClickable(driver, ProductPUI.DYNAMIC_PRODUCT_ITEM_LINK_BY_TEXT,productItemName);
        clickToElement(driver, ProductPUI.DYNAMIC_PRODUCT_ITEM_LINK_BY_TEXT,productItemName);
    }

    public void clickToAddReviewLink(WebDriver driver) {
        waitForElementClickable(driver,ProductPUI.ADD_YOUR_REVIEW_LINK);
        clickToElement(driver,ProductPUI.ADD_YOUR_REVIEW_LINK);
    }

    public void inputToReviewTitle(WebDriver driver, String reviewTitle) {
        waitForElementClickable(driver, ProductPUI.REVIEW_TITLE_TEXTBOX,reviewTitle);
        sendKeysToElement(driver,ProductPUI.REVIEW_TITLE_TEXTBOX,reviewTitle);
    }


    public void inputToReviewText(WebDriver driver, String reviewText) {
        waitForElementClickable(driver, ProductPUI.REVIEW_TEXT_TEXTAREA,reviewText);
        sendKeysToElement(driver,ProductPUI.REVIEW_TEXT_TEXTAREA,reviewText);
    }

    public void selectReviewOptionByIndex(WebDriver driver, String reviewRating) {
        waitForElementClickable(driver,ProductPUI.DYNAMIC_REVIEW_OPTIONS_BY_VALUE,reviewRating);
        clickToElement(driver,ProductPUI.DYNAMIC_REVIEW_OPTIONS_BY_VALUE,reviewRating);
    }

    public void clickToSubmitReviewButton(WebDriver driver) {
        waitForElementClickable(driver,ProductPUI.SUBMIT_REVIEW_BUTTON);
        clickToElement(driver,ProductPUI.SUBMIT_REVIEW_BUTTON);
    }
}
