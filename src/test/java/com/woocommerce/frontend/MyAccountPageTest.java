package com.woocommerce.frontend;

import commons.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MyAccountPageTest extends BaseTest {
    @BeforeClass
    public void beforeClass() {

    }

    @Test
    public void TC_06_MyAccountPageShouldHaveLoginForm() {}

    @Test
    public void TC_07_MyAccountPageShouldHaveRegistrationForm() {}

    @Test
    public void TC_08_LoginUsernameFieldLabelShouldBeCorrect() {}

    @Test
    public void TC_09_LoginPasswordFieldLabelShouldBeCorrect() {}

    @Test
    public void TC_10_ExistingUserShouldBeAbleToLogin() {}

    @Test
    public void TC_11_UserWithWrongPasswordShouldGetCorrectErrorMessage() {}

    @Test
    public void TC_12_UserWithNonExistingEmailShouldGetCorrectErrorMessage() {}

    @Test
    public void TC_13_NewUserShouldBeAbleToCreateAccount() {}

    @Test
    public void TC_14_UserShouldGetAutomaticallyLoggedInWhenRegistering() {}

    @Test
    public void TC_15_RegisterUserNameFieldLabelShouldBeCorrect() {}

    @Test
    public void TC_16_WhenUserLogsInDashboardShouldBeActive() {}

    @Test
    public void TC_17_LeftNavBarShouldHave6Elements() {}

    @Test
    public void TC_18_LeftNavBarShouldHaveUnnamedElement1Displayed() {}

    @Test
    public void TC_19_LeftNavBarShouldHaveUnnamedElement2Displayed() {}

    @Test
    public void TC_20_LeftNavUnnamedClickShouldOpenTargetPage1() {}

    @Test
    public void TC_21_LeftNavUnnamedClickShouldOpenTargetPage2() {}

    @Test
    public void TC_22_LeftNavUnnamedClickShouldOpenTargetPage3() {}

    @Test
    public void TC_23_LeftNavUnnamedClickShouldOpenTargetPage4() {}


    @AfterClass
    public void afterClass() {

    }
}
