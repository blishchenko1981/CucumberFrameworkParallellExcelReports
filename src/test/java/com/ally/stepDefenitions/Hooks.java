package com.ally.stepDefenitions;

import com.ally.utilities.Driver;
import com.ally.utilities.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before("ui")
    public void setupScenario() {

        System.out.println("Setting up browser using cucumber @Before each scenario");
    }


    @After("@ui")

    public void teardownScenario(Scenario scenario) {

        if (scenario.isFailed()) {

            Screenshot.take(scenario);

        }

        Driver.closeBrowser();

    }

}