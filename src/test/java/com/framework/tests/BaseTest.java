package com.framework.tests;

import com.epam.framework.utils.Browser;
import com.epam.framework.utils.BrowserUtility;
import com.epam.framework.utils.PropertyUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = BrowserUtility.getDriver(Browser.CHROME);
        String url = PropertyUtil.getProperty("url");
        driver.manage().window().maximize();
        driver.get(url);

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
