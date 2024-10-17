package com.selenium.automation.config.converter;

import com.selenium.automation.enums.BrowserRemoteMode;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class BrowserRemoteModeConverter implements Converter<BrowserRemoteMode> {

    @Override
    public BrowserRemoteMode convert(Method method, String browserRemoteModeType) {
        Map<String, BrowserRemoteMode> stringBrowserRemoteModeTypeMap = Map.
                of("SELENIUMGRID", BrowserRemoteMode.SELENIUMGRID);

        return stringBrowserRemoteModeTypeMap.getOrDefault(browserRemoteModeType.toUpperCase(),
                BrowserRemoteMode.SELENIUMGRID);
    }
}
