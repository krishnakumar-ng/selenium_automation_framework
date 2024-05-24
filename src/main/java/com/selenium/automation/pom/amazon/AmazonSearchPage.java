package com.selenium.automation.pom.amazon;

import com.selenium.automation.pom.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchPage extends BasePage {
    @FindBy(xpath="//*[@id=\"a-autoid-0-announce\"]")
    private WebElement sortBy;
}
