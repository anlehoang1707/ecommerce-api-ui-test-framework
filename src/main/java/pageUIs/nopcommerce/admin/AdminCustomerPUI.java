package pageUIs.nopcommerce.admin;

public class AdminCustomerPUI {
    public static final String ADD_NEW_BUTTON = "xpath=//a[contains(@class,'btn') and normalize-space()='Add new']";

    public static final String EMAIL_TEXTBOX = "xpath=//input[@id='Email']";

    public static final String PASSWORD_TEXTBOX ="xpath=//input[@id='Password']";

    public static final String FIRST_NAME_TEXTBOX = "xpath=//input[@id='FirstName']";

    public static final String LAST_NAME_TEXTBOX ="xpath=//input[@id='LastName']";

    public static final String DYNAMIC_GENDER_RADIO_BY_TEXT = "xpath=//label[normalize-space()='%s']//preceding-sibling::input[@type='radio']";

    public static final String COMPANY_TEXTBOX = "xpath=//input[@id='Company']";

    public static final String CUSTOMER_ROLES_SEARCH_INLINE_INPUT = "xpath=//select[@id='SelectedCustomerRoleIds']//following-sibling::span//li[contains(@class,'inline')]//input";

    public static final String DYNAMIC_CUSTOMER_ROLES_VALUE_BY_TITLE = "xpath=//select[@id='SelectedCustomerRoleIds']//following-sibling::span//span[@class='selection']//li[text()='%s']";

    public static final String LIST_REMOVE_CUSTOMER_ROLES_ICON = "xpath=//select[@id='SelectedCustomerRoleIds']//following-sibling::span//span[@class='selection']//li/span[contains(@class,'remove')]";

    public static final String REMOVE_CUSTOMER_ROLES_ICON_BY_INDEX = "xpath=(//select[@id='SelectedCustomerRoleIds']//following-sibling::span//span[@class='selection']//li/span[contains(@class,'remove')])[%s]";

    public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "xpath=//button[normalize-space()='Save and Continue Edit']";

    public static final String NOTIFICATION_ALERT_MESSAGE = "xpath=//div[contains(@class,'alert')]";

    public static final String BACK_TO_CUSTOMER_LIST_LINK = "xpath=//a[text()='back to customer list']";

    public static final String SEARCH_CUSTOMER_BUTTON = "xpath=//button[@id='search-customers']";

    public static final String SEARCH_EMAIL_TEXTBOX = "xpath=//input[@id='SearchEmail']";

    public static final String SEARCH_FIRST_NAME_TEXTBOX = "xpath=//input[@id='SearchFirstName']";

    public static final String SEARCH_LAST_NAME_TEXTBOX ="//input[@id='SearchLastName']";

    public static final String LIST_DISPLAYED_CUSTOMER_ROW = "xpath=//div[@id='customers-grid_wrapper']//tbody/tr";

    public static final String SEARCH_COMPANY_TEXTBOX = "xpath=//input[@id='SearchCompany']";

    public static final String LIST_EDIT_BUTTON ="xpath=//td[@class='button-column']/a[text()='Edit']";

    public static final String DYNAMIC_EDIT_CUSTOMER_BUTTON_BY_INDEX = "xpath=(//td[@class='button-column']/a[text()='Edit'])[%s]";

    public static final String SAVE_BUTTON ="xpath=//button[normalize-space()='Save']";

    public static final String ADDRESS_CARD_HEADER = "xpath=//div[@id='customer-address']";

    public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[normalize-space() = 'Add new address']";

    public static final String SAVE_ADDRESS_BUTTON = "xpath=//h1[contains(text(),'address')]//following-sibling::div/button[normalize-space()='Save']";

    public static final String BACK_TO_CUSTOMER_DETAIL_LINK = "xpath=//a[text()='back to customer details']";

    public static final String DYNAMIC_EDIT_ADDRESS_BUTTON_BY_INDEX = "xpath=(//div[@id='customer-addresses-grid_wrapper']//td[@class='button-column']//a[text()='Edit'])[%s]";

    public static final String DYNAMIC_DELETE_ADDRESS_BUTTON_BY_INDEX = "xpath=(//div[@id='customer-addresses-grid_wrapper']//td[@class='button-column']//a[text()='Delete'])[%s]";

    public static final String SEARCH_MESSAGE_IN_ADDRESS_TABLE = "xpath=//div[@id='customer-addresses-grid_wrapper']//td";

    public static final String ACTIVE_CHECKBOX = "xpath=//input[@type='checkbox' and @id='Active']";

    public static final String ADMIN_COMMENT_TEXTAREA = "xpath=//textarea[@id='AdminComment']";

    public static final String DYNAMIC_CUSTOMER_ROW_BY_EMAIL_AND_COLUMN_INDEX = "xpath=//div[@id='customers-grid_wrapper']//td[text()='%s']//parent::tr//td[%s]";

    public static final String DYNAMIC_COLUMN_HEADER_BY_NAME = "xpath=//thead/tr/th/span[@class='dt-column-title' and text()='%s']//parent::th";

    public static final String LIST_DYNAMIC_CELLS_BY_EMAIL = "xpath=//div[@id='customers-grid_wrapper']//td[text()='%s']//parent::tr//td";
}
