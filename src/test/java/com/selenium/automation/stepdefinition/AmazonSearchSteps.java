package com.selenium.automation.stepdefinition;

import com.selenium.automation.contexts.TestContext;
import com.selenium.automation.driver.Driver;
import com.selenium.automation.enums.BrowserType;
import com.selenium.automation.pages.amazon.AmazonHomePage;
import com.selenium.automation.pages.amazon.AmazonSearchResultsPage;
import com.selenium.automation.pages.base.AbstractTest;
import com.selenium.automation.util.Util;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.selenium.automation.config.ConfigPropertiesFactory.CONFIG_PROPERTIES;
import static org.assertj.core.api.Assertions.assertThat;

public class AmazonSearchSteps extends AbstractTest {
    private static final Logger log = LogManager.getLogger(AmazonSearchSteps.class);
    private Scenario scenario;
    private TestContext testContext;
    private AmazonSearchResultsPage amazonSearchResultsPage;

    public AmazonSearchSteps(CommonSteps commonSteps, TestContext testContext) {
        this.scenario = commonSteps.getScenario();
        this.testContext = testContext;
    }

    @Given("Open the Amazon Website")
    public void openTheAmazonWebsite() {
        Driver.initDriver(BrowserType.CHROME);
        openUrl(CONFIG_PROPERTIES.url());
        Util.Sync.sleep(60);
        log.info("{} is launched with url : {}",BrowserType.CHROME,CONFIG_PROPERTIES.url());
    }

    @And("Enter the given product: {}")
    public void enterTheGivenProductProduct(String product) {
        AmazonHomePage homePage = new AmazonHomePage();
        log.info("Searching the : {} in the Amazon",product);
        amazonSearchResultsPage = homePage.searchProduct(product);
    }

    @Then("Verify the results display the given product: {}")
    public void verifyTheResultsDisplayTheGivenProductProduct(String product) {
        assertThat(amazonSearchResultsPage.getTitle()).as("Invalid results page")
                .contains(product);

        String REGEX = "\\d-\\d+ of over .* results for \""+product+"\"";
        boolean regexMatch = amazonSearchResultsPage.getSearchResults().matches(REGEX);

        assertThat(regexMatch)
                .as("Search result regex is mismatched - "+amazonSearchResultsPage.getSearchResults())
                .isTrue();
        log.info("Validation is successful");
    }
}
