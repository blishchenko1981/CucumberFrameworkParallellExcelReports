package com.ally.pages;

import com.ally.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
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


    // -----------------------File row elements ---------------------------------------------------------
    @FindBy(xpath = "(//a[@data-action=\"Share\"])[1]")
    public WebElement shareIconOnFirstRow;

    @FindBy(xpath = "(//span[@class='nametext'])[1]")
    public WebElement nameOfTheFirtsFile;


    //----------------------------Plus Button "+" to add New folders, files and so on -----------------------------------------------------------------------
    @FindBy(xpath = "//a[@class='button new']")
    public WebElement plusBtn;

    // dropdown menu's  elements to add new:

    @FindBy(xpath = "//span[text()= 'Upload file']")
    public WebElement uploadFile;
    @FindBy(xpath = "//span[text()= 'New folder']")
    public WebElement newFolder;
    @FindBy(xpath = "//span[text()= 'New Document']")
    public WebElement newDocument;
    @FindBy(xpath = "//span[text()= 'New Spreadsheet']")
    public WebElement newSpreadsheet;
    @FindBy(xpath = "//span[text()= 'New Presentation']")
    public WebElement newPresentation;
    @FindBy(xpath = "//span[text()= 'New text document']")
    public WebElement newTextDocument;

    // input filed for giving name for new folder
    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement inputNewFolderName;


    public void provideNameForNewFolder(String name){
        inputNewFolderName.sendKeys(name);
        inputNewFolderName.sendKeys(Keys.ENTER);
    }

    //------------------------file options widget -------------------------------------------------------
    @FindBy(xpath = "//div[@class='app-sidebar-tabs']")
    public WebElement fileSideBar;

//    @FindBy(xpath = "//button[@class='action-item action-item--single sharing-entry__actions icon-add new-share-link undefined has-tooltip']")
//    public WebElement plusIcon;

    @FindBy(xpath = "//li[@class=\"sharing-entry sharing-entry__link sharing-entry--share\"]//a[@rel=\"noreferrer noopener\"]")
    public WebElement copyToClipboard;


    @FindBy(xpath = "//span[@class=\"innernametext\"]")
    public List<WebElement> listAllFiles;


    // dropdown menu after context click(right mouse click) on any row
    @FindBy(xpath = "//li[contains(@class, 'action-0')]")
    public WebElement AddToFavorites;
    @FindBy(xpath = "//li[contains(@class, 'action-1')]")
    public WebElement Details;
    @FindBy(xpath = "//li[contains(@class, 'action-2')]")
    public WebElement Rename;
    @FindBy(xpath = "//li[contains(@class, 'action-3')]")
    public WebElement MoveOrCopy;
    @FindBy(xpath = "//li[contains(@class, 'action-4')]")
    public WebElement Download;
    @FindBy(xpath = "//li[contains(@class, 'action-5')]")
    public WebElement delete;



    public List<String> getListEachNameOfFiles() {
        List<String> result = new ArrayList<>();

        for (WebElement eachName : listAllFiles) {
            result.add(eachName.getText());
        }

        return result;
    }
    public void clickShareIconOnFirstFile() {
        shareIconOnFirstRow.click();
    }


}
