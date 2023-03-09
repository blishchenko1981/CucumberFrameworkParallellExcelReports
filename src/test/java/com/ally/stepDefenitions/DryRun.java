package com.ally.stepDefenitions;

import com.ally.utilities.ConfigReader;
import com.ally.utilities.Driver;
import com.ally.utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.junit.Test;

public class DryRun {


    @Given("User provide url")
    public void user_provide_url() {

        String url = ConfigReader.read("url");
        System.out.println("url = " + url);
        System.out.println("ConfigReader.read(\"browser\") = " + ConfigReader.read("browser"));
        Driver.getDriver().get(url);

    }
    @Then("User can see title is {string}")
    public void user_can_see_title_is(String title) {
        Assert.assertTrue(Driver.getDriver().getTitle().equals(title));
    }

    @Test

    public void testExcelReader(){

        System.out.println("ExelReader.getCell(2,3) = " + ExcelReader.getRowCell(2, 2));

    }




}
