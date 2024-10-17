package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.enums.BrowserRemoteMode;
import com.selenium.automation.enums.BrowserName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class RemoteDriverFactory {
    private static final Map<BrowserRemoteMode, Function<BrowserName, WebDriver>>
            MAP = new EnumMap<>(BrowserRemoteMode.class);

    public static WebDriver getDriver(BrowserRemoteMode browserRemoteMode, BrowserName browserName) {
        switch (browserRemoteMode) {
            case SELENIUMGRID -> MAP.computeIfAbsent(BrowserRemoteMode.SELENIUMGRID, k -> SeleniumGridFactory::getDriver);
            case SELENOID -> MAP.computeIfAbsent(BrowserRemoteMode.SELENOID, k -> SelenoidFactory::getDriver);
            default -> throw new IllegalArgumentException("Invalid Remote type - " + browserRemoteMode);
        }

        return MAP.get(browserRemoteMode).apply(browserName);
    }
}
