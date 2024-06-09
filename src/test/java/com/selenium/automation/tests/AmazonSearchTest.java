package com.selenium.automation.tests;

import com.selenium.automation.driver.Driver;
import com.selenium.automation.enums.BrowserType;
import org.testng.annotations.Test;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

public class AmazonSearchTest {

    @Test
    public void searchLaptopTest() throws InterruptedException {
        System.out.println(CONFIG_PROPERTIES.url());
        System.out.println(CONFIG_PROPERTIES.testEnv());
        System.out.println(CONFIG_PROPERTIES.run_mode());
        System.out.println(CONFIG_PROPERTIES.remote_mode());
        System.out.println(CONFIG_PROPERTIES.seleniumGridUrl());
        System.out.println(CONFIG_PROPERTIES.selenoidUrl());

//        Driver.initDriver(BrowserType.valueOf("CHROME"));
//        Thread.sleep(10000);
//        Driver.quitDriver();
    }
}
