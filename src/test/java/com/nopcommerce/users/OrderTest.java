package com.nopcommerce.users;

import commons.BaseTest;
import model.nopcommerce.users.AddAddressPOJO;
import model.nopcommerce.users.CardPOJO;
import model.nopcommerce.users.RegisterPOJO;
import model.nopcommerce.products.DesktopPOJO;
import model.nopcommerce.products.ProductFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.*;
import pageObjects.nopcommerce.users.*;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderTest extends BaseTest {
    HomePO homePO;
    ProductPO productPO;
    CartPO cartPO;
    CheckoutPO checkoutPO;
    String productSubCategoryItemName;
    String productItemName;
    Float productPrice;
    DesktopPOJO desktopPOJO;
    DesktopPOJO updateDesktopPOJO;
    RegisterPOJO registerPOJO;
    RegisterPOJO newUserPOJO;
    int productQuantity;
    MyAccountPO myAccountPO;
    String shippingMethod;
    String paymentMethod;
    AddAddressPOJO billingAddressPOJO, shippingAddressPOJO;
    CardPOJO cardPOJO;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(url,browserName);
        productSubCategoryItemName = "Desktops";
        productItemName = "Build your own computer";

        registerPOJO = new RegisterPOJO();
        homePO = PageGenerator.getHomePO(driver);
        newUserPOJO = registerUser(driver,homePO,registerPOJO);
        homePO.loginUser(driver,homePO, newUserPOJO.getEmail(),newUserPOJO.getPassword());
        homePO.clickToHeaderMenuByText(driver,"Computers");
        productPO = PageGenerator.getProductPO(driver);
        productPO.clickToSubCategoryItemByText(driver,productSubCategoryItemName);

        desktopPOJO = (DesktopPOJO) ProductFactory.createProductPOJO("Desktops");
        desktopPOJO.configureBuildYourOwnDesktop("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]","2 GB","320 GB","Vista Premium [+$60.00]", new ArrayList<>(Arrays.asList("Microsoft Office [+$50.00]")));

        updateDesktopPOJO = (DesktopPOJO) ProductFactory.createProductPOJO("Desktops");
        updateDesktopPOJO.configureBuildYourOwnDesktop("2.2 GHz Intel Pentium Dual-Core E2200","4GB [+$20.00]","320 GB","Vista Home [+$50.00]", new ArrayList<>(Arrays.asList("Microsoft Office [+$50.00]")));
        productQuantity = 2 ;
        shippingMethod = "Ground ($0.00)";
        billingAddressPOJO = getBillingAddressPOJO();
        shippingAddressPOJO = getShippingAddressPOJO();
        cardPOJO = new CardPOJO("Visa","An Le","409912345678","12","2035","123");
    }

    @Test
    public void TC_01_Order_Add_Product_To_Cart() {
        productPO.clickToProductItemByText(driver,productItemName);

        productPO.selectDropdownByProductAttributeAndValue(driver,"Processor",desktopPOJO.getProcessor());
        productPO.selectDropdownByProductAttributeAndValue(driver,"RAM",desktopPOJO.getRam());
        productPO.checkToCheckboxOrRadioByProductAttributeAndValue(driver, "HDD",desktopPOJO.getHdd());
        productPO.checkToCheckboxOrRadioByProductAttributeAndValue(driver, "OS",desktopPOJO.getOs());
        productPO.checkToCheckboxOrRadioByProductAttributeAndValue(driver, "Software",desktopPOJO.getSoftware().get(0));


        productPO.clickToAddToCartButton(driver);
        productPO.waitForLoadingIconDisappear(driver);

        productPrice = productPO.getProductPrice(driver);

        Assert.assertEquals(productPO.getBarNotificationMessageText(driver),"The product has been added to your shopping cart");
        productPO.closeBarNotification(driver);
        productPO.waitForBarNotificationDisappear(driver);
        productPO.clickToNavLinkByClassName(driver, "ico-cart");
        cartPO = PageGenerator.getCartPO(driver);

        Assert.assertEquals(cartPO.getFirstProductName(driver),productItemName);
        Assert.assertTrue(cartPO.getFirstProductAttribute(driver).contains("RAM:" + " " + desktopPOJO.getRam()));
        Assert.assertTrue(cartPO.getFirstProductAttribute(driver).contains("HDD:" + " " + desktopPOJO.getHdd()));
        Assert.assertTrue(cartPO.getFirstProductAttribute(driver).contains("OS:" + " " + desktopPOJO.getOs()));
        System.out.println(desktopPOJO.getSoftware());
        for (int i = 0; i < desktopPOJO.getSoftware().size();i++) {
            Assert.assertTrue(cartPO.getFirstProductAttribute(driver).contains("Software:" + " " + desktopPOJO.getSoftware().get(i)));
        }
        Assert.assertEquals(cartPO.getCartTotalInfoByAttribute(driver,"Sub-Total"),productPrice);
    }

    @Test
    public void TC_02_Order_Edit_Product_In_Cart() {
        Assert.assertTrue(cartPO.isEditLinkAtProductNameDisplayed(driver,productItemName));
        cartPO.clickToEditLinkAtProductName(driver,productItemName);

//        productPO = PageGenerator.getProductPO(driver);

        productPO.selectDropdownByProductAttributeAndValue(driver,"Processor", updateDesktopPOJO.getProcessor());
        productPO.selectDropdownByProductAttributeAndValue(driver,"RAM", updateDesktopPOJO.getRam());
        productPO.checkToCheckboxOrRadioByProductAttributeAndValue(driver,"OS", updateDesktopPOJO.getOs());
        productPO.updateProductQuantity(driver, productQuantity);
        productPO.clickToUpdateButton(driver);


        Assert.assertEquals(productPO.getProductPrice(driver),1320.00f);
        Assert.assertEquals(productPO.getBarNotificationMessageText(driver),"The product has been added to your shopping cart");

        productPO.closeBarNotification(driver);
        productPO.waitForBarNotificationDisappear(driver);
        productPO.clickToNavLinkByClassName(driver, "ico-cart");
        cartPO = PageGenerator.getCartPO(driver);

        Assert.assertEquals(cartPO.getCartTotalInfoByAttribute(driver,"Total"),2640.00f);

    }

    @Test
    public void TC_03_Order_Remove_Product_From_Cart() {
        cartPO.clickToRemoveIconAtProductName(driver,productItemName);
        Assert.assertTrue(cartPO.getOrderContentSummary(driver).contains("Your Shopping Cart is empty!"));
    }

    @Test
    public void TC_04_Order_Update_Cart() {
        cartPO.clickToHeaderMenuByText(driver,"Computers");

        productPO = PageGenerator.getProductPO(driver);
        productPO.clickToSubCategoryItemByText(driver, productSubCategoryItemName);
        productPO.clickToProductItemByText(driver,"Lenovo IdeaCentre");
        productPO.updateProductQuantity(driver,5);
        productPO.clickToAddToCartButton(driver);
        productPO.waitForLoadingIconDisappear(driver);
        Assert.assertEquals(productPO.getBarNotificationMessageText(driver),"The product has been added to your shopping cart");
        productPO.closeBarNotification(driver);
        productPO.waitForBarNotificationDisappear(driver);

        productPO.clickToNavLinkByClassName(driver,"ico-cart");

        cartPO = PageGenerator.getCartPO(driver);
        Assert.assertEquals(cartPO.getCartTotalInfoByAttribute(driver,"Sub-Total"),2500.00f);
    }

    @Test
    public void TC_05_Order_Checkout_With_Cheque() {
        paymentMethod = "Check / Money Order";
        cartPO.clickToAgreeTermAndServiceCheckbox(driver);
        cartPO.clickToCheckoutButton(driver);
        checkoutPO = PageGenerator.getCheckoutPO(driver);

        checkoutPO.uncheckToShipToSameAddressCheckbox(driver);
//        checkoutPO.clickToNewAddressOptionAtBillingAddress(driver);
        checkoutPO.inputNewBillingAddressInfoForm(driver,billingAddressPOJO);
        checkoutPO.clickToBillingAddressContinueButton(driver);

        checkoutPO.uncheckToPickupCheckbox(driver);
        checkoutPO.clickToNewAddressOptionAtShippingAddress(driver);
        checkoutPO.inputNewShippingAddressInfoForm(driver,shippingAddressPOJO);
        checkoutPO.clickToShippingAddressContinueButton(driver);

        checkoutPO.clickToShippingMethodOptionByText(driver,shippingMethod);
        checkoutPO.clickToShippingMethodContinueButton(driver);

        checkoutPO.clickToPaymentMethodOptionByText(driver,paymentMethod);
        checkoutPO.clickToPaymentMethodContinueButton(driver);

        checkoutPO.clickToPaymentInformationContinueButton(driver);

        Assert.assertTrue(checkoutPO.isBillingAddressCorrect(driver,billingAddressPOJO));
        Assert.assertTrue(checkoutPO.isShippingAddressCorrect(driver,shippingAddressPOJO));
//      TODO: Assert.assertTrue(checkoutPO.isCartCorrect(driver,cartPOJO));
//        TODO: Assert.assertTrue(checkoutPO.isPaymentMethodDisplayedCorrect(driver,paymentMethod));


        checkoutPO.clickToConfirmOrderConfirmButton(driver);

        Assert.assertEquals(checkoutPO.getOrderSuccessMessage(driver),"Your order has been successfully processed!");

        int orderNumber = checkoutPO.getOrderNumber(driver);

        checkoutPO.clickToNavLinkByClassName(driver,"ico-account");
        myAccountPO = PageGenerator.getMyAccountPO(driver);
        myAccountPO.clickToSideNavLinkByText(driver,"Orders");
        Assert.assertEquals(myAccountPO.getLatestOrderNumber(driver),orderNumber);

    }

    @Test
    public void TC_06_Order_Checkout_With_Card() {
        paymentMethod = "Credit Card";
        myAccountPO.clickToHeaderMenuByText(driver,"Computers");
        productPO = PageGenerator.getProductPO(driver);
        productPO.clickToSubCategoryItemByText(driver,productSubCategoryItemName);
        productPO.clickToProductItemByText(driver,"Lenovo IdeaCentre");
        productPO.updateProductQuantity(driver,5);
        productPO.clickToAddToCartButton(driver);
        productPO.waitForLoadingIconDisappear(driver);
        Assert.assertEquals(productPO.getBarNotificationMessageText(driver),"The product has been added to your shopping cart");
        productPO.closeBarNotification(driver);
        productPO.waitForBarNotificationDisappear(driver);
        productPO.clickToNavLinkByClassName(driver,"ico-cart");
        cartPO = PageGenerator.getCartPO(driver);
        Assert.assertEquals(cartPO.getCartTotalInfoByAttribute(driver,"Sub-Total"),2500.00f);

        cartPO.clickToAgreeTermAndServiceCheckbox(driver);
        cartPO.clickToCheckoutButton(driver);
        checkoutPO = PageGenerator.getCheckoutPO(driver);

        checkoutPO.uncheckToShipToSameAddressCheckbox(driver);
        checkoutPO.clickToNewAddressOptionAtBillingAddress(driver);
        checkoutPO.inputNewBillingAddressInfoForm(driver,billingAddressPOJO);
        checkoutPO.clickToBillingAddressContinueButton(driver);

        checkoutPO.uncheckToPickupCheckbox(driver);
        checkoutPO.clickToNewAddressOptionAtShippingAddress(driver);
        checkoutPO.inputNewShippingAddressInfoForm(driver,shippingAddressPOJO);
        checkoutPO.clickToShippingAddressContinueButton(driver);

        checkoutPO.clickToShippingMethodOptionByText(driver,shippingMethod);
        checkoutPO.clickToShippingMethodContinueButton(driver);

        checkoutPO.clickToPaymentMethodOptionByText(driver,paymentMethod);
        checkoutPO.clickToPaymentMethodContinueButton(driver);
        checkoutPO.inputCardPaymentInfo(driver,cardPOJO);
        checkoutPO.clickToPaymentInformationContinueButton(driver);

        Assert.assertTrue(checkoutPO.isBillingAddressCorrect(driver,billingAddressPOJO));
        Assert.assertTrue(checkoutPO.isShippingAddressCorrect(driver,shippingAddressPOJO));

        checkoutPO.clickToConfirmOrderConfirmButton(driver);

        Assert.assertEquals(checkoutPO.getOrderSuccessMessage(driver),"Your order has been successfully processed!");

        int orderNumber = checkoutPO.getOrderNumber(driver);

        checkoutPO.clickToNavLinkByClassName(driver,"ico-account");
        myAccountPO = PageGenerator.getMyAccountPO(driver);
        myAccountPO.clickToSideNavLinkByText(driver,"Orders");
        Assert.assertEquals(myAccountPO.getLatestOrderNumber(driver),orderNumber);


    }

    @Test
    public void TC_07_Order_ReOrder() {

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
