package pageObjects.nopcommerce.admin;

import commons.BasePage;
import model.nopcommerce.admin.AddNewCustomerPOJO;
import model.nopcommerce.users.AddAddressPOJO;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.nopcommerce.admin.AdminCustomerPUI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminCustomerPO extends BasePage {
    WebDriver driver;
    public AdminCustomerPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToAddNewButton(WebDriver driver) {
        waitForElementClickable(driver, AdminCustomerPUI.ADD_NEW_BUTTON);
        clickToElement(driver,AdminCustomerPUI.ADD_NEW_BUTTON);
    }

    public void inputAddNewCustomerInfo(WebDriver driver, AddNewCustomerPOJO addNewCustomerPOJO) {
        sendKeysToElement(driver,AdminCustomerPUI.EMAIL_TEXTBOX, addNewCustomerPOJO.getEmail());
        sendKeysToElement(driver,AdminCustomerPUI.PASSWORD_TEXTBOX, addNewCustomerPOJO.getPassword());
        sendKeysToElement(driver,AdminCustomerPUI.FIRST_NAME_TEXTBOX, addNewCustomerPOJO.getFirstName());
        sendKeysToElement(driver,AdminCustomerPUI.LAST_NAME_TEXTBOX, addNewCustomerPOJO.getLastName());
        checkToCheckboxOrRadio(driver,AdminCustomerPUI.DYNAMIC_GENDER_RADIO_BY_TEXT,addNewCustomerPOJO.getGender());
        sendKeysToElement(driver,AdminCustomerPUI.COMPANY_TEXTBOX, addNewCustomerPOJO.getCompanyName());
        sendKeysToCustomerRolesTextbox(driver,addNewCustomerPOJO.getCustomerRoles());
        checkToCheckboxOrRadio(driver,AdminCustomerPUI.ACTIVE_CHECKBOX);
        sendKeysToElement(driver,AdminCustomerPUI.ADMIN_COMMENT_TEXTAREA, addNewCustomerPOJO.getAdminComment());
    }

    public void sendKeysToCustomerRolesTextbox(WebDriver driver, String valueText) {
        List<WebElement> listRemoveIcons = getListElements(driver,AdminCustomerPUI.LIST_REMOVE_CUSTOMER_ROLES_ICON);

        for(int i =1;i<=listRemoveIcons.size();i++) {
            clickToElement(driver,AdminCustomerPUI.REMOVE_CUSTOMER_ROLES_ICON_BY_INDEX,String.valueOf(i));
        }

        sendKeysToElement(driver,AdminCustomerPUI.CUSTOMER_ROLES_SEARCH_INLINE_INPUT,valueText);
        sendKeyboardToElement(driver,AdminCustomerPUI.CUSTOMER_ROLES_SEARCH_INLINE_INPUT, Keys.ENTER);
    }

    public void clickToSaveAndContinueEditButton(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
        clickToElement(driver,AdminCustomerPUI.SAVE_AND_CONTINUE_EDIT_BUTTON);
    }

    public String getAlertMessage(WebDriver driver) {
        return getTextElement(driver,AdminCustomerPUI.NOTIFICATION_ALERT_MESSAGE).replaceAll("×"," ").trim();
    }

    public void clickToBackToCustomerListLink(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.BACK_TO_CUSTOMER_LIST_LINK);
        clickToElement(driver,AdminCustomerPUI.BACK_TO_CUSTOMER_LIST_LINK);
    }

    public void clickToSearchButton(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.SEARCH_CUSTOMER_BUTTON);
        clickToElement(driver,AdminCustomerPUI.SEARCH_CUSTOMER_BUTTON);
    }

    public boolean isNewCustomerInfoDisplayedOnList(WebDriver driver, AddNewCustomerPOJO expectedCustomerPOJO) {
        //Map Expected

        Map<String, String> expectedMap = new HashMap<>();
        expectedMap.put("Name",expectedCustomerPOJO.getFirstName() + " " + expectedCustomerPOJO.getLastName());
        expectedMap.put("Customer roles",expectedCustomerPOJO.getCustomerRoles());
        expectedMap.put("Company name",expectedCustomerPOJO.getCompanyName());

        //Actual Map
        List<WebElement> cells = getListElements(driver,AdminCustomerPUI.LIST_DYNAMIC_CELLS_BY_EMAIL,expectedCustomerPOJO.getEmail());
        Map<String,String> actualMap = new HashMap<>();
        actualMap.put("Name",cells.get(3).getText().trim());
        actualMap.put("Customer roles",cells.get(4).getText().trim());
        actualMap.put("Company name",cells.get(5).getText().trim());

        for (String key: expectedMap.keySet()) {
            if (!expectedMap.get(key).equals(actualMap.get(key))) {
                System.out.println("Mismatch at:" + key);
                return false;
            }
        }

    return true;
//TODO
    }

    public int getColumnIndexByColumnName(WebDriver driver,String columnHeaderName) {
        return Integer.parseInt(getAttributeValue(driver,AdminCustomerPUI.DYNAMIC_COLUMN_HEADER_BY_NAME,"data-dt-column",columnHeaderName)) + 1;

    }

    public String getTextElementByColumnNameAndEmail(WebDriver driver, String columnName,String email) {
        int columnIndex = getColumnIndexByColumnName(driver,columnName);
        return getTextElement(driver,AdminCustomerPUI.DYNAMIC_CUSTOMER_ROW_BY_EMAIL_AND_COLUMN_INDEX,columnName,String.valueOf(columnIndex));
    }

    public boolean isNewCustomerInfoCreated(WebDriver driver, AddNewCustomerPOJO addNewCustomerPOJO) {
//TODO
        return true;
    }

    public void sendKeysToEmailSearchTextbox(WebDriver driver, String email) {
        waitForElementClickable(driver,AdminCustomerPUI.SEARCH_EMAIL_TEXTBOX);
        sendKeysToElement(driver,AdminCustomerPUI.SEARCH_EMAIL_TEXTBOX,email);
    }

    public int getDisplayedCustomerSearchResultCount(WebDriver driver) {
        return getListElementsSize(driver,AdminCustomerPUI.LIST_DISPLAYED_CUSTOMER_ROW);
    }

    public void sendKeysToFirstNameSearchTextbox(WebDriver driver, String firstName) {
        waitForElementClickable(driver,AdminCustomerPUI.SEARCH_FIRST_NAME_TEXTBOX);
        sendKeysToElement(driver,AdminCustomerPUI.SEARCH_FIRST_NAME_TEXTBOX,firstName);
    }

    public void sendKeysToLastNameSearchTextbox(WebDriver driver, String lastName) {
        waitForElementClickable(driver,AdminCustomerPUI.SEARCH_LAST_NAME_TEXTBOX);
        sendKeysToElement(driver,AdminCustomerPUI.SEARCH_LAST_NAME_TEXTBOX,lastName);
    }


    public void sendKeysToCompanySearchTextbox(WebDriver driver, String companyName) {
        waitForElementClickable(driver,AdminCustomerPUI.SEARCH_COMPANY_TEXTBOX);
        sendKeysToElement(driver,AdminCustomerPUI.SEARCH_COMPANY_TEXTBOX,companyName);
    }

    public void clickToEditButtonByIndex(WebDriver driver, int index) {
        waitForElementClickable(driver,AdminCustomerPUI.DYNAMIC_EDIT_CUSTOMER_BUTTON_BY_INDEX,String.valueOf(index));
        clickToElement(driver,AdminCustomerPUI.DYNAMIC_EDIT_CUSTOMER_BUTTON_BY_INDEX,String.valueOf(index));
    }

    public void clickToSaveButton(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.SAVE_BUTTON);
        clickToElement(driver,AdminCustomerPUI.SAVE_BUTTON);
    }

    public void clickToAddressSectionHeader(WebDriver driver) {
        String addressCardHeaderClass = getAttributeValue(driver,AdminCustomerPUI.ADDRESS_CARD_HEADER,"class");

        if(addressCardHeaderClass.contains("collapsed")) {
            clickToElement(driver,AdminCustomerPUI.ADDRESS_CARD_HEADER);
        }
    }

    public void clickToAddNewAddressButton(WebDriver driver) {
        waitForElementVisible(driver, AdminCustomerPUI.ADD_NEW_ADDRESS_BUTTON);
        clickToElement(driver, AdminCustomerPUI.ADD_NEW_ADDRESS_BUTTON);
    }

    public void inputAddressInfo(WebDriver driver, AddAddressPOJO addAddressPOJO) {
        //TODO
    }

    public void clickToSaveAddressButton(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.SAVE_ADDRESS_BUTTON);
        clickToElement(driver,AdminCustomerPUI.SAVE_ADDRESS_BUTTON);
    }

    public void clickToBackToCustomerDetailLink(WebDriver driver) {
        waitForElementClickable(driver,AdminCustomerPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
        clickToElement(driver,AdminCustomerPUI.BACK_TO_CUSTOMER_DETAIL_LINK);
    }

    public boolean isNewAddressInfoDisplayed(WebDriver driver, AddAddressPOJO addAddressPOJO) {
        //TODO
        return true;
    }

    public void clickToEditAddressButtonByIndex(WebDriver driver, int index) {
        waitForElementClickable(driver,AdminCustomerPUI.DYNAMIC_EDIT_ADDRESS_BUTTON_BY_INDEX,String.valueOf(index));
        clickToElement(driver,AdminCustomerPUI.DYNAMIC_EDIT_ADDRESS_BUTTON_BY_INDEX,String.valueOf(index));
    }

    public void clickToDeleteAddressButtonByIndex(WebDriver driver, int index) {
        waitForElementVisible(driver,AdminCustomerPUI.DYNAMIC_DELETE_ADDRESS_BUTTON_BY_INDEX,String.valueOf(index));
        clickToElement(driver,AdminCustomerPUI.DYNAMIC_DELETE_ADDRESS_BUTTON_BY_INDEX,String.valueOf(index));
    }

    public void acceptDeleteAddressAlert(WebDriver driver) {
        acceptAlert(driver);
    }

    public String getSearchMessageInAddressTable(WebDriver driver) {
        return getTextElement(driver,AdminCustomerPUI.SEARCH_MESSAGE_IN_ADDRESS_TABLE);
    }
}



