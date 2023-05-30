package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CommonElements {

    public CommonElements(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='logo logo-icon']")
    public WebElement tryCloudIcon;

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
