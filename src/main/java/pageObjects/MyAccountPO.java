package pageObjects;

import commons.BasePage;
import model.nopcommerce.AddAddressPOJO;
import model.nopcommerce.ChangePasswordPOJO;
import model.nopcommerce.UpdateCustomerPOJO;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.MyAccountPUI;
import pageUIs.nopcommerce.ProductPUI;

public class MyAccountPO extends BasePage {
    WebDriver driver;

    public MyAccountPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToSideNavLinkByText(WebDriver driver, String sideNavLinkText) {
        waitForElementClickable(driver, MyAccountPUI.DYNAMIC_SIDE_NAV_LINK_BY_TEXT,sideNavLinkText);
        clickToElement(driver, MyAccountPUI.DYNAMIC_SIDE_NAV_LINK_BY_TEXT,sideNavLinkText);
    }

    public String getFirstReviewInfoTitle(WebDriver driver) {
        return getTextElement(driver,MyAccountPUI.REVIEW_TITLE_INFO);
    }

    public String getFirstReviewInfoText(WebDriver driver) {
        return getTextElement(driver,MyAccountPUI.REVIEW_TEXT_INFO);
    }

    public String getFirstReviewInfoRating(WebDriver driver) {
        String ratingValue = getAttributeValue(driver, MyAccountPUI.REVIEW_RATING_INFO,"style").substring(6).replaceAll(";","").trim();
        System.out.println(ratingValue);
        switch (ratingValue) {
            case "0%":
                return "0";
            case "20%":
                return "1";
            case "40%":
                return "2";
            case "60%":
                return "3";
            case "80%":
                return "4";
            case "100%":
                return "5";
            default:
                return "Unknown";
        }
    }

    public String getFirstReviewInfoProductItemName(WebDriver driver) {
        return getTextElement(driver,MyAccountPUI.REVIEW_PRODUCT_ITEM_NAME);
    }

    public void inputChangePasswordForm(WebDriver driver, ChangePasswordPOJO changePasswordPOJO) {
        sendKeysToElement(driver,MyAccountPUI.OLD_PASSWORD_TEXTBOX,changePasswordPOJO.getOldPassword());
        sendKeysToElement(driver,MyAccountPUI.NEW_PASSWORD_TEXTBOX, changePasswordPOJO.getNewPassword());
        sendKeysToElement(driver,MyAccountPUI.CONFIRM_NEW_PASSWORD_TEXTBOX, changePasswordPOJO.getConfirmNewPassword());
    }

    public void clickToChangePasswordButton(WebDriver driver) {
        waitForElementClickable(driver,MyAccountPUI.CHANGE_PASSWORD_BUTTON);
        clickToElement(driver,MyAccountPUI.CHANGE_PASSWORD_BUTTON);
    }

    public void clickToAddNewAddressButton(WebDriver driver) {
        waitForElementClickable(driver,MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver,MyAccountPUI.ADD_NEW_ADDRESS_BUTTON);
    }

    public void inputAddAddressInfoForm(WebDriver driver, AddAddressPOJO addAddressPOJO) {
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_FIRST_NAME_TEXTBOX,addAddressPOJO.getFirstName());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_LAST_NAME_TEXTBOX, addAddressPOJO.getLastName());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_EMAIL_TEXTBOX,addAddressPOJO.getEmail());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_COMPANY_TEXTBOX, addAddressPOJO.getCompany());

        selectItemInDropdownByVisibleText(driver,MyAccountPUI.ADDRESS_COUNTRY_SELECTION, addAddressPOJO.getCountry());
        selectItemInDropdownByVisibleText(driver,MyAccountPUI.ADDRESS_STATE_PROVINCE_SELECTION, addAddressPOJO.getStateProvince());

        sendKeysToElement(driver,MyAccountPUI.ADDRESS_CITY_TEXTBOX, addAddressPOJO.getCity());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_ADDRESS_1_TEXTBOX, addAddressPOJO.getAddress1());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_ADDRESS_2_TEXTBOX, addAddressPOJO.getAddress2());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_ZIP_POSTAL_CODE_TEXTBOX, addAddressPOJO.getZipPostalCode());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_PHONE_NUMBER_TEXTBOX, addAddressPOJO.getPhoneNumber());
        sendKeysToElement(driver,MyAccountPUI.ADDRESS_FAX_NUMBER_TEXTBOX, addAddressPOJO.getFaxNumber());
        
    }

    public void clickToAddressInfoSaveButton(WebDriver driver) {
        waitForElementClickable(driver,MyAccountPUI.SAVE_ADDRESS_BUTTON);
        clickToElement(driver,MyAccountPUI.SAVE_ADDRESS_BUTTON);
    }

    public String getFirstAddressInfoText(WebDriver driver) {
        return getTextElement(driver,MyAccountPUI.ADDRESS_INFO_TITLE);
    }
    public void clickToGenderRadioButtonByText(WebDriver driver, String value) {
        waitForElementClickable(driver,MyAccountPUI.DYNAMIC_GENDER_RADIO_BUTTON,value);
        checkToCheckboxOrRadio(driver,MyAccountPUI.DYNAMIC_GENDER_RADIO_BUTTON,value);
    }

    public void inputUpdateCustomerInfoForm(WebDriver driver, UpdateCustomerPOJO updateCustomerPOJO) {
        sendKeysToElement(driver,MyAccountPUI.FIRST_NAME_TEXTBOX,updateCustomerPOJO.getFirstName());
        sendKeysToElement(driver,MyAccountPUI.LAST_NAME_TEXTBOX, updateCustomerPOJO.getLastName());
        sendKeysToElement(driver,MyAccountPUI.EMAIL_TEXTBOX, updateCustomerPOJO.getEmail());
        sendKeysToElement(driver,MyAccountPUI.COMPANY_NAME_TEXTBOX, updateCustomerPOJO.getCompanyName());

    }

    public void clickToCustomerInfoSaveButton(WebDriver driver) {
        waitForElementClickable(driver,MyAccountPUI.SAVE_BUTTON);
        clickToElement(driver,MyAccountPUI.SAVE_BUTTON);
    }
}
