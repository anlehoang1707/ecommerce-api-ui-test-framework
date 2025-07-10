package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.ProductPUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public void selectSortOptionByText(WebDriver driver, String sortOptionText) {
        waitForElementClickable(driver,ProductPUI.PRODUCT_SORTING_SELECTION);
        selectItemInDropdownByVisibleText(driver,ProductPUI.PRODUCT_SORTING_SELECTION,sortOptionText);
    }

    public boolean isProductNameDataSortedAsc(WebDriver driver) {
        List<String> arrayList = new ArrayList<>();

        List<WebElement> listElements = getListElements(driver,ProductPUI.LIST_PRODUCT_NAME);

        for (WebElement e : listElements) {
            arrayList.add(e.getText());
        }

        List<String> sortedList = new ArrayList<>();

        for (String i : arrayList) {
            sortedList.add(i);
        }

        Collections.sort(sortedList);
        return sortedList.equals(arrayList);
    }

    public boolean isProductNameDataSortedDsc(WebDriver driver) {
        List<String> arrayList = new ArrayList<>();

        List<WebElement> listElements = getListElements(driver,ProductPUI.LIST_PRODUCT_NAME);

        for (WebElement e : listElements) {
            arrayList.add(e.getText());
        }

        List<String> sortedList = new ArrayList<>();

        for (String i : arrayList) {
            sortedList.add(i);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList.equals(arrayList);
    }

    public boolean isProductPriceDataSortedAsc(WebDriver driver) {
        List<Integer> arrayList = new ArrayList<>();

        List<WebElement> listElements = getListElements(driver,ProductPUI.LIST_PRODUCT_PRICE);

        for (WebElement e : listElements) {
            String price = e.getText().replaceAll("[$,]","");
            arrayList.add((int) Double.parseDouble(price));
        }

        List<Integer> sortedList = new ArrayList<>();

        for (Integer i: arrayList) {
            sortedList.add(i);
        }

        Collections.sort(sortedList);
        return sortedList.equals(arrayList);

    }

    public boolean isProductPriceDataSortedDsc(WebDriver driver) {
        List<Integer> arrayList = new ArrayList<>();

        List<WebElement> listElements = getListElements(driver,ProductPUI.LIST_PRODUCT_PRICE);

        for (WebElement e : listElements) {
            String price = e.getText().replaceAll("[$,]","");
            arrayList.add((int) Double.parseDouble(price));
        }

        List<Integer> sortedList = new ArrayList<>();

        for (Integer i: arrayList) {
            sortedList.add(i);
        }

        Collections.sort(sortedList);
        Collections.reverse(sortedList);
        return sortedList.equals(arrayList);
    }

    public void selectPagingOptionByText(WebDriver driver, String paging) {
        waitForElementClickable(driver,ProductPUI.PRODUCT_PAGING_SELECTION);
        selectItemInDropdownByVisibleText(driver,ProductPUI.PRODUCT_PAGING_SELECTION,paging);
    }

    public boolean isProductListDisplayedLessOrEqual(WebDriver driver, int maximumPagingNumber) {
        return getListElementsSize(driver,ProductPUI.LIST_PRODUCT_NAME) <= maximumPagingNumber ? true : false;
    }

    public boolean isNextPageIconDisplayed() {
        return isControlDisplayed(driver,ProductPUI.NEXT_PAGE_ICON);
    }

    public void clickToNextPageIcon(WebDriver driver) {
        waitForElementClickable(driver,ProductPUI.NEXT_PAGE_ICON);
        clickToElement(driver,ProductPUI.NEXT_PAGE_ICON);
    }

    public boolean isPreviousPageIconDisplayed() {
        return isControlDisplayed(driver,ProductPUI.PREVIOUS_PAGE_ICON);
    }

}
