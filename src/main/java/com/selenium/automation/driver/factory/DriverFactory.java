package com.selenium.automation.driver.factory;

import com.selenium.automation.driver.abstraction.IDriver;
import com.selenium.automation.driver.factory.local.LocalDriverImpl;
import com.selenium.automation.driver.factory.remote.RemoteDriverImpl;
import com.selenium.automation.enums.RunMode;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    private static final Map<RunMode, Supplier<IDriver>> WEBDRIVER = new EnumMap<>(RunMode.class);

    public static IDriver getDriver(RunMode runMode) {
        switch (runMode) {
            case RunMode.LOCAL -> WEBDRIVER.computeIfAbsent(RunMode.LOCAL, k -> LocalDriverImpl::new);
            case RunMode.REMOTE -> WEBDRIVER.computeIfAbsent(RunMode.REMOTE, k -> RemoteDriverImpl::new);
            default -> throw new IllegalArgumentException("Invalid Run type - " + runMode);
        }
        return WEBDRIVER.get(runMode).get();
    }
}