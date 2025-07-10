package pageUIs.nopcommerce;

public class ProductPUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text() = 'Add your review']";

    public static final String DYNAMIC_REVIEW_OPTIONS_BY_VALUE = "xpath=//div[@class = 'rating-options']/input[@value='%s']";

    public static final String SUBMIT_REVIEW_BUTTON = "css=button[id='add-review']";

    public static final String REVIEW_TITLE_TEXTBOX = "css=input[class='review-title']";

    public static final String REVIEW_TEXT_TEXTAREA = "css=textarea[class='review-text']";

    public static final String DYNAMIC_PRODUCT_ITEM_LINK_BY_TEXT = "xpath=//div[@class='product-item']//div[@class='details']/h2[@class='product-title']/a[text()='%s']";

}
