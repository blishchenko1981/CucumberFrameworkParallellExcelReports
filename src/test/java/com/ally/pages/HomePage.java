package com.ally.pages;

import com.ally.utilities.BrowserUtil;
import com.ally.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonElements {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@id='app-dashboard']/h2")
    public WebElement greetings;


    // --------------------   Settings tab --------------------------------
    @FindBy(xpath = "//div[@id='settings']")
    public WebElement userSettings;

    @FindBy(xpath = "//li[@data-id='logout']")
    public WebElement logOut;


    //--------------------------Settings Options  --------------------------------------------

    @FindBy(xpath = "//nav[@class='settings-menu menu']//li")
    public List<WebElement> settingsOptions;


    @FindBy(xpath = "//a[@class='user-status-menu-item__toggle']")
    public WebElement onlineStatus;


    @FindBy(xpath = "//h3[contains(text(), 'Online status')]")
    public WebElement changeStatusWindow;

    @FindBy(xpath = "//button[@class ='action-item action-item--single header-close icon-close undefined undefined has-tooltip']")
    public WebElement closeStatusWindowBtn;

    @FindBy(xpath = "//li[@data-id='settings']")
    public WebElement settingsBtn;

    // --------------------------- Click on each module using module name as a parameter --------------------

    public void clickOnTab(String tabName) {
        WebElement module = Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//li[@data-id='" + tabName + "']"));
        module.click();
    }

    public void logOut() {
        userSettings.click();
        logOut.click();
        BrowserUtil.wait(2);
    }

    public boolean isCorrectOption(List<String> options) {
        boolean correctOption = false;
        for (String each : options) {

            if (onlineStatus.getText().contains(each)) {
                correctOption = true;
                System.out.println("homePage.onlineStatus.getText() = " + onlineStatus.getText());
            }
        }
        return correctOption;
    }

    public void assertIfOptionIsDisplayed(List<String> expectedOptions) {
        for (int i = 1; i <= expectedOptions.size(); i++) {

            System.out.println("homePage.settingsOptions.get(i).getText() = "
                    + settingsOptions.get(i).getText());

            Assert.assertTrue(settingsOptions.get(i).getText()
                    .contains(expectedOptions.get(i - 1)));

        }

    }


}
