package com.nopcommerce;

import commons.BaseTest;
import model.nopcommerce.LoginPOJO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePO;
import pageObjects.nopcommerce.LoginPO;
import pageObjects.nopcommerce.PageGenerator;

public class LoginTest extends BaseTest {
    HomePO homePO;
    LoginPO loginPO;
    LoginPOJO loginPOJO;

    @BeforeClass
    @Parameters({"browserName","url"})
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);

        homePO = PageGenerator.getHomePO(driver);
        loginPO = homePO.clickToLoginNavLink(driver);

        loginPOJO = new LoginPOJO();

    }

    @Test
    public void TC_01_Login_Empty_Data() {
        loginPO.clickToLoginButton(driver);

        Assert.assertEquals(loginPO.getEmailErrorMessage(driver),"Please enter your email");

    }

    @Test
    public void TC_02_Login_Invalid_Email() {

        loginPO.sendKeysToEmailTextbox(driver,"an.lehoang1707");

        Assert.assertEquals(loginPO.getEmailErrorMessage(driver),"Please enter a valid email address.");

    }

    @Test
    public void TC_03_Login_Unregistered_Email() {
        loginPO.sendKeysToEmailTextbox(driver,"abc@gmail.com");
        loginPO.clickToLoginButton(driver);

        Assert.assertEquals(loginPO.getValidationSummaryMessage(driver),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(loginPO.getValidationDetailMessage(driver),"No customer account found");

    }

    @Test
    public void TC_04_Login_Registered_Email_And_Empty_Password() {
        loginPOJO.setEmail("an.lehoang1707@gmail.com");
        loginPOJO.setPassword("");


        loginPO.sendKeysToEmailTextbox(driver,loginPOJO.getEmail());
        loginPO.sendKeysToPasswordTextbox(driver,loginPOJO.getPassword());
        loginPO.clickToLoginButton(driver);

        Assert.assertEquals(loginPO.getValidationSummaryMessage(driver),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(loginPO.getValidationDetailMessage(driver),"The credentials provided are incorrect");

    }

    @Test
    public void TC_05_Login_Registered_Email_And_Wrong_Password() {
        loginPOJO.setEmail("an.lehoang1707@gmail.com");
        loginPOJO.setPassword("Auto");

        loginPO.sendKeysToEmailTextbox(driver,loginPOJO.getEmail());
        loginPO.sendKeysToPasswordTextbox(driver,loginPOJO.getPassword());
        loginPO.clickToLoginButton(driver);

        Assert.assertEquals(loginPO.getValidationSummaryMessage(driver),"Login was unsuccessful. Please correct the errors and try again.");
        Assert.assertEquals(loginPO.getValidationDetailMessage(driver),"The credentials provided are incorrect");

    }

    @Test
    public void TC_06_Login_Correct_Email_And_Password() {
        loginPOJO.setEmail("an.lehoang1707@gmail.com");
        loginPOJO.setPassword("Automation@123");

        loginPO.sendKeysToEmailTextbox(driver,loginPOJO.getEmail());
        loginPO.sendKeysToPasswordTextbox(driver,loginPOJO.getPassword());
        loginPO.clickToLoginButton(driver);

        homePO = PageGenerator.getHomePO(driver);
        Assert.assertTrue(homePO.isMyAccountNavButtonDislayed(driver));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
