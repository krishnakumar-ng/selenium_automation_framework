package com.selenium.automation.tests;

import com.selenium.automation.driver.Driver;
import com.selenium.automation.enums.BrowserType;
import com.selenium.automation.pages.amazon.AmazonHomePage;
import com.selenium.automation.pages.amazon.AmazonSearchResultsPage;
import com.selenium.automation.pages.base.AbstractTest;
import com.selenium.automation.util.Util;
import org.testng.annotations.Test;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;
import static org.assertj.core.api.Assertions.assertThat;

public class AmazonSearchTest extends AbstractTest {

    @Test
    public void searchLaptopTest() {
        Driver.initDriver(BrowserType.CHROME);
        openUrl(CONFIG_PROPERTIES.url());
        Util.Sync.sleep(60);

        AmazonHomePage homePage = new AmazonHomePage();
        AmazonSearchResultsPage amazonSearchResultsPage = homePage.searchProduct("Laptop");
        assertThat(amazonSearchResultsPage.getTitle()).as("Invalid results page")
                .contains("Laptop");


        String REGEX = "\\d-\\d+ of over .* results for \"Laptop\"";
        boolean regexMatch = amazonSearchResultsPage.getSearchResults().matches(REGEX);

        assertThat(regexMatch)
                .as("Search result regex is mismatched - "+amazonSearchResultsPage.getSearchResults())
                .isTrue();
    }
}
