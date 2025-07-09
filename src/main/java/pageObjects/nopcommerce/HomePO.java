package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.MyAccountPO;
import pageUIs.nopcommerce.HomePUI;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPO clickToRegisterNavButton(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.REGISTER_NAV_BUTTON);
        clickToElement(driver, HomePUI.REGISTER_NAV_BUTTON);
        return PageGenerator.getRegisterPO(driver);
    }

    public boolean isMyAccountNavButtonDislayed(WebDriver driver) {
        return isControlDisplayed(driver,HomePUI.MY_ACCOUNT_NAV_BUTTON);
    }

    public LoginPO clickToLoginNavButton(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.LOGIN_NAV_BUTTON);
        clickToElement(driver,HomePUI.LOGIN_NAV_BUTTON);
        return PageGenerator.getLoginPO(driver);
    }

    public MyAccountPO clickToMyAccountNavButton(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.MY_ACCOUNT_NAV_BUTTON);
        clickToElement(driver,HomePUI.MY_ACCOUNT_NAV_BUTTON);
        return PageGenerator.getMyAccountPO(driver);

    }
}
