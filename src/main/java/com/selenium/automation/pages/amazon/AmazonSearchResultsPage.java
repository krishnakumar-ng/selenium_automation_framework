package com.selenium.automation.pages.amazon;

import com.selenium.automation.pages.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AmazonSearchResultsPage extends BasePage {

    private AmazonCommonElements commonElements;

    @FindBy(xpath="//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div")
    private WebElement searchResultText;

    public AmazonSearchResultsPage(){
        super();
        commonElements = new AmazonCommonElements();
    }

    public String getSearchResults(){
        return searchResultText.getText();
    }
}
