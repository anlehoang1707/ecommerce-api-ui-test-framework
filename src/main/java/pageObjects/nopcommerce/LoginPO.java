package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.LoginPUI;

public class LoginPO extends BasePage {
    WebDriver driver;

    public LoginPO(WebDriver driver) {
        this.driver = driver;
    }


    public void clickToLoginButton(WebDriver driver) {
        waitForElementClickable(driver, LoginPUI.LOGIN_BUTTON);
        clickToElement(driver,LoginPUI.LOGIN_BUTTON);
    }

    public String getEmailErrorMessage(WebDriver driver) {
        return getTextElement(driver,LoginPUI.EMAIL_ERROR_MESSAGE);
    }

    public void sendKeysToEmailTextbox(WebDriver driver, String keysToSend) {
        waitForElementClickable(driver, LoginPUI.EMAIL_TEXTBOX);
        sendKeysToElement(driver,LoginPUI.EMAIL_TEXTBOX,keysToSend);
    }

    public String getValidationSummaryMessage(WebDriver driver) {
        return getTextElement(driver, LoginPUI.VALIDATION_SUMMARY_ERROR_MESSAGE).split("\n")[0];
    }

    public String getValidationDetailMessage(WebDriver driver) {
        return getTextElement(driver, LoginPUI.VALIDATION_DETAIL_ERROR_MESSAGE);
    }

    public void sendKeysToPasswordTextbox(WebDriver driver, String keysToSend) {
        waitForElementClickable(driver, LoginPUI.PASSWORD_TEXTBOX);
        sendKeysToElement(driver, LoginPUI.PASSWORD_TEXTBOX,keysToSend);
    }
}
