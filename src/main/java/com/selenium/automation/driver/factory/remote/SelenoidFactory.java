package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.driver.manager.remote.selenoid.SelenoidChromeManager;
import com.selenium.automation.driver.manager.remote.selenoid.SelenoidEdgeManager;
import com.selenium.automation.driver.manager.remote.selenoid.SelenoidFireFoxManager;
import com.selenium.automation.enums.BrowserType;
import org.openqa.selenium.WebDriver;

public class SelenoidFactory {
    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> {
                return SelenoidChromeManager.getDriver();
            }
            case FIREFOX -> {
                return SelenoidFireFoxManager.getDriver();
            }
            case EDGE -> {
                return SelenoidEdgeManager.getDriver();
            }
            default -> throw new IllegalArgumentException("Invalid Browser type - " + browserType);
        }
    }
}
