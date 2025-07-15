package pageUIs.nopcommerce;

public class CheckoutPUI {
    public static final String SHIP_TO_SAME_ADDRESS_CHECKBOX = "xpath=//input[@id = 'ShipToSameAddress']";

    public static final String BILLING_ADDRESS_CONTINUE_BUTTON = "xpath=//div[@id = 'billing-buttons-container']//button[text()='Continue']";

    public static final String SHIPPING_ADDRESS_CONTINUE_BUTTON = "xpath=//div[@id = 'shipping-buttons-container']//button[text()='Continue']";

    public static final String BILLING_ADDRESS_DROPDOWN = "xpath=//select[@name ='billing_address_id']";

    public static final String SHIPPING_ADDRESS_DROPDOWN = "xpath=//select[@name ='shipping_address_id']";

    public static final String PICKUP_CHECKBOX = "xpath=//input[@id = 'PickupInStore']";

    public static final String BILLING_ADDRESS_FIRST_NAME_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_FirstName']";
    public static final String BILLING_ADDRESS_LAST_NAME_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_LastName']";
    public static final String BILLING_ADDRESS_EMAIL_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_Email']";
    public static final String BILLING_ADDRESS_COMPANY_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_Company']";
    public static final String BILLING_ADDRESS_COUNTRY_SELECTION = "xpath=//select[@id = 'BillingNewAddress_CountryId']";
    public static final String BILLING_ADDRESS_STATE_PROVINCE_SELECTION = "xpath=//select[@id = 'BillingNewAddress_StateProvinceId']";
    public static final String BILLING_ADDRESS_CITY_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_City']";
    public static final String BILLING_ADDRESS_ADDRESS_1_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_Address1']";
    public static final String BILLING_ADDRESS_ADDRESS_2_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_Address2']";
    public static final String BILLING_ADDRESS_ZIP_POSTAL_CODE_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_ZipPostalCode']";
    public static final String BILLING_ADDRESS_PHONE_NUMBER_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_PhoneNumber']";
    public static final String BILLING_ADDRESS_FAX_NUMBER_TEXTBOX = "xpath=//input[@id = 'BillingNewAddress_FaxNumber']";

    public static final String SHIPPING_ADDRESS_FIRST_NAME_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_FirstName']";
    public static final String SHIPPING_ADDRESS_LAST_NAME_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_LastName']";
    public static final String SHIPPING_ADDRESS_EMAIL_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_Email']";
    public static final String SHIPPING_ADDRESS_COMPANY_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_Company']";
    public static final String SHIPPING_ADDRESS_COUNTRY_SELECTION = "xpath=//select[@id = 'ShippingNewAddress_CountryId']";
    public static final String SHIPPING_ADDRESS_STATE_PROVINCE_SELECTION = "xpath=//select[@id = 'ShippingNewAddress_StateProvinceId']";
    public static final String SHIPPING_ADDRESS_CITY_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_City']";
    public static final String SHIPPING_ADDRESS_ADDRESS_1_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_Address1']";
    public static final String SHIPPING_ADDRESS_ADDRESS_2_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_Address2']";
    public static final String SHIPPING_ADDRESS_ZIP_POSTAL_CODE_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_ZipPostalCode']";
    public static final String SHIPPING_ADDRESS_PHONE_NUMBER_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_PhoneNumber']";
    public static final String SHIPPING_ADDRESS_FAX_NUMBER_TEXTBOX = "xpath=//input[@id = 'ShippingNewAddress_FaxNumber']";

    public static final String DYNAMIC_SHIPPING_METHOD_OPTION_BY_TEXT = "xpath=//label[text() = '%s']//preceding-sibling::input[@name = 'shippingoption']";

    public static final String DYNAMIC_PAYMENT_METHOD_OPTION_BY_TEXT = "xpath=//label[text() = '%s']//preceding-sibling::input[@name = 'paymentmethod']";

    public static final String SHIPPING_METHOD_CONTINUE_BUTTON = "xpath=//div[@id = 'shipping-method-buttons-container']//button[text()='Continue']";

    public static final String PAYMENT_METHOD_CONTINUE_BUTTON = "xpath=//div[@id = 'payment-method-buttons-container']//button[text()='Continue']" ;

    public static final String PAYMENT_INFORMATION_CONTINUE_BUTTON = "xpath=//div[@id = 'payment-info-buttons-container']//button[text()='Continue']";

    public static final String CONFIRM_ORDER_CONFIRM_BUTTON = "xpath=//div[@id = 'confirm-order-buttons-container']//button[text()='Confirm']";

    public static final String DYNAMIC_CONFIRM_ORDER_FIELD_BY_ADDRESS_TYPE_AND_FIELD_CLASS_NAME = "xpath=//div[@class='%s-info']//ul[@class='info-list']//li[@class='%s']";

    public static final String ORDER_SUCCESS_MESSAGE = "xpath=//div[@class = 'section order-completed']//div[@class='title']";

    public static final String ORDER_NUMBER_TEXT = "xpath=//div[@class = 'section order-completed']//div[@class='order-number']";

    public static final String CARD_TYPE_DROPDOWN = "xpath=//div[@class = 'section payment-info']//select[@id = 'CreditCardType']";

    public static final String CARD_HOLDER_NAME_TEXTBOX = "xpath=//div[@class = 'section payment-info']//input[@id = 'CardholderName']";

    public static final String CARD_NUMBER_TEXTBOX = "xpath=//div[@class = 'section payment-info']//input[@id = 'CardNumber']";

    public static final String CARD_CODE_TEXTBOX = "xpath=//div[@class = 'section payment-info']//input[@id = 'CardCode']";

    public static final String CARD_EXPIRATION_MONTH_DROPDOWN = "xpath=//div[@class = 'section payment-info']//select[@id = 'ExpireMonth']";

    public static final String CARD_EXPIRATION_YEAR_DROPDOWN = "xpath=//div[@class = 'section payment-info']//select[@id = 'ExpireYear']";
}
