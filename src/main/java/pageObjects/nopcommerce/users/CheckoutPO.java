package pageObjects.nopcommerce.users;

import commons.BasePage;
import model.nopcommerce.users.AddAddressPOJO;
import model.nopcommerce.users.CardPOJO;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.users.CheckoutPUI;

public class CheckoutPO extends BasePage {
    WebDriver driver;
    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToNewAddressOptionAtBillingAddress(WebDriver driver) {
//        waitForElementClickable(driver,CheckoutPUI.BILLING_ADDRESS_DROPDOWN);
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.BILLING_ADDRESS_DROPDOWN,"New Address");
    }

    public void inputNewBillingAddressInfoForm(WebDriver driver, AddAddressPOJO addAddressPOJO) {
        sendKeysToElement(driver, CheckoutPUI.BILLING_ADDRESS_FIRST_NAME_TEXTBOX,addAddressPOJO.getFirstName());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_LAST_NAME_TEXTBOX, addAddressPOJO.getLastName());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_EMAIL_TEXTBOX,addAddressPOJO.getEmail());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_COMPANY_TEXTBOX, addAddressPOJO.getCompany());

        selectItemInDropdownByVisibleText(driver,CheckoutPUI.BILLING_ADDRESS_COUNTRY_SELECTION, addAddressPOJO.getCountry());
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.BILLING_ADDRESS_STATE_PROVINCE_SELECTION, addAddressPOJO.getStateProvince());

        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_CITY_TEXTBOX, addAddressPOJO.getCity());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_ADDRESS_1_TEXTBOX, addAddressPOJO.getAddress1());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_ADDRESS_2_TEXTBOX, addAddressPOJO.getAddress2());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_ZIP_POSTAL_CODE_TEXTBOX, addAddressPOJO.getZipPostalCode());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_PHONE_NUMBER_TEXTBOX, addAddressPOJO.getPhoneNumber());
        sendKeysToElement(driver,CheckoutPUI.BILLING_ADDRESS_FAX_NUMBER_TEXTBOX, addAddressPOJO.getFaxNumber());

    }

    public void clickToBillingAddressContinueButton(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.BILLING_ADDRESS_CONTINUE_BUTTON);
        clickToElement(driver,CheckoutPUI.BILLING_ADDRESS_CONTINUE_BUTTON);
    }

    public void clickToNewAddressOptionAtShippingAddress(WebDriver driver) {
//        waitForElementClickable(driver,CheckoutPUI.SHIPPING_ADDRESS_DROPDOWN);
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.SHIPPING_ADDRESS_DROPDOWN,"New Address");
    }

    public void inputNewShippingAddressInfoForm(WebDriver driver, AddAddressPOJO addAddressPOJO) {
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_FIRST_NAME_TEXTBOX, addAddressPOJO.getFirstName());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_LAST_NAME_TEXTBOX, addAddressPOJO.getLastName());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_EMAIL_TEXTBOX, addAddressPOJO.getEmail());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_COMPANY_TEXTBOX, addAddressPOJO.getCompany());

        selectItemInDropdownByVisibleText(driver, CheckoutPUI.SHIPPING_ADDRESS_COUNTRY_SELECTION, addAddressPOJO.getCountry());
        selectItemInDropdownByVisibleText(driver, CheckoutPUI.SHIPPING_ADDRESS_STATE_PROVINCE_SELECTION, addAddressPOJO.getStateProvince());

        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_CITY_TEXTBOX, addAddressPOJO.getCity());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_ADDRESS_1_TEXTBOX, addAddressPOJO.getAddress1());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_ADDRESS_2_TEXTBOX, addAddressPOJO.getAddress2());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_ZIP_POSTAL_CODE_TEXTBOX, addAddressPOJO.getZipPostalCode());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_PHONE_NUMBER_TEXTBOX, addAddressPOJO.getPhoneNumber());
        sendKeysToElement(driver, CheckoutPUI.SHIPPING_ADDRESS_FAX_NUMBER_TEXTBOX, addAddressPOJO.getFaxNumber());
    }


    public void clickToShippingAddressContinueButton(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
        clickToElement(driver,CheckoutPUI.SHIPPING_ADDRESS_CONTINUE_BUTTON);
    }

    public void clickToShippingMethodOptionByText(WebDriver driver, String shippingMethodText) {
        waitForElementClickable(driver,CheckoutPUI.DYNAMIC_SHIPPING_METHOD_OPTION_BY_TEXT,shippingMethodText);
        checkToCheckboxOrRadio(driver,CheckoutPUI.DYNAMIC_SHIPPING_METHOD_OPTION_BY_TEXT,shippingMethodText);
    }

    public void clickToShippingMethodContinueButton(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
        clickToElement(driver,CheckoutPUI.SHIPPING_METHOD_CONTINUE_BUTTON);
    }

    public void clickToPaymentMethodOptionByText(WebDriver driver, String paymentMethodText) {
        waitForElementClickable(driver,CheckoutPUI.DYNAMIC_PAYMENT_METHOD_OPTION_BY_TEXT,paymentMethodText);
        checkToCheckboxOrRadio(driver,CheckoutPUI.DYNAMIC_PAYMENT_METHOD_OPTION_BY_TEXT,paymentMethodText);
    }

    public void clickToPaymentMethodContinueButton(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.PAYMENT_METHOD_CONTINUE_BUTTON);
        clickToElement(driver,CheckoutPUI.PAYMENT_METHOD_CONTINUE_BUTTON);
    }

    public void clickToPaymentInformationContinueButton(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.PAYMENT_INFORMATION_CONTINUE_BUTTON);
        clickToElement(driver,CheckoutPUI.PAYMENT_INFORMATION_CONTINUE_BUTTON);
    }

    public boolean isBillingAddressCorrect(WebDriver driver, AddAddressPOJO billingAddressPOJO) {
        boolean match = true;
        String addressType = "billing";

        String name = getTextFieldByAddressTypeAndClassName(driver, addressType, "name");
        String email = getTextFieldByAddressTypeAndClassName(driver, addressType, "email");
        String phone = getTextFieldByAddressTypeAndClassName(driver, addressType, "phone");
        String fax = getTextFieldByAddressTypeAndClassName(driver, addressType, "fax");
        String company = getTextFieldByAddressTypeAndClassName(driver, addressType, "company");
        String country = getTextFieldByAddressTypeAndClassName(driver, addressType, "country"); // Fix
        String stateProvince = getTextFieldByAddressTypeAndClassName(driver, addressType, "stateprovince");
        String city = getTextFieldByAddressTypeAndClassName(driver, addressType, "city");
        String county = getTextFieldByAddressTypeAndClassName(driver, addressType, "county");
        String address1 = getTextFieldByAddressTypeAndClassName(driver, addressType, "address1");
        String address2 = getTextFieldByAddressTypeAndClassName(driver, addressType, "address2");
        String zipPostalCode = getTextFieldByAddressTypeAndClassName(driver, addressType, "zippostalcode");

        if (!(billingAddressPOJO.getFirstName() + " " + billingAddressPOJO.getLastName()).equals(name)) {
            System.out.println("Mismatch in name: expected '" + billingAddressPOJO.getFirstName() + " " + billingAddressPOJO.getLastName() + "', actual '" + name + "'");
            match = false;
        }

        if (!("Email: " + billingAddressPOJO.getEmail()).equals(email)) {
            System.out.println("Mismatch in email: expected 'Email: " + billingAddressPOJO.getEmail() + "', actual '" + email + "'");
            match = false;
        }

        if (!("Phone: " + billingAddressPOJO.getPhoneNumber()).equals(phone)) {
            System.out.println("Mismatch in phone: expected 'Phone: " + billingAddressPOJO.getPhoneNumber() + "', actual '" + phone + "'");
            match = false;
        }

        if (!("Fax: " + billingAddressPOJO.getFaxNumber()).equals(fax)) {
            System.out.println("Mismatch in fax: expected 'Fax: " + billingAddressPOJO.getFaxNumber() + "', actual '" + fax + "'");
            match = false;
        }

        if (!billingAddressPOJO.getCompany().equals(company)) {
            System.out.println("Mismatch in company: expected '" + billingAddressPOJO.getCompany() + "', actual '" + company + "'");
            match = false;
        }

        if (!billingAddressPOJO.getCountry().equals(country)) {
            System.out.println("Mismatch in country: expected '" + billingAddressPOJO.getCountry() + "', actual '" + country + "'");
            match = false;
        }

        if (!billingAddressPOJO.getStateProvince().equals(stateProvince)) {
            System.out.println("Mismatch in state/province: expected '" + billingAddressPOJO.getStateProvince() + "', actual '" + stateProvince + "'");
            match = false;
        }

        if (!billingAddressPOJO.getCity().equals(city)) {
            System.out.println("Mismatch in city: expected '" + billingAddressPOJO.getCity() + "', actual '" + city + "'");
            match = false;
        }

//        if (!billingAddressPOJO.getCounty().equals(county)) {
//            System.out.println("Mismatch in county: expected '" + billingAddressPOJO.get() + "', actual '" + county + "'");
//            match = false;
//        }

        if (!billingAddressPOJO.getAddress1().equals(address1)) {
            System.out.println("Mismatch in address1: expected '" + billingAddressPOJO.getAddress1() + "', actual '" + address1 + "'");
            match = false;
        }

        if (!billingAddressPOJO.getAddress2().equals(address2)) {
            System.out.println("Mismatch in address2: expected '" + billingAddressPOJO.getAddress2() + "', actual '" + address2 + "'");
            match = false;
        }

        if (!billingAddressPOJO.getZipPostalCode().equals(zipPostalCode)) {
            System.out.println("Mismatch in zip/postal code: expected '" + billingAddressPOJO.getZipPostalCode() + "', actual '" + zipPostalCode + "'");
            match = false;
        }

        return match;
    }


    public String getTextFieldByAddressTypeAndClassName(WebDriver driver, String addressType,String fieldClassName) {
        return getTextElement(driver,CheckoutPUI.DYNAMIC_CONFIRM_ORDER_FIELD_BY_ADDRESS_TYPE_AND_FIELD_CLASS_NAME,addressType,fieldClassName);
    }

    public boolean isShippingAddressCorrect(WebDriver driver, AddAddressPOJO shippingAddressPOJO) {
        boolean match = true;
        String addressType = "shipping";

        String name = getTextFieldByAddressTypeAndClassName(driver, addressType, "name");
        String email = getTextFieldByAddressTypeAndClassName(driver, addressType, "email");
        String phone = getTextFieldByAddressTypeAndClassName(driver, addressType, "phone");
        String fax = getTextFieldByAddressTypeAndClassName(driver, addressType, "fax");
        String company = getTextFieldByAddressTypeAndClassName(driver, addressType, "company");
        String country = getTextFieldByAddressTypeAndClassName(driver, addressType, "country");
        String stateProvince = getTextFieldByAddressTypeAndClassName(driver, addressType, "stateprovince");
        String city = getTextFieldByAddressTypeAndClassName(driver, addressType, "city");
        String county = getTextFieldByAddressTypeAndClassName(driver, addressType, "county");
        String address1 = getTextFieldByAddressTypeAndClassName(driver, addressType, "address1");
        String address2 = getTextFieldByAddressTypeAndClassName(driver, addressType, "address2");
        String zipPostalCode = getTextFieldByAddressTypeAndClassName(driver, addressType, "zippostalcode");

        if (!(shippingAddressPOJO.getFirstName() + " " + shippingAddressPOJO.getLastName()).equals(name)) {
            System.out.println("Mismatch in name: expected '" + shippingAddressPOJO.getFirstName() + " " + shippingAddressPOJO.getLastName() + "', actual '" + name + "'");
            match = false;
        }

        if (!("Email: " + shippingAddressPOJO.getEmail()).equals(email)) {
            System.out.println("Mismatch in email: expected 'Email: " + shippingAddressPOJO.getEmail() + "', actual '" + email + "'");
            match = false;
        }

        if (!("Phone: " + shippingAddressPOJO.getPhoneNumber()).equals(phone)) {
            System.out.println("Mismatch in phone: expected 'Phone: " + shippingAddressPOJO.getPhoneNumber() + "', actual '" + phone + "'");
            match = false;
        }

        if (!("Fax: " + shippingAddressPOJO.getFaxNumber()).equals(fax)) {
            System.out.println("Mismatch in fax: expected 'Fax: " + shippingAddressPOJO.getFaxNumber() + "', actual '" + fax + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getCompany().equals(company)) {
            System.out.println("Mismatch in company: expected '" + shippingAddressPOJO.getCompany() + "', actual '" + company + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getCountry().equals(country)) {
            System.out.println("Mismatch in country: expected '" + shippingAddressPOJO.getCountry() + "', actual '" + country + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getStateProvince().equals(stateProvince)) {
            System.out.println("Mismatch in state/province: expected '" + shippingAddressPOJO.getStateProvince() + "', actual '" + stateProvince + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getCity().equals(city)) {
            System.out.println("Mismatch in city: expected '" + shippingAddressPOJO.getCity() + "', actual '" + city + "'");
            match = false;
        }

//        if (!shippingAddressPOJO.getCounty().equals(county)) {
//            System.out.println("Mismatch in county: expected '" + shippingAddressPOJO.getCounty() + "', actual '" + county + "'");
//            match = false;
//        }

        if (!shippingAddressPOJO.getAddress1().equals(address1)) {
            System.out.println("Mismatch in address1: expected '" + shippingAddressPOJO.getAddress1() + "', actual '" + address1 + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getAddress2().equals(address2)) {
            System.out.println("Mismatch in address2: expected '" + shippingAddressPOJO.getAddress2() + "', actual '" + address2 + "'");
            match = false;
        }

        if (!shippingAddressPOJO.getZipPostalCode().equals(zipPostalCode)) {
            System.out.println("Mismatch in zip/postal code: expected '" + shippingAddressPOJO.getZipPostalCode() + "', actual '" + zipPostalCode + "'");
            match = false;
        }

        return match;
    }


    public void uncheckToShipToSameAddressCheckbox(WebDriver driver) {
        waitForElementClickable(driver,CheckoutPUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
        uncheckToCheckboxOrRadio(driver, CheckoutPUI.SHIP_TO_SAME_ADDRESS_CHECKBOX);
    }

    public void uncheckToPickupCheckbox(WebDriver driver) {
        waitForElementClickable(driver, CheckoutPUI.PICKUP_CHECKBOX);
        uncheckToCheckboxOrRadio(driver,CheckoutPUI.PICKUP_CHECKBOX);
    }

    public void clickToConfirmOrderConfirmButton(WebDriver driver) {
        waitForElementClickable(driver, CheckoutPUI.CONFIRM_ORDER_CONFIRM_BUTTON);
        clickToElement(driver,CheckoutPUI.CONFIRM_ORDER_CONFIRM_BUTTON);
    }

    public String getOrderSuccessMessage(WebDriver driver) {
        return getTextElement(driver,CheckoutPUI.ORDER_SUCCESS_MESSAGE);
    }

    public int getOrderNumber(WebDriver driver) {
        String orderNumberString = getTextElement(driver,CheckoutPUI.ORDER_NUMBER_TEXT).split(" ")[2];
        return Integer.parseInt(orderNumberString);
    }

    public void inputCardPaymentInfo(WebDriver driver, CardPOJO cardPOJO) {
        waitForElementVisible(driver,CheckoutPUI.CARD_TYPE_DROPDOWN);
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.CARD_TYPE_DROPDOWN,cardPOJO.getCardType());
        sendKeysToElement(driver, CheckoutPUI.CARD_HOLDER_NAME_TEXTBOX,cardPOJO.getCardHolderName());
        sendKeysToElement(driver,CheckoutPUI.CARD_NUMBER_TEXTBOX,cardPOJO.getCardNumber());
        sendKeysToElement(driver,CheckoutPUI.CARD_CODE_TEXTBOX,cardPOJO.getCardCode());
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.CARD_EXPIRATION_MONTH_DROPDOWN,cardPOJO.getExpirationMonth());
        selectItemInDropdownByVisibleText(driver,CheckoutPUI.CARD_EXPIRATION_YEAR_DROPDOWN,cardPOJO.getExpirationYear());
    }
}
