package com.selenium.automation.testrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"src/test/resources/"},
        glue ={"com.selenium.automation.stepdefinition"},
        plugin = {"json:target/cucumber/cucumber.json",
                "html:target/cucumber/cucumber-html-reports/consolidated.html",
                "rerun:target/cucumber/cucumber-html-reports/rerun.txt"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
