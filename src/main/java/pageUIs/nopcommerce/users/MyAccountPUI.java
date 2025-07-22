package pageUIs.nopcommerce.users;

public class MyAccountPUI {
    public static final String DYNAMIC_GENDER_RADIO_BUTTON = "xpath=//label[text()='%s']//preceding-sibling::input[@type='radio']";

    public static final String FIRST_NAME_TEXTBOX = "css=input[name='FirstName']";

    public static final String LAST_NAME_TEXTBOX = "css=input[name='LastName']";

    public static final String EMAIL_TEXTBOX = "css=input[name='Email']";

    public static final String COMPANY_NAME_TEXTBOX = "css=input[name='Company']";

    public static final String SAVE_BUTTON = "css=button[name = 'save-info-button']";

    public static final String ADDRESS_FIRST_NAME_TEXTBOX = "xpath=//input[@id = 'Address_FirstName']";

    public static final String ADDRESS_LAST_NAME_TEXTBOX = "xpath=//input[@id = 'Address_LastName']";

    public static final String ADDRESS_EMAIL_TEXTBOX ="xpath=//input[@id = 'Address_Email']";

    public static final String ADDRESS_COMPANY_TEXTBOX ="xpath=//input[@id = 'Address_Company']";

    public static final String ADDRESS_COUNTRY_SELECTION = "xpath=//select[@id = 'Address_CountryId']";

    public static final String ADDRESS_STATE_PROVINCE_SELECTION ="xpath=//select[@id = 'Address_StateProvinceId']";

    public static final String ADDRESS_CITY_TEXTBOX ="xpath=//input[@id = 'Address_City']";

    public static final String ADDRESS_ADDRESS_1_TEXTBOX ="xpath=//input[@id = 'Address_Address1']";

    public static final String ADDRESS_ADDRESS_2_TEXTBOX ="xpath=//input[@id = 'Address_Address2']";

    public static final String ADDRESS_ZIP_POSTAL_CODE_TEXTBOX ="xpath=//input[@id = 'Address_ZipPostalCode']";

    public static final String ADDRESS_PHONE_NUMBER_TEXTBOX = "xpath=//input[@id = 'Address_PhoneNumber']";

    public static final String ADDRESS_FAX_NUMBER_TEXTBOX ="xpath=//input[@id = 'Address_FaxNumber']";

    public static final String DYNAMIC_ADDRESS_INFO_BOX = "xpath=(//h1[text() = 'My account - Addresses']//parent::div//following-sibling::div//ul[@class='info'])//li[@class='%s']";

    public static final String ADDRESS_INFO_TITLE = "xpath=//div[@class='section address-item']//div[@class='title']";

    public static final String OLD_PASSWORD_TEXTBOX = "css=input[id = 'OldPassword']";

    public static final String NEW_PASSWORD_TEXTBOX = "css=input[id = 'NewPassword']";

    public static final String CONFIRM_NEW_PASSWORD_TEXTBOX = "css=input[id = 'ConfirmNewPassword']";

    public static final String CHANGE_PASSWORD_BUTTON = "xpath=//button[contains(@class,'change-password-button')]";

    public static final String DYNAMIC_SIDE_NAV_LINK_BY_TEXT = "xpath=//div[@class='side-2']//a[text()='%s']";

    public static final String REVIEW_TITLE_INFO = "xpath=//div[@class='page-body']//div[@class='review-title']";

    public static final String REVIEW_TEXT_INFO = "xpath=//div[@class='page-body']//div[@class='review-text']";

    public static final String REVIEW_RATING_INFO = "xpath=//div[@class='page-body']//div[@class='rating']/div";

    public static final String REVIEW_PRODUCT_ITEM_NAME = "xpath=//div[@class='page-body']//div[@class='review-info']//a";

    public static final String ADD_NEW_ADDRESS_BUTTON="xpath=//h1[contains(text(),'Addresses')]//parent::div[@class='page-title']/following-sibling::div//button[text() ='Add new']";

    public static final String SAVE_ADDRESS_BUTTON = "xpath=//button[contains(@class,'save-address-button') and text()='Save']";

    public static final String LIST_ORDER_TITLE = "xpath=//div[@class = 'section order-item']//div[@class='title']";

    public static final String LATEST_ORDER_TITLE = "xpath=//div[@class = 'section order-item']//div[@class='title'][1]";

}
