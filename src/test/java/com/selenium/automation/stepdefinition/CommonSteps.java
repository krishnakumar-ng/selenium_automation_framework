package com.selenium.automation.stepdefinition;

import com.selenium.automation.util.Util;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import lombok.Data;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Data
public class CommonSteps {
    private static final Logger log = LogManager.getLogger(CommonSteps.class);
    private Scenario scenario;

    @Before(order = 0)
    public void setUp(Scenario scenario) {
        log.info("============================ Scenario: {} : Line: {} - started ============================", scenario.getName(), scenario.getLine());
        this.scenario = scenario;
    }

    @And("wait for {int} seconds")
    public void waitForSeconds(Integer secs) {
        log.info("Wait for : {} seconds.", secs);
        Util.Sync.sleep(secs);
    }
}
