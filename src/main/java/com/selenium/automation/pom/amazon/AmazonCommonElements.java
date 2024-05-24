package com.selenium.automation.pom.amazon;

import com.selenium.automation.pom.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonCommonElements extends BasePage {
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchIcon;
}
