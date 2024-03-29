package com.ally.stepDefenitions;

import com.ally.pages.HomePage;
import com.ally.pages.LoginPage;
import com.ally.pages.SettingsPage;
import com.ally.utilities.BrowserUtil;
import com.ally.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.*;

public class CheckHomePageSteps {

    HomePage homePage = new HomePage();
    SettingsPage settingsPage = new SettingsPage();
    Faker faker = new Faker();

    @When("User click on module {string}")
    public void user_click_on_module(String moduleName) {

        homePage.clickOnTab(moduleName);
    }

    @Then("{string} page is open")
    public void page_is_open(String moduleName) {

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(moduleName));

    }

    //------------------------------Settings dropdown ---------------------------------------------------


    @And("User log out")
    public void userLogedOut() throws InterruptedException {
        homePage.logOut();


    }


    @When("user click on settings")
    public void user_click_on_settings() {
        homePage.userSettings.click();
    }

    @Then("dropdown is displayed and include names")
    public void dropdown_is_displayed_and_include(List<String> expectedOptions) {

        System.out.println("options = " + expectedOptions);

        homePage.assertIfOptionIsDisplayed(expectedOptions);

    }


    @Then("status should have one of the next values")
    public void statusShouldHaveOneOfTheNextValues(List<String> statusOptions) {

        System.out.println("statusOptions = " + statusOptions);

        Assert.assertTrue(homePage.isCorrectOption(statusOptions));
    }


    @When("click on online status")
    public void click_on_online_status() {
        homePage.onlineStatus.click();
    }

    @Then("online status window appear")
    public void online_status_window_appear() {

        Assert.assertTrue(homePage.changeStatusWindow.isDisplayed());
    }


    @And("click on {string}")
    public void clickOn(String status) {

        WebElement statusBtn = Driver.getDriver().findElement(By.xpath("//div[@class='user-status-online-select']//label[contains(text(), '" + status + "')]"));
        statusBtn.click();

        homePage.closeStatusWindowBtn.click();
    }

    @Then("online {string} should be updated")
    public void onlineShouldBeUpdated(String status) {

        WebElement statusHomePage = Driver.getDriver().findElement(By.xpath("//button[contains(text(), '" + status + "')]"));
        Assert.assertTrue(statusHomePage.isDisplayed());
    }


    @Then("User see the login page")
    public void userSeeTheLoginPage() {

        LoginPage loginPage = new LoginPage();
        Assert.assertTrue(loginPage.loginBtn.isDisplayed());
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Trycloud QA"));
    }
//-----------------------------  Settings  -------------------------------------------------

    @When("click  settings icon on dropdown")
    public void click_settings_icon_on_dropdown() {

        homePage.settingsBtn.click();
    }

    @Then("setting page is displayed")
    public void setting_page_is_displayed() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Settings"));

    }


    String username = faker.name().firstName();

    @Then("user can change fields")
    public void user_can_change_fields() {

        settingsPage.changeUserName(username);
    }

    @And("navigate back to Home page")
    public void navigateBackToHomePage() {

        homePage.tryCloudIcon.click();
    }


    @Then("name on the Home page greeting displayed correctly")
    public void nameOnTheHomePageGreetingDisplayedCorrectly() {
        Assert.assertTrue(homePage.greetings.getText().contains(username));
    }


    // __________________ search Function ______________________________
    @When("user click on search")
    public void user_click_on_search() {
        homePage.searchBtn.click();
    }


    @When("type {string} in search box")
    public void type_in_search_box(String searchWord) {
        homePage.searchInputBox.sendKeys(searchWord);

    }

    @Then("all results contain {string}")
    public void all_results_contain(String searchWord) {

        for (WebElement each : homePage.searchResultListOfComments) {

            System.out.println("each.getText() = " + each.getText());
            Assert.assertTrue(each.getText().toLowerCase().contains(searchWord.toLowerCase()));
        }
    }
}
