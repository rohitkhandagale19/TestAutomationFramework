package com.epam.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {

    public static WebDriver getDriver(Browser browser) {
        WebDriver driver = null;
        switch (browser) {
            case CHROME:

                driver = new ChromeDriver();
                break;
            case FIREFOX:

                driver = new FirefoxDriver();
                break;
            case EDGE:

                driver = new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException();
        }
        return driver;
    }


}
