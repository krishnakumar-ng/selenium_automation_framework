package com.selenium.automation.driver.factory;

import com.selenium.automation.driver.abstraction.IDriver;
import com.selenium.automation.driver.factory.local.LocalDriverImpl;
import com.selenium.automation.driver.factory.remote.RemoteDriverImpl;
import com.selenium.automation.enums.RunType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DriverFactory {

    private static final Map<RunType, Supplier<IDriver>> WEBDRIVER = new EnumMap<>(RunType.class);

    public static IDriver getDriver(RunType runType) {
        switch (runType) {
            case RunType.LOCAL -> WEBDRIVER.computeIfAbsent(RunType.LOCAL, k -> LocalDriverImpl::new);
            case RunType.REMOTE -> WEBDRIVER.computeIfAbsent(RunType.REMOTE, k -> RemoteDriverImpl::new);
            default -> throw new IllegalArgumentException("Invalid Run type - " + runType);
        }
        return WEBDRIVER.get(runType).get();
    }
}