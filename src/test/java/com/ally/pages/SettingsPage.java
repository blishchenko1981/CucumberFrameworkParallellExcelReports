package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {

    public SettingsPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }



    @FindBy(xpath = "//input[@id='displayname']")
    public WebElement userNameField;


}
