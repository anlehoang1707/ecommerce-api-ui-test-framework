package com.nopcommerce.users;

import commons.BaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.users.HomePO;
import pageObjects.nopcommerce.PageGenerator;
import pageObjects.nopcommerce.users.ProductPO;


public class SortDisplayPagingTest extends BaseTest {
    ProductPO productPO;
    HomePO homePO;


    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);

        homePO = PageGenerator.getHomePO(driver);
        homePO.loginUser(driver,homePO,"an.lehoang1707@gmail.com","Automation@123");
        homePO.clickToHeaderMenuByText(driver,"Computers");
        productPO = PageGenerator.getProductPO(driver);
        productPO.clickToSubCategoryItemByText(driver,"Notebooks");

    }

    @Test
    public void TC_01_Sort_A_To_Z() {
        productPO.selectSortOptionByText(driver,"Name: A to Z");

        Assert.assertTrue(productPO.isProductNameDataSortedAsc(driver));

    }

    @Test
    public void TC_02_Sort_Z_To_A() {
        productPO.selectSortOptionByText(driver,"Name: Z to A");

        Assert.assertTrue(productPO.isProductNameDataSortedDsc(driver));

    }

    @Test
    public void TC_03_Sort_Price_Low_To_High() {
        productPO.selectSortOptionByText(driver,"Price: Low to High");

        Assert.assertTrue(productPO.isProductPriceDataSortedAsc(driver));

    }

    @Test
    public void TC_04_Sort_Price_High_To_Low() {
        productPO.selectSortOptionByText(driver,"Price: High to Low");

        Assert.assertTrue(productPO.isProductPriceDataSortedDsc(driver));

    }

    @Test
    public void TC_05_Display_With_3_Products_Per_Page() {
        productPO.selectPagingOptionByText(driver,"3");

        Assert.assertTrue(productPO.isProductListDisplayedLessOrEqual(driver,3));

        Assert.assertTrue(productPO.isNextPageIconDisplayed());

        productPO.clickToNextPageIcon(driver);

        Assert.assertTrue(productPO.isPreviousPageIconDisplayed());

    }

    @Test
    public void TC_06_Display_With_6_Products_Per_Page() {
        productPO.selectPagingOptionByText(driver,"6");

        Assert.assertTrue(productPO.isProductListDisplayedLessOrEqual(driver,6));

    }

    @Test
    public void TC_07_Display_With_9_Products_Per_Page() {
        productPO.selectPagingOptionByText(driver,"9");

        Assert.assertTrue(productPO.isProductListDisplayedLessOrEqual(driver,9));

    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

}

