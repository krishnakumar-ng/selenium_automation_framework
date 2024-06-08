package com.selenium.automation.driver.manager.remote.seleniumgrid;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SeleniumGridFirefoxManager {

    @SneakyThrows
    public static WebDriver getDriver() {
        return new RemoteWebDriver(CONFIG_PROPERTIES.seleniumGridUrl(), new FirefoxOptions());
    }
}
