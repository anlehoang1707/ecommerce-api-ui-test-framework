package pageObjects.nopcommerce.users;

import commons.BasePage;
import model.nopcommerce.users.RegisterPOJO;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.nopcommerce.users.RegisterPUI;

public class RegisterPO extends BasePage {
    private WebDriver driver;

    public RegisterPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToRegisterButton(WebDriver driver) {
        clickToElement(driver, RegisterPUI.REGISTER_BUTTON);
    }

    public String getFirstNameErrorMessage(WebDriver driver) {
        return getTextElement(driver, RegisterPUI.FIRST_NAME_ERROR_MESSAGE);
    }

    public String getLastNameErrorMessage(WebDriver driver) {
        return getTextElement(driver, RegisterPUI.LAST_NAME_ERROR_MESSAGE);
    }

    public String getEmailErrorMessage(WebDriver driver) {
        return getTextElement(driver, RegisterPUI.EMAIL_ERROR_MESSAGE);
    }

    public String getHeaderErrorMessage(WebDriver driver) {
        return getTextElement(driver, RegisterPUI.HEADER_ERROR_MESSAGE);
    }

    public String getPasswordErrorMessage(WebDriver driver) {
        return getTextElement(driver, RegisterPUI.PASSWORD_ERROR_MESSAGE);
    }

    public void inputRegisterForm(WebDriver driver,RegisterPOJO registerPOJO) {
        sendKeysToElement(driver,RegisterPUI.FIRST_NAME_TEXTBOX,registerPOJO.getFirstName());
        sendKeysToElement(driver,RegisterPUI.LAST_NAME_TEXTBOX,registerPOJO.getLastName());
        sendKeysToElement(driver,RegisterPUI.EMAIL_TEXTBOX,registerPOJO.getEmail());
        sendKeysToElement(driver,RegisterPUI.COMPANY_NAME_TEXTBOX,registerPOJO.getCompanyName());
        sendKeysToElement(driver,RegisterPUI.PASSWORD_TEXTBOX,registerPOJO.getPassword());
        sendKeysToElement(driver,RegisterPUI.CONFIRM_PASSWORD_TEXTBOX,registerPOJO.getConfirmPassword());
    }

    public String getRegisterSuccessMessage(WebDriver driver) {
        return getTextElement(driver,RegisterPUI.REGISTER_SUCCESS_MESSAGE);
    }

    public String getConfirmPasswordErrorMessage(WebDriver driver) {
        return getTextElement(driver,RegisterPUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
    }

    public HomePO clickToLogoutNavButton(WebDriver driver) {
        clickToElement(driver,RegisterPUI.LOGOUT_NAV_BUTTON);
        return PageGenerator.getHomePO(driver);
    }
}
