package com.selenium.automation.util.screenshot;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
@UtilityClass
public class ScreenshotFactory {
    public void takeScreenshot(WebDriver driver) {
        Screenshot screenshot = new Screenshot();
        screenshot.takeScreenshot(driver);
    }
}
