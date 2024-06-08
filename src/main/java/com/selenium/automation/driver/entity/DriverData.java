package com.selenium.automation.driver.entity;

import com.selenium.automation.enums.BrowserRemoteModeType;
import com.selenium.automation.enums.BrowserType;
import lombok.Builder;
import lombok.Getter;

/**
 * Builder pattern helps in creating immutable classes with a large set of state attributes
 *
 */
@Builder
@Getter
public class DriverData {
    private BrowserType browserType;
    private BrowserRemoteModeType browserRemoteModeType;
}
