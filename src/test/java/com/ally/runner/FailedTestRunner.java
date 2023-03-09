package com.ally.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/ally/stepDefenitions",
        features = "target/rerun.txt",
        tags = "@ui"
)
public class FailedTestRunner {
}
