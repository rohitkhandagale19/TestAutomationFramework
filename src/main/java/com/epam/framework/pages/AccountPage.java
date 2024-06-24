package com.epam.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//h1[@class='post-title']")
    private WebElement titleText;

    @FindBy(xpath = "//a[contains(@href, 'contact')]")
    private WebElement contactLink;

    @FindBy(xpath = "//input[@id='wpforms-161-field_0']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='wpforms-161-field_0-last']")
    private WebElement lastName;

    @FindBy(xpath = " //input[@id='wpforms-161-field_1']")
    private WebElement emailAddress;


    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String titleText() {

        return titleText.getText();
    }

    public void goToContact() {
        contactLink.click();
        waitHelper.waitForPageToLoad();

    }

    public void enterContactDetails(String firstName, String lastName, String emailAddress) {

        scrollHelper.scrollToElement(this.emailAddress);
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.emailAddress.sendKeys(emailAddress);
        waitHelper.waitForSeconds(2);


    }


}
