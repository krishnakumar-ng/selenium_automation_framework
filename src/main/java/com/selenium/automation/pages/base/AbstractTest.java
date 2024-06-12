package com.selenium.automation.pages.base;

import com.selenium.automation.driver.manager.DriverManager;

public abstract class AbstractTest {

    public void openUrl(String url){
        DriverManager.getDriver().get(url);
    }

}
