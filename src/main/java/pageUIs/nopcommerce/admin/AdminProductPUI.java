package pageUIs.nopcommerce.admin;

public class AdminProductPUI {
    public static final String PRODUCT_NAME_SEARCH_TEXTBOX = "xpath=//div[@class='search-body ']//input[@id='SearchProductName']";

    public static final String SEARCH_BUTTON = "css=button#search-products";

    public static final String LIST_DISPLAYED_PRODUCT_ROW = "xpath=//div[@id='products-grid_wrapper']//tbody/tr";

    public static final String CATEGORY_DROPDOWN = "xpath=//select[@id='SearchCategoryId']";

    public static final String SEARCH_SUB_CATEGORIES_CHECKBOX = "xpath=//input[@class='check-box' and @id='SearchIncludeSubCategories']";

    public static final String SEARCH_MESSAGE_IN_TABLE = "xpath=//div[@id='products-grid_wrapper']//td";

    public static final String MANUFACTURER_DROPDOWN = "xpath=//select[@id='SearchManufacturerId']";

    public static final String GO_DIRECTLY_SKU_TEXTBOX = "xpath=//input[@id='GoDirectlyToSku']";

    public static final String GO_DIRECTLY_SKU_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";
}
