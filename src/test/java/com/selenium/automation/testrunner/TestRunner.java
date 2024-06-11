package com.selenium.automation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/"},
        monochrome = true,
        plugin = {"pretty:target/cucumber/cucumber.txt",
                "html:target/cucumber/cucumber-html-report.html",
                "json:target/cucumber/cucumber.json",
                "rerun:target/rerun/failed_scenarios.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
