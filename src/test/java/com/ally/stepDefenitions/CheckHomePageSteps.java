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

    @When("User click on module {string}")
    public void user_click_on_module(String moduleName) {

        WebElement module = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[@data-id='" + moduleName + "']"));
        module.click();
    }

    @Then("{string} page is open")
    public void page_is_open(String moduleName) {

        Assert.assertTrue(Driver.getDriver().getTitle().toLowerCase().contains(moduleName));

    }

    //------------------------------Settings dropdown ---------------------------------------------------


    @And("User log out")
    public void userLogedOut() throws InterruptedException {
        homePage.UserSettings.click();
        homePage.logOut.click();
        BrowserUtil.wait(2);


    }


    @When("user click on settings")
    public void user_click_on_settings() {
        homePage.UserSettings.click();
    }

    @Then("dropdown is displayed and include names")
    public void dropdown_is_displayed_and_include(List<String> ExpectedOptions) {

        System.out.println("options = " + ExpectedOptions);

        for (int i = 0; i < ExpectedOptions.size(); i++) {

            System.out.println("homePage.settingsOptions.get(i).getText() = " + homePage.settingsOptions.get(i).getText());

            Assert.assertTrue(homePage.settingsOptions.get(i).getText().contains(ExpectedOptions.get(i)));

        }


    }


    @Then("status should have one of the next values")
    public void statusShouldHaveOneOfTheNextValues(List<String> statusOptions) {

        System.out.println("statusOptions = " + statusOptions);

        boolean correctOption = false;
        for (String each : statusOptions) {

            if (homePage.onlineStatus.getText().contains(each)) {
                correctOption = true;
                System.out.println("homePage.onlineStatus.getText() = " + homePage.onlineStatus.getText());
            }
        }

        Assert.assertTrue(correctOption);
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

    Faker faker = new Faker();
    String username = faker.name().firstName();

    @Then("user can change fields")
    public void user_can_change_fields() {

        Actions actions = new Actions(Driver.getDriver());
        settingsPage.userNameField.click();

        BrowserUtil.wait(1);

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();
        settingsPage.userNameField.sendKeys(username);

        BrowserUtil.wait(1);
    }

    @And("navigate back to Home page")
    public void navigateBackToHomePage() {

        homePage.tryCloudIcon.click();
    }


    @Then("name on the Home page greeting displayed correctly")
    public void nameOnTheHomePageGreetingDisplayedCorrectly() {
        Assert.assertTrue(homePage.greetings.getText().contains(username));
    }
}
