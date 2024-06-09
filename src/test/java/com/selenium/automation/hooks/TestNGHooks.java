package com.selenium.automation.hooks;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeSuite;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

@Slf4j
public class TestNGHooks {
    @BeforeSuite
    public static void setup(){
        String testEnv = CONFIG_PROPERTIES.testEnv().toString();
        log.debug("Setting up the test execution with properties: {}.properties",testEnv);
    }
}
