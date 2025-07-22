package pageUIs.nopcommerce.users;

public class SearchPUI {
    public static final String SEARCH_BUTTON ="xpath=//div[@class='search-input']//button[text()='Search']";

    public static final String SEARCH_ERROR_MESSAGE = "xpath=//div[@class='search-results']//div[@class = 'products-wrapper']";

    public static final String SEARCH_KEYWORD_TEXTBOX = "xpath=//div[@class='search-input']//div[@class ='basic-search']//input[contains(@class,'search-text')]";

    public static final String ADVANCED_SEARCH_CHECKBOX = "xpath=//input[@type = 'checkbox' and @name='advs']";

    public static final String DYNAMIC_PRODUCT_ITEM_LINK_BY_PRODUCT_NAME = "xpath=//div[@class='item-box']//h2[@class='product-title']/a[text() = '%s']";

    public static final String DYNAMIC_PRODUCT_ITEM_LINK_BY_INDEX = "xpath=//div[@class='item-box'][%s]//h2[@class='product-title']/a";

    public static final String PRODUCT_LIST_ITEM = "xpath=//div[@class='item-box']//h2[@class='product-title']/a";

    public static final String CATEGORY_SELECTION = "xpath=//div[@class='inputs']//label[contains(text(),Category)]/following-sibling::select[@id = 'cid']";

    public static final String AUTOMATICALLY_SUB_CATEGORY_SEARCH_CHECKBOX = "xpath=//label[contains(text(),'sub categories')]//preceding-sibling::input[@type='checkbox']";

    public static final String MANUFACTURER_SELECTION = "xpath=//div[@class='inputs']//label[contains(text(),Manufacturer)]/following-sibling::select[@id = 'mid']";

    public static final String SEARCH_IN_PRODUCTS_DESCRIPTION_CHECKBOX ="xpath=//label[contains(text(),'product descriptions')]//preceding-sibling::input[@type='checkbox']";
}
