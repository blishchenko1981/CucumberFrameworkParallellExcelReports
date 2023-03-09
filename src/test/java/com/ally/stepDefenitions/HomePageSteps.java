package com.ally.stepDefenitions;

import com.ally.pages.HomePage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomePageSteps {

HomePage homePage = new HomePage();

    @Then("User can see home menu modules")
    public void user_can_see_home_menu_modules() {

        Assert.assertEquals(10, homePage.listOfMenuTabs.size());

    }
}
