package pageUIs.nopcommerce;

public class ProductPUI {
    public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text() = 'Add your review']";

    public static final String DYNAMIC_REVIEW_OPTIONS_BY_VALUE = "xpath=//div[@class = 'rating-options']/input[@value='%s']";

    public static final String SUBMIT_REVIEW_BUTTON = "css=button[id='add-review']";

    public static final String REVIEW_TITLE_TEXTBOX = "css=input[class='review-title']";

    public static final String REVIEW_TEXT_TEXTAREA = "css=textarea[class='review-text']";

    public static final String DYNAMIC_PRODUCT_ITEM_LINK_BY_TEXT = "xpath=//div[@class='product-item']//div[@class='details']/h2[@class='product-title']/a[text()='%s']";

    public static final String PRODUCT_SORTING_SELECTION = "xpath=//div[@class='product-sorting']//select";

    public static final String PRODUCT_PAGING_SELECTION = "xpath=//div[@class='product-page-size']//select";

    public static final String LIST_PRODUCT_NAME = "xpath=//div[@class='item-box']//h2[@class = 'product-title']//a";

    public static final String LIST_PRODUCT_PRICE =
            "xpath=//div[@class='item-box']//div[@class='prices']";

    public static final String NEXT_PAGE_ICON = "xpath=//li[@class='next-page']/a";

    public static final String PREVIOUS_PAGE_ICON = "xpath=//li[@class='previous-page']/a";
}
