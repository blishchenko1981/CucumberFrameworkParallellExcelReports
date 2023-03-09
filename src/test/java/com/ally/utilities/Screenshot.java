package com.ally.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Screenshot {

    public static void take(Scenario scen) {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
        scen.attach(screenshot, "image/png", "ScreenshotFailedScenario");
    }
}