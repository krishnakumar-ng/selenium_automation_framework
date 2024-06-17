package com.selenium.automation.driver.factory.local;

import com.selenium.automation.driver.manager.local.ChromeManager;
import com.selenium.automation.driver.manager.local.EdgeManager;
import com.selenium.automation.driver.manager.local.FirefoxManager;
import com.selenium.automation.enums.BrowserType;
import com.selenium.automation.enums.RunType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class LocalDriverFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> BROWSER_MAP = new EnumMap<>(BrowserType.class);

    public static WebDriver getDriver(BrowserType browserType) {
        switch (browserType) {
            case CHROME -> BROWSER_MAP.computeIfAbsent(BrowserType.CHROME, k -> ChromeManager::getDriver);
            case FIREFOX -> BROWSER_MAP.computeIfAbsent(BrowserType.FIREFOX, k -> FirefoxManager::getDriver);
            case EDGE -> BROWSER_MAP.computeIfAbsent(BrowserType.EDGE, k -> EdgeManager::getDriver);
            default -> throw new IllegalArgumentException("Invalid Browser type - " + browserType);
        }

        return BROWSER_MAP.get(browserType).get();
    }
}
