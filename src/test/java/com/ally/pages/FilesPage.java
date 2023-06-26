package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage extends CommonElements {



    public FilesPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    // --------------------- Left side app menu elements ----------------------------------------------


    @FindBy(xpath = "//div[@id='app-navigation']//li[@data-id='files']")
    public WebElement allFiles;

    @FindBy(xpath = "//div[@id = 'app-navigation']//li[@data-id='recent']")
    public WebElement recent;

    @FindBy(xpath = "//div[@id = 'app-navigation']//li[@data-id='favorites']")
    public WebElement favorites;

    @FindBy(xpath = "//div[@id = 'app-navigation']//li[@data-id='shareoverview']")
    public WebElement share;

    @FindBy(xpath = "//div[@id = 'app-navigation']//li[@data-id='systemtagsfilter']")
    public WebElement tags;

    @FindBy(xpath = "//div[@id = 'app-navigation']//li[@data-id='circlesfilter']")
    public WebElement sharedToCircles;

    //---------------------------------------------------------------------------------------------------

    // -----------------------File row elements ---------------------------------------------------------
    @FindBy(xpath = "(//a[@data-action=\"Share\"])[1]")
    public WebElement shareIconOnFirstRow;

    @FindBy(xpath = "(//span[@class='nametext'])[1]")
    public WebElement nameOfTheFirtsFile;
    //---------------------------------------------------------------------------------------------------


    //------------------------file options widget -------------------------------------------------------
    @FindBy(xpath="//div[@class='app-sidebar-tabs']")
    public WebElement fileSideBar;

//    @FindBy(xpath = "//button[@class='action-item action-item--single sharing-entry__actions icon-add new-share-link undefined has-tooltip']")
//    public WebElement plusIcon;

    @FindBy(xpath = "//li[@class=\"sharing-entry sharing-entry__link sharing-entry--share\"]//a[@rel=\"noreferrer noopener\"]")
    public WebElement copyToClipboard;






    public void clickShareIconOnFirstFile() {
        shareIconOnFirstRow.click();
    }


}
