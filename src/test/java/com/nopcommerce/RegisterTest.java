package com.nopcommerce;

import commons.BaseTest;
import model.nopcommerce.RegisterPOJO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.nopcommerce.HomePO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.RegisterPO;


public class RegisterTest extends BaseTest {
    WebDriver driver;
    RegisterPO registerPO;
    HomePO homePO;
    RegisterPOJO registerPOJO;
    String email;
    String secondEmail;
    String password;

    @BeforeClass
    @Parameters({"browserName","url"})
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);

        homePO = PageGenerator.getHomePO(driver);
        registerPO = homePO.clickToRegisterNavButton(driver);

        email = "anle" + generateRandom() + "@gmail.com";
        secondEmail = "lean" + generateRandom() + "@gmail.com";
        password = "Automation@123";

        registerPOJO = new RegisterPOJO();
        registerPOJO.setFirstName("An" + generateRandom());
        registerPOJO.setLastName("Le");
        registerPOJO.setEmail(email);
        registerPOJO.setCompanyName("Alex");
        registerPOJO.setPassword(password);
        registerPOJO.setConfirmPassword(password);
    }

    @Test
    public void TC_01_Register_Empty_Data() {
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getFirstNameErrorMessage(driver),"First name is required.");
        Assert.assertEquals(registerPO.getLastNameErrorMessage(driver),"Last name is required.");
        Assert.assertEquals(registerPO.getEmailErrorMessage(driver),"Email is required.");
        Assert.assertEquals(registerPO.getConfirmPasswordErrorMessage(driver),"Password is required.");
    }

    @Test
    public void TC_02_Register_Invalid_Email() {
        registerPOJO.setEmail("anle@gmail");

        registerPO.inputRegisterForm(driver,registerPOJO);
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getEmailErrorMessage(driver),"Wrong email");
        registerPOJO.setEmail(email);
    }

    @Test
    public void TC_03_Register_Valid_Information() {
        registerPO.inputRegisterForm(driver, registerPOJO);
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getRegisterSuccessMessage(driver),"Your registration completed");
        homePO = registerPO.clickToLogoutNavButton(driver);
        registerPO = homePO.clickToRegisterNavButton(driver);
    }

    @Test
    public void TC_04_Register_Existed_Email() {

        registerPO.inputRegisterForm(driver,registerPOJO);
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getHeaderErrorMessage(driver),"The specified email already exists");
        registerPOJO.setEmail(secondEmail);
    }

    @Test
    public void TC_05_Register_Password_Length_Less_Than_6 () {
        registerPOJO.setPassword("Auto");

        registerPO.inputRegisterForm(driver,registerPOJO);
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getPasswordErrorMessage(driver),"Password must meet the following rules: must have at least 6 characters and not greater than 64 characters");
        registerPOJO.setPassword(password);
    }

    @Test
    public void TC_06_Register_Confirm_Password_Mismatch_Password() {
        registerPOJO.setConfirmPassword("Automation");

        registerPO.inputRegisterForm(driver,registerPOJO);
        registerPO.clickToRegisterButton(driver);

        Assert.assertEquals(registerPO.getConfirmPasswordErrorMessage(driver),"The password and confirmation password do not match.");
        registerPOJO.setConfirmPassword(password);
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
