package com.nopcommerce;

import commons.BaseTest;
import model.nopcommerce.RegisterPOJO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.HomePO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.RegisterPO;
import pageObjects.nopcommerce.SearchPO;

public class SearchTest extends BaseTest {
    RegisterPOJO registerPOJO;
    RegisterPOJO newUserPOJO;
    HomePO homePO;
    SearchPO searchPO;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName, String url) {
        driver = getBrowserDriver(url, browserName);

        registerPOJO = new RegisterPOJO();
        homePO = PageGenerator.getHomePO(driver);
        newUserPOJO = registerUser(driver,homePO,registerPOJO);
        homePO.loginUser(driver,homePO, newUserPOJO.getEmail(),newUserPOJO.getPassword());
        homePO.clickToNavLinkFooterByText(driver,"Search");
        searchPO = PageGenerator.getSearchPO(driver);
    }

    @Test
    public void TC_01_Search_Empty_Data() {
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getSearchErrorMessageText(driver),"Search term minimum length is 3 characters");
    }

    @Test
    public void TC_02_Search_Data_Not_Existed() {
        searchPO.inputToSearchKeywordTextbox(driver,"Macbook Pro 2050");
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getSearchErrorMessageText(driver),"No products were found that matched your criteria.");


    }

    @Test
    public void TC_03_Search_Product_Name_Relative() {
        searchPO.inputToSearchKeywordTextbox(driver,"Lenovo");
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getListProductSize(driver),2);
        Assert.assertTrue(searchPO.getProductNameByIndex(driver,1).contains("Lenovo"));
        Assert.assertTrue(searchPO.getProductNameByIndex(driver,2).contains("Lenovo"));

    }

    @Test
    public void TC_04_Search_Product_Name_Absolute() {
        searchPO.inputToSearchKeywordTextbox(driver,"ThinkPad Carbon");
        searchPO.clickToSearchButton(driver);
        Assert.assertEquals(searchPO.getListProductSize(driver),1);
        Assert.assertTrue(searchPO.getProductNameByIndex(driver,1).toLowerCase().contains("thinkpad carbon"));

    }

    @Test
    public void TC_05_Search_Advanced_With_Parent_Categories() {
        searchPO.inputToSearchKeywordTextbox(driver,"ThinkPad Carbon");
        searchPO.checkToAdvancedSearchCheckbox(driver);
        searchPO.selectItemInCategoryDropdown(driver,"Computers");
        searchPO.uncheckToAutomaticallySearchSubCategories(driver);
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getSearchErrorMessageText(driver),"No products were found that matched your criteria.");

    }

    @Test
    public void TC_06_Search_Advanced_With_Sub_Categories() {
        searchPO.inputToSearchKeywordTextbox(driver,"ThinkPad Carbon");
        searchPO.checkToAdvancedSearchCheckbox(driver);
        searchPO.selectItemInCategoryDropdown(driver,"Computers");
        searchPO.checkToAutomaticallySearchSubCategories(driver);
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getListProductSize(driver),1);
        Assert.assertTrue(searchPO.getProductNameByIndex(driver,1).toLowerCase().contains("thinkpad carbon"));
    }

    @Test
    public void TC_07_Search_Advanced_Incorrect_Manufacturer() {
        searchPO.inputToSearchKeywordTextbox(driver,"Macbook");
        searchPO.checkToAdvancedSearchCheckbox(driver);
        searchPO.selectItemInCategoryDropdown(driver,"Computers");
        searchPO.checkToAutomaticallySearchSubCategories(driver);
        searchPO.selectItemInManufacturerDropdown(driver,"HP");
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getSearchErrorMessageText(driver),"No products were found that matched your criteria.");

    }

    @Test
    public void TC_08_Search_Advanced_Correct_Manufacturer() {
        searchPO.inputToSearchKeywordTextbox(driver,"Macbook");
        searchPO.checkToAdvancedSearchCheckbox(driver);
        searchPO.selectItemInCategoryDropdown(driver,"Computers");
        searchPO.checkToAutomaticallySearchSubCategories(driver);
        searchPO.selectItemInManufacturerDropdown(driver,"Apple");
        searchPO.clickToSearchButton(driver);

        Assert.assertEquals(searchPO.getListProductSize(driver),1);

        Assert.assertTrue(searchPO.getProductNameByIndex(driver,1).toLowerCase().contains("macbook"));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }
}
