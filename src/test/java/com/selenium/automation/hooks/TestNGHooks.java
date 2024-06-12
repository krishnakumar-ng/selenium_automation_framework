package com.selenium.automation.hooks;

import com.selenium.automation.driver.Driver;
import io.cucumber.java.Scenario;
import lombok.extern.slf4j.Slf4j;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

@Slf4j
public class TestNGHooks {
    @BeforeSuite
    public static void setup() {
        String testEnv = CONFIG_PROPERTIES.testEnv().toString();
        log.debug("Setting up the test execution with properties: {}.properties", testEnv);
    }

    @BeforeTest
    public void setUp(ITestContext testContext) {
        log.info("============================ Scenario: {} - started ============================", testContext.getName());
    }

    @AfterTest
    public static void closeBrowser() {
        Driver.quitDriver();
    }
}
