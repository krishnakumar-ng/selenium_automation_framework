package com.selenium.automation.tests;

import com.selenium.automation.driver.Driver;
import com.selenium.automation.enums.BrowserType;
import org.testng.annotations.Test;

public class AmazonSearchTest {

    @Test
    public void searchLaptopTest() throws InterruptedException {
        Driver.initDriver(BrowserType.valueOf("CHROME"));
        Thread.sleep(10000);
        Driver.quitDriver();
    }
}
