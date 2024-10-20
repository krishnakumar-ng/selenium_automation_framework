package com.selenium.automation.driver;

import com.selenium.automation.driver.entity.DriverData;
import com.selenium.automation.driver.factory.DriverFactory;
import com.selenium.automation.driver.manager.DriverManager;
import com.selenium.automation.enums.BrowserName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.util.Objects;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;

/**
 * Driver class is responsible for invoking and closing the browsers.
 * <p>
 * It is also responsible for setting the driver variable to DriverManager which handles the thread safety for the webdriver instance.
 *
 * @author Administrator
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Driver {
    public static void initDriver(BrowserName browser) {
        DriverData driverData = DriverData.builder()
                .browserName(browser)
                .browserRemoteMode(CONFIG_PROPERTIES.browserRemoteMode())
                .build();

        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory
                    .getDriver(CONFIG_PROPERTIES.runMode())
                    .getDriver(driverData));
        }
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
