package com.woocommerce.frontend;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void TC_01_ThereShouldBe12ProductsDisplayed() {}

    @Test
    public void TC_02_ThereShouldBe4ColumnsOfProducts() {}

    @Test
    public void TC_03_ThereShouldBe4RowsOfProducts() {}

    @Test
    public void TC_04_ShopHeadingShouldBeDisplayed() {}

    @Test
    public void TC_05_SortingDropdownShouldBeDisplayedOnTopOfPage() {}

    @Test
    public void TC_35_SortingDropdownShouldBeDisplayedOnBottomOfPage() {}

    @Test
    public void TC_36_TopNavBarShouldDisplay5Items() {}

    @Test
    public void TC_37_TopNavBarShouldHaveCorrectPagesDisplayed() {}

    @Test
    public void TC_38_TopNavBarEachMenuItemShouldOpenCorrectPage() {}


    @AfterClass
    public void afterClass() {

    }
}
