package pageObjects;

import commons.BasePage;
import org.openqa.selenium.WebDriver;

public class CartPO extends BasePage {
    private WebDriver driver;

    public CartPO(WebDriver driver) {
        this.driver = driver;
    }
}
