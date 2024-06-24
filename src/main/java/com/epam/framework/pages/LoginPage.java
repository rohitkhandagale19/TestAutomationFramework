package com.epam.framework.pages;

import com.epam.framework.utils.PropertyUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement usernameText;

    @FindBy(id = "password")
    private WebElement passwordText;

    @FindBy(id = "submit")
    private WebElement submitButton;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void loginToApplication() {
        waitHelper.waitForPageToLoad();
        usernameText.sendKeys(PropertyUtil.getProperty("username"));
        passwordText.sendKeys(PropertyUtil.getProperty("password"));
        submitButton.click();
        waitHelper.waitForPageToLoad();


    }
}
