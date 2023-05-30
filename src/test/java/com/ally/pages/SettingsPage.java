package com.ally.pages;

import com.ally.utilities.BrowserUtil;
import com.ally.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//input[@id='displayname']")
    public WebElement userNameField;

    public void changeUserName(String username){

        Actions actions = new Actions(Driver.getDriver());
        userNameField.click();

        BrowserUtil.wait(1);

        actions.keyDown(Keys.CONTROL)
                .sendKeys("a")
                .keyUp(Keys.CONTROL)
                .sendKeys(Keys.DELETE)
                .perform();
        userNameField.sendKeys(username);

        BrowserUtil.wait(1);
    }

}
