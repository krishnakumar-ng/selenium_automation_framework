package com.selenium.automation.stepdefinition;

import com.selenium.automation.contexts.TestContext;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AmazonSearchSteps {
    private static final Logger log = LogManager.getLogger(AmazonSearchSteps.class);
    private Scenario scenario;
    private TestContext testContext;

    public AmazonSearchSteps(CommonSteps commonSteps, TestContext testContext) {
        this.scenario = commonSteps.getScenario();
        this.testContext = testContext;
    }

    @Given("Open the Amazon Website")
    public void openTheAmazonWebsite() {
    }

    @And("Enter the given product: {}")
    public void enterTheGivenProductProduct(String product) {
    }

    @Then("Verify the results display the given product: {}")
    public void verifyTheResultsDisplayTheGivenProductProduct(String product) {
    }
}
