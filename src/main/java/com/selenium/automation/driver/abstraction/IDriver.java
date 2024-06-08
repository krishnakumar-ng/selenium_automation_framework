package com.selenium.automation.driver.abstraction;

import com.selenium.automation.driver.entity.DriverData;
import org.openqa.selenium.WebDriver;

public interface IDriver {

    WebDriver getDriver(DriverData driverData);
}
