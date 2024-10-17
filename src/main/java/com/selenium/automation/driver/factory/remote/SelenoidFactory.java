package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.driver.manager.remote.selenoid.SelenoidChromeManager;
import com.selenium.automation.driver.manager.remote.selenoid.SelenoidEdgeManager;
import com.selenium.automation.driver.manager.remote.selenoid.SelenoidFireFoxManager;
import com.selenium.automation.enums.BrowserName;
import org.openqa.selenium.WebDriver;

public class SelenoidFactory {
    public static WebDriver getDriver(BrowserName browserName) {
        switch (browserName) {
            case CHROME -> {
                return SelenoidChromeManager.getDriver();
            }
            case FIREFOX -> {
                return SelenoidFireFoxManager.getDriver();
            }
            case EDGE -> {
                return SelenoidEdgeManager.getDriver();
            }
            default -> throw new IllegalArgumentException("Invalid Browser type - " + browserName);
        }
    }
}
