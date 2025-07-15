package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.MyAccountPO;

public class PageGenerator {
    public static RegisterPO getRegisterPO(WebDriver driver) {
        return new RegisterPO(driver);
    }

    public static HomePO getHomePO(WebDriver driver) {
        return new HomePO(driver);
    }

    public static LoginPO getLoginPO(WebDriver driver) {
        return new LoginPO(driver);
    }

    public static MyAccountPO getMyAccountPO(WebDriver driver) {
        return new MyAccountPO(driver);
    }
    public static ProductPO getProductPO(WebDriver driver) {
        return new ProductPO(driver);
    }

    public static SearchPO getSearchPO(WebDriver driver) {
        return new SearchPO(driver);
    }

    public static CartPO getCartPO(WebDriver driver) {
        return new CartPO(driver);
    }

    public static CheckoutPO getCheckoutPO(WebDriver driver) {
        return new CheckoutPO(driver);
    }
}
