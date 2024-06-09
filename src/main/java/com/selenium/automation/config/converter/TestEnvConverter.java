package com.selenium.automation.config.converter;

import com.selenium.automation.enums.TestEnv;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;

public class TestEnvConverter implements Converter<TestEnv> {
    @Override
    public TestEnv convert(Method method, String input) {
        return TestEnv.valueOf(input.toUpperCase());
    }
}
