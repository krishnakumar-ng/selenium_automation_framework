package com.selenium.automation.pages.amazon;

import com.selenium.automation.pages.base.BasePage;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@EqualsAndHashCode(callSuper = true)
@Data
public class AmazonCommonElements extends BasePage {
    @FindBy(id="twotabsearchtextbox")
    private WebElement searchTextBox;

    @FindBy(id="nav-search-submit-button")
    private WebElement searchIcon;
}
