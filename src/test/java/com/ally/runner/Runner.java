package com.ally.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/ally/stepDefenitions",
        features = "src/test/resources/features",

        plugin = {"pretty",
                "json:target/cucumber.json",
                "html:target/cucumber_report.html",
                "rerun:target/rerun.txt"  },

        dryRun = false,
        tags = "@ui"
)
public class Runner {
}
