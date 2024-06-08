package com.selenium.automation.driver.manager.remote.seleniumgrid;

import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

public class SeleniumGridChromeManager {

    private SeleniumGridChromeManager() {}

    @SneakyThrows
    public static WebDriver getDriver() {
        return new RemoteWebDriver(CONFIG_PROPERTIES.seleniumGridUrl(), new ChromeOptions());
    }
}
