package com.epam.framework.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollHelper {

    private WebDriver driver;

    public ScrollHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Scrolls the page until the specified element is visible.
     *
     * @param element The WebElement to scroll to.
     */
    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Scrolls the page by a specified number of pixels.
     *
     * @param xPixels The number of pixels to scroll horizontally.
     * @param yPixels The number of pixels to scroll vertically.
     */
    public void scrollBy(int xPixels, int yPixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", xPixels, yPixels);
    }

    /**
     * Scrolls to the bottom of the page.
     */
    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }
}

