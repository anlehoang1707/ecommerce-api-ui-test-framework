package pageObjects.nopcommerce;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CheckoutPO extends BasePage {
    WebDriver driver;
    public CheckoutPO(WebDriver driver) {
        this.driver = driver;
    }
}
