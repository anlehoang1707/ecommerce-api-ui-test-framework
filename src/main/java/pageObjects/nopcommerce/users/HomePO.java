package pageObjects.nopcommerce.users;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.PageGenerator;
import pageUIs.nopcommerce.admin.AdminHomePUI;
import pageUIs.nopcommerce.users.HomePUI;

public class HomePO extends BasePage {
    WebDriver driver;
    public HomePO(WebDriver driver) {
        this.driver = driver;
    }

    public RegisterPO clickToRegisterNavLink(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.REGISTER_NAV_LINK);
        clickToElement(driver, HomePUI.REGISTER_NAV_LINK);
        return PageGenerator.getRegisterPO(driver);
    }

    public boolean isMyAccountNavButtonDislayed(WebDriver driver) {
        return isControlDisplayed(driver,HomePUI.MY_ACCOUNT_NAV_LINK);
    }

    public LoginPO clickToLoginNavLink(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.LOGIN_NAV_LINK);
        clickToElement(driver,HomePUI.LOGIN_NAV_LINK);
        return PageGenerator.getLoginPO(driver);
    }

    public MyAccountPO clickToMyAccountNavLink(WebDriver driver) {
        waitForElementClickable(driver,HomePUI.MY_ACCOUNT_NAV_LINK);
        clickToElement(driver,HomePUI.MY_ACCOUNT_NAV_LINK);
        return PageGenerator.getMyAccountPO(driver);

    }

    public void clickToAdminHeaderLink(WebDriver driver) {
        waitForElementClickable(driver, HomePUI.ADMIN_HEADER_LINK);
        clickToElement(driver,HomePUI.ADMIN_HEADER_LINK);
    }
}
