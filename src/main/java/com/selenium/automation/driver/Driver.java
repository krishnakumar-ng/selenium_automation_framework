package com.selenium.automation.driver;

import com.selenium.automation.driver.entity.DriverData;
import com.selenium.automation.driver.factory.DriverFactory;
import com.selenium.automation.driver.manager.DriverManager;
import com.selenium.automation.enums.BrowserType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

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

    public static void initDriver(BrowserType browser) {
        DriverData driverData = DriverData.builder()
                .browserType(browser)
                .browserRemoteModeType(CONFIG_PROPERTIES.remote_mode())
                .build();

        if (Objects.isNull(DriverManager.getDriver())) {
            DriverManager.setDriver(DriverFactory
                    .getDriver(CONFIG_PROPERTIES.run_mode())
                    .getDriver(driverData));
        }
        DriverManager.getDriver().get(CONFIG_PROPERTIES.url());
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
