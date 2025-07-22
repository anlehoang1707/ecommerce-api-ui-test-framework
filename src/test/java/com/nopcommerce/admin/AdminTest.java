package com.nopcommerce.admin;

import commons.BaseTest;
import commons.GlobalConstants;
import model.nopcommerce.admin.AddNewCustomerPOJO;
import model.nopcommerce.users.AddAddressPOJO;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.nopcommerce.admin.AdminCustomerPO;
import pageObjects.nopcommerce.admin.AdminDetailProductPO;
import pageObjects.nopcommerce.admin.AdminHomePO;
import pageObjects.nopcommerce.admin.AdminProductPO;
import pageObjects.nopcommerce.users.HomePO;
import pageObjects.nopcommerce.PageGenerator;

public class AdminTest extends BaseTest {
    HomePO homePO;
    AdminHomePO adminHomePO;
    AdminProductPO adminProductPO;
    AdminDetailProductPO adminDetailProductPO;
    AdminCustomerPO adminCustomerPO;
    AddNewCustomerPOJO addNewCustomerPOJO,editNewCustomerPOJO;
    AddAddressPOJO addAddressPOJO,editAddressPOJO;

    @Parameters({"browserName","url"})
    @BeforeClass
    public void beforeClass(String browserName,String url) {
        driver = getBrowserDriver(url,browserName);
        //login with Admin account
        homePO = PageGenerator.getHomePO(driver);
        homePO.loginUser(driver,homePO, GlobalConstants.NOPCOMMERCE_ADMIN_EMAIL,GlobalConstants.NOPCOMMERCE_VALID_LOGIN_PASSWORD);

        homePO.clickToAdminHeaderLink(driver);
        adminHomePO = PageGenerator.getAdminHomePO(driver);
    }

    @Test
    public void TC_01_Admin_Search_With_Product_Name() {
        adminHomePO.clickToSideMenuParentByText(driver,"Catalog");
        adminHomePO.clickToSideMenuChildByText(driver,"Products");
        adminProductPO = PageGenerator.getAdminProductPO(driver);

        adminProductPO.sendKeyToProductNameTextbox(driver,"Lenovo IdeaCentre");
        adminProductPO.clickToSearchButton(driver);
        Assert.assertEquals(adminProductPO.getDisplayedProductSearchResultCount(driver),1);

    }

    @Test
    public void TC_02_Admin_Search_With_Product_Name_Parent_Category_Unchecked() {
        adminProductPO.sendKeyToProductNameTextbox(driver,"Lenovo IdeaCentre");
        adminProductPO.selectItemInCategoryDropdownByText(driver,"Computers");
        adminProductPO.uncheckToSearchSubCategoriesCheckbox(driver);
        adminProductPO.clickToSearchButton(driver);

        Assert.assertEquals(adminProductPO.getSearchMessageInTable(driver),"No data available in table");

    }

    @Test
    public void TC_03_Admin_Search_With_Product_Name_Parent_Category_Checked() {
        adminProductPO.sendKeyToProductNameTextbox(driver,"Lenovo IdeaCentre");
        adminProductPO.selectItemInCategoryDropdownByText(driver,"Computers");
        adminProductPO.checkToSearchSubCategoriesCheckbox(driver);
        adminProductPO.clickToSearchButton(driver);

        Assert.assertEquals(adminProductPO.getDisplayedProductSearchResultCount(driver),1);

    }

    @Test
    public void TC_04_Admin_Search_With_Product_Name_Child_Category() {
        adminProductPO.sendKeyToProductNameTextbox(driver,"Lenovo IdeaCentre");
        adminProductPO.selectItemInCategoryDropdownByText(driver,"Computers >> Desktops");
        adminProductPO.uncheckToSearchSubCategoriesCheckbox(driver);
        adminProductPO.clickToSearchButton(driver);

        Assert.assertEquals(adminProductPO.getDisplayedProductSearchResultCount(driver),1);

    }

    @Test
    public void TC_05_Admin_Search_With_Product_Name_Manufacturer() {
        adminProductPO.sendKeyToProductNameTextbox(driver,"Lenovo IdeaCentre");
        adminProductPO.selectItemInCategoryDropdownByText(driver,"All");
        adminProductPO.uncheckToSearchSubCategoriesCheckbox(driver);
        adminProductPO.selectItemInManufacturerDropdownByText(driver,"Apple");
        adminProductPO.clickToSearchButton(driver);

        Assert.assertEquals(adminProductPO.getSearchMessageInTable(driver),"No data available in table");


    }

    @Test
    public void TC_06_Admin_Product_SKU() {
        adminProductPO.sendKeyToGoDirectLyProductSKU(driver,"LE_IC_600");
        adminProductPO.clickToGoSKUButton(driver);

        adminDetailProductPO = PageGenerator.getAdminDetailProductPO(driver);
        Assert.assertTrue(adminDetailProductPO.getTextInPageTitle(driver).contains("Edit product details"));
        Assert.assertEquals(adminDetailProductPO.getTextInProductNameTextbox(driver),"Lenovo IdeaCentre");

        adminDetailProductPO.clickBackToProductListLink(driver);

    }

    @Test
    public void TC_07_Admin_Create_New_Customer() {
        adminDetailProductPO.clickToSideMenuParentByText(driver,"Customers");
        adminDetailProductPO.clickToSideMenuChildByText(driver,"Customers");

        adminCustomerPO = PageGenerator.getAdminCustomerPO(driver);
        adminCustomerPO.clickToAddNewButton(driver);
        adminCustomerPO.inputAddNewCustomerInfo(driver,addNewCustomerPOJO);
        adminCustomerPO.clickToSaveAndContinueEditButton(driver);


        Assert.assertEquals(adminCustomerPO.getAlertMessage(driver),"The new customer has been added successfully.");
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoCreated(driver,addNewCustomerPOJO));

        adminCustomerPO.clickToBackToCustomerListLink(driver);
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,addNewCustomerPOJO));

    }

    @Test
    public void TC_08_Admin_Search_Customer_With_Email() {
        adminCustomerPO.sendKeysToEmailSearchTextbox(driver,addNewCustomerPOJO.getEmail());
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertEquals(adminCustomerPO.getDisplayedCustomerSearchResultCount(driver),1);
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,addNewCustomerPOJO));

    }

    @Test
    public void TC_09_Admin_Search_Customer_With_First_Name_Last_Name() {
        adminCustomerPO.sendKeysToFirstNameSearchTextbox(driver,addNewCustomerPOJO.getFirstName());
        adminCustomerPO.sendKeysToLastNameSearchTextbox(driver,addNewCustomerPOJO.getLastName());
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertEquals(adminCustomerPO.getDisplayedCustomerSearchResultCount(driver),1);
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,addNewCustomerPOJO));

    }

    @Test
    public void TC_10_Admin_Search_Customer_With_Company() {
        adminCustomerPO.sendKeysToCompanySearchTextbox(driver,addNewCustomerPOJO.getCompanyName());
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertEquals(adminCustomerPO.getDisplayedCustomerSearchResultCount(driver),1);
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,addNewCustomerPOJO));

    }

    @Test
    public void TC_11_Admin_Search_Customer_With_Full_Data() {
        adminCustomerPO.sendKeysToEmailSearchTextbox(driver,addNewCustomerPOJO.getEmail());
        adminCustomerPO.sendKeysToFirstNameSearchTextbox(driver,addNewCustomerPOJO.getFirstName());
        adminCustomerPO.sendKeysToLastNameSearchTextbox(driver,addNewCustomerPOJO.getLastName());
        adminCustomerPO.sendKeysToCompanySearchTextbox(driver,addNewCustomerPOJO.getCompanyName());
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertEquals(adminCustomerPO.getDisplayedCustomerSearchResultCount(driver),1);
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,addNewCustomerPOJO));

    }

    @Test
    public void TC_12_Admin_Edit_Customer() {
        adminCustomerPO.clickToEditButtonByIndex(driver,1);

        adminCustomerPO.inputAddNewCustomerInfo(driver,editNewCustomerPOJO);
        adminCustomerPO.clickToSaveButton(driver);

        Assert.assertEquals(adminCustomerPO.getAlertMessage(driver),"The customer has been updated successfully.");

        adminCustomerPO.sendKeysToEmailSearchTextbox(driver,editNewCustomerPOJO.getEmail());
        adminCustomerPO.sendKeysToFirstNameSearchTextbox(driver,editNewCustomerPOJO.getFirstName());
        adminCustomerPO.sendKeysToLastNameSearchTextbox(driver,editNewCustomerPOJO.getLastName());
        adminCustomerPO.sendKeysToCompanySearchTextbox(driver,editNewCustomerPOJO.getCompanyName());
        adminCustomerPO.sendKeysToCustomerRolesTextbox(driver,"Guests");
        adminCustomerPO.clickToSearchButton(driver);

        Assert.assertEquals(adminCustomerPO.getDisplayedCustomerSearchResultCount(driver),1);
        Assert.assertTrue(adminCustomerPO.isNewCustomerInfoDisplayedOnList(driver,editNewCustomerPOJO));

    }

    @Test
    public void TC_13_Admin_Add_New_Address() {
        adminCustomerPO.clickToEditButtonByIndex(driver,1);

        adminCustomerPO.clickToAddressSectionHeader(driver);
        adminCustomerPO.clickToAddNewAddressButton(driver);

        adminCustomerPO.inputAddressInfo(driver,addAddressPOJO);
        adminCustomerPO.clickToSaveAddressButton(driver);

        Assert.assertEquals(adminCustomerPO.getAlertMessage(driver),"The new address has been added successfully.");

        adminCustomerPO.clickToBackToCustomerDetailLink(driver);

        Assert.assertTrue(adminCustomerPO.isNewAddressInfoDisplayed(driver,addAddressPOJO));


    }

    @Test
    public void TC_14_Admin_Edit_Address() {
        adminCustomerPO.clickToEditAddressButtonByIndex(driver,1);
        adminCustomerPO.inputAddressInfo(driver,editAddressPOJO);
        adminCustomerPO.clickToSaveAddressButton(driver);

        Assert.assertEquals(adminCustomerPO.getAlertMessage(driver),"The address has been updated successfully.");

        adminCustomerPO.clickToBackToCustomerDetailLink(driver);

        Assert.assertTrue(adminCustomerPO.isNewAddressInfoDisplayed(driver,editAddressPOJO));


    }

    @Test
    public void TC_15_Admin_Delete_Address() {
        adminCustomerPO.clickToDeleteAddressButtonByIndex(driver,1);
        adminCustomerPO.acceptDeleteAddressAlert(driver);

        Assert.assertEquals(adminCustomerPO.getSearchMessageInAddressTable(driver),"No data available in table");


    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
