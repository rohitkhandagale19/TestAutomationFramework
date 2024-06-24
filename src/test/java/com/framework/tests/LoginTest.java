package com.framework.tests;

import com.epam.framework.pages.AccountPage;
import com.epam.framework.pages.LoginPage;
import com.epam.framework.utils.PropertyUtil;
import com.epam.framework.utils.WaitHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        driver.get(PropertyUtil.getProperty("url"));
        LoginPage loginPage = new LoginPage(driver);
        AccountPage accountPage = new AccountPage(driver);

        loginPage.loginToApplication();
        Assert.assertEquals(accountPage.titleText(), "Logged In Successfully");

    }
}
