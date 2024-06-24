package com.epam.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // Default timeout
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = driver -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState").equals("complete");
        wait.until(pageLoadCondition);
    }

    public void waitForElementToBeVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted while waiting.", e);
        }
    }
}
