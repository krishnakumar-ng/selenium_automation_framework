package com.selenium.automation.util.screenshot;

import com.selenium.automation.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.selenium.automation.constants.PathConstants.SCREENSHOTS_DIR;

@Slf4j
public class Screenshot implements IScreenshot {
    @Override
    public void takeScreenshot(WebDriver driver) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        System.out.print(Util.Date.getDate());
        try {
            String filePath = SCREENSHOTS_DIR + "report_" + Util.Date.getTimeStamp() + ".png";
            File infile = screenshot.getScreenshotAs(OutputType.FILE);
            File outFile = new File(filePath);

            FileUtils.copyFile(infile, outFile);
        } catch (IOException ioe) {
            log.error("Exception in screenshot - {}", ioe.getMessage());
        }
    }
}
