package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.driver.manager.local.ChromeManager;
import com.selenium.automation.driver.manager.local.EdgeManager;
import com.selenium.automation.driver.manager.local.FirefoxManager;
import com.selenium.automation.enums.BrowserRemoteModeType;
import com.selenium.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RemoteDriverFactory {
    private static final Map<BrowserRemoteModeType, Function<BrowserType, WebDriver>>
            MAP = new EnumMap<>(BrowserRemoteModeType.class);

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteMode, BrowserType browserType) {
        switch (browserRemoteMode) {
            case SELENIUMGRID -> MAP.computeIfAbsent(BrowserRemoteModeType.SELENIUMGRID, k -> SeleniumGridFactory::getDriver);
            case SELENOID -> MAP.computeIfAbsent(BrowserRemoteModeType.SELENOID, k -> SelenoidFactory::getDriver);
            default -> throw new IllegalArgumentException("Invalid Remote type - " + browserRemoteMode);
        }

        return MAP.get(browserRemoteMode).apply(browserType);
    }
}
