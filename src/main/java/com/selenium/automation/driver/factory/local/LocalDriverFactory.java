package com.selenium.automation.driver.factory.local;

import com.selenium.automation.driver.manager.local.ChromeManager;
import com.selenium.automation.driver.manager.local.EdgeManager;
import com.selenium.automation.driver.manager.local.FirefoxManager;
import com.selenium.automation.enums.BrowserName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDriverFactory {

    private static final Map<BrowserName, Supplier<WebDriver>> BROWSER_MAP = new EnumMap<>(BrowserName.class);

    public static WebDriver getDriver(BrowserName browserName) {
        switch (browserName) {
            case CHROME -> BROWSER_MAP.computeIfAbsent(BrowserName.CHROME, k -> ChromeManager::getDriver);
            case FIREFOX -> BROWSER_MAP.computeIfAbsent(BrowserName.FIREFOX, k -> FirefoxManager::getDriver);
            case EDGE -> BROWSER_MAP.computeIfAbsent(BrowserName.EDGE, k -> EdgeManager::getDriver);
            default -> throw new IllegalArgumentException("Invalid Browser type - " + browserName);
        }

        return BROWSER_MAP.get(browserName).get();
    }
}
