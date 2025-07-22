package pageObjects.nopcommerce.admin;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import pageUIs.nopcommerce.admin.AdminHomePUI;

public class AdminHomePO extends BasePage {
    WebDriver driver;
    public AdminHomePO(WebDriver driver) {
        this.driver = driver;
    }

}
