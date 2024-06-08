package com.selenium.automation.driver.factory.remote;

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

    static {
        MAP.put(BrowserRemoteModeType.SELENIUMGRID, SeleniumGridFactory::getDriver);
    }

    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteMode, BrowserType browserType) {
        return MAP.get(browserRemoteMode).apply(browserType);
    }
}