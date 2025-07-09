package com.nopcommerce;

import commons.BaseTest;
import commons.GlobalConstants;
import model.nopcommerce.RegisterPOJO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.MyAccountPO;
import pageObjects.nopcommerce.HomePO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.RegisterPO;

public class MyAccountTest extends BaseTest {
    HomePO homePO;
    RegisterPOJO registerPOJO;
    RegisterPOJO newUserPOJO;
    MyAccountPO myAccountPO;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);

        registerPOJO = new RegisterPOJO();
        homePO = PageGenerator.getHomePO(driver);
        newUserPOJO = registerUser(driver,homePO,registerPOJO);
        homePO = loginUser(driver,homePO,newUserPOJO);

        myAccountPO = homePO.clickToMyAccountNavButton(driver);
    }

    @Test
    public void TC_01_MyAccount_Update_Customer_Info() {
//        myAccountPO.inputUpdateInformationForm(pojo);
//
//        Assert.assertEquals(myAccountPO.getUpdateMessageText(driver),"The customer info has been updated successfully.");


    }

    @Test
    public void TC_02_MyAccount_Add_New_Address_Info() {

    }

    @Test
    public void TC_03_MyAccount_Change_Password() {

    }

    @Test
    public void TC_04_MyAccount_Verify_Product_Review() {

    }

    @AfterClass
    public void afterClass() {

    }
}
