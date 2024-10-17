package com.selenium.automation.config.converter;

import com.selenium.automation.enums.RunMode;
import org.aeonbits.owner.Converter;
import java.lang.reflect.Method;
import java.util.Map;

public class RunModeConverter implements Converter<RunMode> {

    @Override
    public RunMode convert(Method method, String runType) {
        Map<String, RunMode> stringRunTypeMap = Map.
                of("LOCAL", RunMode.LOCAL,
                        "REMOTE", RunMode.REMOTE);

        return stringRunTypeMap.getOrDefault(runType.toUpperCase(), RunMode.LOCAL);
    }
}
