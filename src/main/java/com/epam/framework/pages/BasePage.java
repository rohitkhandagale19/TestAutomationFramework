package com.epam.framework.pages;

import com.epam.framework.utils.ScrollHelper;
import com.epam.framework.utils.WaitHelper;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected WaitHelper waitHelper;
    protected ScrollHelper scrollHelper;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitHelper = new WaitHelper(driver);
        this.scrollHelper = new ScrollHelper(driver);
    }
}
