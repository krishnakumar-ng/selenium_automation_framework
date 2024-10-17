package com.selenium.automation.driver.entity;

import com.selenium.automation.enums.BrowserRemoteMode;
import com.selenium.automation.enums.BrowserName;
import lombok.Builder;
import lombok.Getter;

/**
 * Builder pattern helps in creating immutable classes with a large set of state attributes
 *
 */
@Builder
@Getter
public class DriverData {
    private BrowserName browserName;
    private BrowserRemoteMode browserRemoteMode;
}
