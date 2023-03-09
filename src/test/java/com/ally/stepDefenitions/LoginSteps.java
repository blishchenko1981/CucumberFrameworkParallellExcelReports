package com.ally.stepDefenitions;

import com.ally.pages.LoginPage;
import com.ally.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage() ;

    @When("User input credentials and click Login button")
    public void user_input_credentials_and_click_login_button() {
        loginPage.loginAsUser(1);
    }


    @Then("Home page is displayed")
    public void home_page_is_displayed() {
        Assert.assertEquals("Dashboard - Trycloud QA", Driver.getDriver().getTitle());

    }

    @When("User input wrong {string} or {string} and click Login button")
    public void user_input_wrong_or_and_click_login_button(String user, String pass) {

        loginPage.loginWithWrongCredentials(user, pass);
    }


    @Then("Error message is displayed")
    public void error_message_is_displayed() {
     Assert.assertTrue(loginPage.errorMessage.isDisplayed());

    }



}
