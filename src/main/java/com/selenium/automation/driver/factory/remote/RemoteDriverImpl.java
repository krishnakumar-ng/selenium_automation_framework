package com.selenium.automation.driver.factory.remote;

import com.selenium.automation.driver.abstraction.IDriver;
import com.selenium.automation.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public class RemoteDriverImpl implements IDriver {

    @Override
    public WebDriver getDriver(DriverData driverData) {
        return RemoteDriverFactory.getDriver(driverData.getBrowserRemoteMode(), driverData.getBrowserName());
    }
}
