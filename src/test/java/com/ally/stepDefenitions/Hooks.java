package com.ally.stepDefenitions;

import com.ally.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupScenario(){

        System.out.println("Setting up browser using cucumber @Before each scenario");
    }


    @After("@ui")

    public void teardownScenario(Scenario scenario){

        if(scenario.isFailed()){

            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "ScreenshotFailedScenario");

        }

        Driver.closeBrowser();

    }

}
