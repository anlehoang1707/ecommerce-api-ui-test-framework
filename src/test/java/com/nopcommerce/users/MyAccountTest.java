package com.nopcommerce.users;

import commons.BaseTest;
import model.nopcommerce.users.AddAddressPOJO;
import model.nopcommerce.users.ChangePasswordPOJO;
import model.nopcommerce.users.RegisterPOJO;
import model.nopcommerce.users.UpdateCustomerPOJO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.users.MyAccountPO;
import pageObjects.nopcommerce.users.HomePO;
import pageObjects.nopcommerce.users.LoginPO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.ProductPO;

public class MyAccountTest extends BaseTest {
    HomePO homePO;
    RegisterPOJO registerPOJO;
    RegisterPOJO newUserPOJO;
    MyAccountPO myAccountPO;
    ProductPO productPO;
    String updateCustomerEmail;
    UpdateCustomerPOJO updateCustomerPOJO;
    AddAddressPOJO addAddressPOJO;
    ChangePasswordPOJO changePasswordPOJO;
    String newPassword;
    LoginPO loginPO;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);

        registerPOJO = new RegisterPOJO();
        homePO = PageGenerator.getHomePO(driver);
        newUserPOJO = registerUser(driver,homePO,registerPOJO);
        homePO.loginUser(driver,homePO, newUserPOJO.getEmail(),newUserPOJO.getPassword());
        homePO.clickToNavLinkByText(driver,"My account");
        myAccountPO = PageGenerator.getMyAccountPO(driver);

        updateCustomerEmail = "automationfc.vn" + generateRandom() + "@gmail.com";
        addAddressPOJO = new AddAddressPOJO();
        changePasswordPOJO = new ChangePasswordPOJO();
        newPassword = "Automation@12345";
        updateCustomerPOJO = new UpdateCustomerPOJO();
    }

    @Test
    public void TC_01_MyAccount_Update_Customer_Info() {
        updateCustomerPOJO.setFirstName("Automation");
        updateCustomerPOJO.setLastName("FC");
        updateCustomerPOJO.setEmail(updateCustomerEmail);
        updateCustomerPOJO.setCompanyName("Automation FC");

        myAccountPO.clickToGenderRadioButtonByText(driver,"Female");
        myAccountPO.inputUpdateCustomerInfoForm(driver, updateCustomerPOJO);
        myAccountPO.clickToCustomerInfoSaveButton(driver);

        Assert.assertEquals(myAccountPO.getBarNotificationMessageText(driver),"The customer info has been updated successfully.");
        myAccountPO.closeBarNotification(driver);

    }

    @Test
    public void TC_02_MyAccount_Add_New_Address_Info() {
        addAddressPOJO.setFirstName("Automation");
        addAddressPOJO.setLastName("FC");
        addAddressPOJO.setEmail("automationfc.vn@gmail.com");
        addAddressPOJO.setCompany("Automation FC");
        addAddressPOJO.setCountry("United States of America");
        addAddressPOJO.setStateProvince("Alaska");
        addAddressPOJO.setCity("Da Nang");
        addAddressPOJO.setAddress1("123/04 Le Lai");
        addAddressPOJO.setAddress2("234/05 Hai Phong");
        addAddressPOJO.setZipPostalCode("550000");
        addAddressPOJO.setPhoneNumber("0123456789");
        addAddressPOJO.setFaxNumber("0987654321");


        myAccountPO.clickToSideNavLinkByText(driver,"Addresses");
        myAccountPO.clickToAddNewAddressButton(driver);
        myAccountPO.inputAddAddressInfoForm(driver, addAddressPOJO);
        myAccountPO.clickToAddressInfoSaveButton(driver);

        Assert.assertEquals(myAccountPO.getFirstAddressInfoText(driver),"Automation FC");
        Assert.assertEquals(myAccountPO.getBarNotificationMessageText(driver),"The new address has been added successfully.");
        myAccountPO.closeBarNotification(driver);


    }

    @Test
    public void TC_03_MyAccount_Change_Password() {
        changePasswordPOJO.setOldPassword(newUserPOJO.getPassword());
        changePasswordPOJO.setNewPassword("Automation@12345");
        changePasswordPOJO.setConfirmNewPassword("Automation@12345");
        myAccountPO.clickToSideNavLinkByText(driver,"Change password");
        myAccountPO.inputChangePasswordForm(driver,changePasswordPOJO);
        myAccountPO.clickToChangePasswordButton(driver);

        Assert.assertEquals(myAccountPO.getBarNotificationMessageText(driver),"Password was changed");
        myAccountPO.closeBarNotification(driver);
        myAccountPO.waitForBarNotificationDisappear(driver);

        myAccountPO.logoutUser(driver);
        homePO = PageGenerator.getHomePO(driver);

        loginPO = homePO.clickToLoginNavLink(driver);
        loginPO.loginUser(driver,homePO,updateCustomerEmail, newUserPOJO.getPassword());
        Assert.assertEquals(loginPO.getValidationSummaryMessage(driver),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(loginPO.getValidationDetailMessage(driver),"The credentials provided are incorrect");


        loginPO.loginUser(driver,homePO,updateCustomerEmail, changePasswordPOJO.getNewPassword());
        homePO = PageGenerator.getHomePO(driver);
        Assert.assertTrue(homePO.isMyAccountNavButtonDislayed(driver));
        myAccountPO = homePO.clickToMyAccountNavLink(driver);

    }

    @Test
    public void TC_04_MyAccount_Verify_Product_Review() {
        String reviewSummary = "Review Summary";
        String reviewText = "Review Paragraph";
        String reviewRating = "3";
        String productSubCategoryItemName = "Desktops";
        String productItemName = "Build your own computer";
        myAccountPO.clickToHeaderMenuByText(driver,"Computers");
        productPO = PageGenerator.getProductPO(driver);
        productPO.clickToSubCategoryItemByText(driver,productSubCategoryItemName);
        productPO.clickToProductItemByText(driver,productItemName);
        productPO.clickToAddReviewLink(driver);
        productPO.inputToReviewTitle(driver,reviewSummary);
        productPO.inputToReviewText(driver,reviewText);
        productPO.selectReviewOptionByIndex(driver,reviewRating);
        productPO.clickToSubmitReviewButton(driver);

        Assert.assertEquals(productPO.getBarNotificationMessageText(driver),"Product review is successfully added.");
        productPO.closeBarNotification(driver);
        productPO.waitForBarNotificationDisappear(driver);

        productPO.clickToNavLinkByText(driver,"My account");
        myAccountPO = PageGenerator.getMyAccountPO(driver);
        myAccountPO.clickToSideNavLinkByText(driver,"My product reviews");

        Assert.assertEquals(myAccountPO.getFirstReviewInfoTitle(driver),reviewSummary);
        Assert.assertEquals(myAccountPO.getFirstReviewInfoText(driver),reviewText);
        Assert.assertEquals(myAccountPO.getFirstReviewInfoRating(driver),reviewRating);
        Assert.assertEquals(myAccountPO.getFirstReviewInfoProductItemName(driver),productItemName);


    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
