package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends CommonElements {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id]")
    public List<WebElement> listOfMenuTabs;

    // --------------------   Settings tab --------------------------------
    @FindBy(xpath= "//div[@id='settings']")
    public WebElement UserSettings;

    @FindBy(xpath= "//li[@data-id='logout']")
    public WebElement logOut;



    // ________________________ HomeMenu Tabs ________________________________________________

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='dashboard']")
    public WebElement dashboard;

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='files']")
    public WebElement files;

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='photos']")
    public WebElement photos;

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='activity']")
    public WebElement activity;

    @FindBy(xpath = "//ul[@id='appmenu']//li[@data-id='talk']")
    public WebElement talk;

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

}
