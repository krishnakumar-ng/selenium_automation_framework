package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.driver.manager.remote.seleniumgrid.SeleniumGridChromeManager;
import com.selenium.automation.driver.manager.remote.seleniumgrid.SeleniumGridEdgeManager;
import com.selenium.automation.driver.manager.remote.seleniumgrid.SeleniumGridFirefoxManager;
import com.selenium.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SeleniumGridFactory {

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> {
                return SeleniumGridChromeManager.getDriver();
            }
            case FIREFOX -> {
                return SeleniumGridFirefoxManager.getDriver();
            }
            case EDGE -> {
                return SeleniumGridEdgeManager.getDriver();
            }
            default -> throw new IllegalArgumentException("Invalid Browser type - " + browserType);
        }
    }

}
