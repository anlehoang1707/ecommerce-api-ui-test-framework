package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;
import pageObjects.nopcommerce.admin.AdminCustomerPO;
import pageObjects.nopcommerce.admin.AdminDetailProductPO;
import pageObjects.nopcommerce.admin.AdminHomePO;
import pageObjects.nopcommerce.admin.AdminProductPO;
import pageObjects.nopcommerce.users.*;

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

    public static AdminHomePO getAdminHomePO(WebDriver driver) {
        return new AdminHomePO(driver);
    }

    public static AdminProductPO getAdminProductPO(WebDriver driver) {
        return new AdminProductPO(driver);
    }

    public static AdminDetailProductPO getAdminDetailProductPO(WebDriver driver) {
        return new AdminDetailProductPO(driver);
    }

    public static AdminCustomerPO getAdminCustomerPO(WebDriver driver) {
        return new AdminCustomerPO(driver);
    }
}
