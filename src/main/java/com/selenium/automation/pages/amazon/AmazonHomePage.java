package com.selenium.automation.pages.amazon;

import com.selenium.automation.pages.base.BasePage;
import com.selenium.automation.util.Util;

public class AmazonHomePage extends BasePage {

    private final AmazonCommonElements commonElements;

    public AmazonHomePage(){
        super();
        commonElements = new AmazonCommonElements();
    }

    public AmazonSearchResultsPage searchProduct(String product){
        enterText(commonElements.getSearchTextBox(),product);
        click(commonElements.getSearchIcon());
        Util.Sync.sleep(60);
        return new AmazonSearchResultsPage();
    }

}
