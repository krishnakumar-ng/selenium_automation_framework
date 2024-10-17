package com.selenium.automation.driver.factory.local;

import com.selenium.automation.driver.abstraction.IDriver;
import com.selenium.automation.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public class LocalDriverImpl implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return LocalDriverFactory.getDriver(driverData.getBrowserName());
    }
}
