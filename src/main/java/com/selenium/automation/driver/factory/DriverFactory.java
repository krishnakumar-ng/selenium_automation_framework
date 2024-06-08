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

    private static final Map<RunType, Supplier<IDriver>> WEB = new EnumMap<>(RunType.class);

    static {
        WEB.put(RunType.LOCAL, LocalDriverImpl::new);
        WEB.put(RunType.REMOTE, RemoteDriverImpl::new);
    }

    public static IDriver getDriver(RunType runType) {
        return WEB.get(runType).get();
    }
}