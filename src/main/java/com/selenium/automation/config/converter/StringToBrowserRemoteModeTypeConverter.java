package com.selenium.automation.config.converter;

import com.selenium.automation.enums.BrowserRemoteModeType;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserRemoteModeTypeConverter implements Converter<BrowserRemoteModeType> {

    @Override
    public BrowserRemoteModeType convert(Method method, String browserRemoteModeType) {
        Map<String, BrowserRemoteModeType> stringBrowserRemoteModeTypeMap = Map.
                of("SELENIUMGRID", BrowserRemoteModeType.SELENIUMGRID);

        return stringBrowserRemoteModeTypeMap.getOrDefault(browserRemoteModeType.toUpperCase(),
                BrowserRemoteModeType.SELENIUMGRID);
    }
}
