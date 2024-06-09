package com.selenium.automation.hooks;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

@Slf4j
public class CucumberHooks {
    @BeforeAll
    public static void setup() {
        String testEnv = CONFIG_PROPERTIES.testEnv().toString();
        log.debug("Setting up the test execution with properties: {}.properties", testEnv);
    }

    @Before
    public static void beforeHook(Scenario scenario) {
        log.info("*******************************************");
        log.info("Scenario :\t{}", scenario.getName());
        log.info("*******************************************");
        log.info(String.valueOf(Thread.currentThread()));
    }
}
