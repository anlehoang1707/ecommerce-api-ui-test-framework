package pageUIs.nopcommerce.users;

public class CartPUI {
    public static final String LIST_PRODUCT_NAME = "xpath=//table[@class='cart']//a[@class='product-name']";

    public static final String DYNAMIC_PRODUCT_LINK_BY_TEXT = "xpath=//table[@class='cart']//a[@class='product-name' and text()='%s']";

    public static final String LIST_PRODUCT_ATTRIBUTE = "xpath=//table[@class='cart']//div[@class='attributes']";

    public static final String LIST_EDIT_PRODUCT_LINK = "xpath=//div[@class = 'edit-item']";

    public static final String PRODUCT_LINK_NAME = "xpath=//td[@class='product']//a[@class='product-name']";

    public static final String DYNAMIC_CART_TOTAL_INFO_BY_ATTRIBUTE_NAME = "xpath=//div[@class='total-info']//td//label[text()='%s:']//parent::td//following-sibling::td//span";

    public static final String DYNAMIC_EDIT_PRODUCT_LINK_BY_PRODUCT_NAME ="xpath=//a[@class = 'product-name' and text() = '%s']//following-sibling::div[@class = 'edit-item']//a";


    public static final String DYNAMIC_REMOVE_PRODUCT_ICON_BY_PRODUCT_NAME = "xpath=//a[@class = 'product-name' and text() = '%s']//parent::td[@class='product']//following-sibling::td[@class = 'remove-from-cart']//button";

    public static final String CART_ORDER_SUMMARY = "xpath=//div[@class = 'order-summary-content']";

    public static final String TERMS_OF_SERVICE_CHECKBOX = "xpath=//input[@id='termsofservice']";

    public static final String CHECKOUT_BUTTON = "xpath=//button[@id='checkout']";
}
