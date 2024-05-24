package com.selenium.automation.pom.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.selenium.automation.driver.manager.DriverManager;

public class BasePage {

    protected BasePage() {
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    protected void click(WebElement element){
        element.click();
    }

    protected void enterText(WebElement element, String text){
        element.sendKeys(text);
    }

    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
}
