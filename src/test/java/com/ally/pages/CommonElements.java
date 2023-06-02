package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class CommonElements {

    public CommonElements() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='logo logo-icon']")
    public WebElement tryCloudIcon;
    //_________________________ UserMenu elements __________________________________________________

    @FindBy(xpath = "//span[@aria-label='Magnify icon']")
    public WebElement searchBtn;

    @FindBy(xpath = "//div[@aria-label='Notifications']")
    public WebElement notificationsBtn;

    @FindBy(xpath = "//div[@aria-controls='contactsmenu-menu']")
    public WebElement usersBtn;

    //_____________Search window _______

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchInputBox;

    @FindBy(xpath = "//a[contains(@href, 'http')]//h3//span")
    public List<WebElement> searchResultListOfComments;


    // ________________________ HomeMenu Tabs ________________________________________________

    @FindBy(xpath = "//ul[@id='appmenu']/li[@data-id]")
    public List<WebElement> listOfMenuTabs;

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


}
