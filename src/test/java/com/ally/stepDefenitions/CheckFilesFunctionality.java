package com.ally.stepDefenitions;

import com.ally.pages.FilesPage;
import com.ally.utilities.BrowserUtil;
import com.ally.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public class CheckFilesFunctionality {

    FilesPage filesPage = new FilesPage();
    String firstFileName;

    @Then("All option to see files are presented on the Files page")
    public void all_option_to_see_files_are_presented_on_the_files_page() {

        Assert.assertTrue(filesPage.allFiles.isDisplayed() &&
                filesPage.favorites.isDisplayed() &&
                filesPage.recent.isDisplayed() &&
                filesPage.share.isDisplayed() &&
                filesPage.tags.isDisplayed() &&
                filesPage.sharedToCircles.isDisplayed()
        );

    }

    @And("Click on Share icon on first file row")
    public void clickOnShareIconOnFirstFileRow() {

        filesPage.clickShareIconOnFirstFile();

    }

    @Then("Sharing widget is displayed")
    public void sharingWidgetIsDisplayed() {

        Assert.assertTrue(filesPage.fileSideBar.isDisplayed());
    }

    @And("User copy the link")
    public void userCopyTheLinkAndSaveFileName() {

        firstFileName = filesPage.nameOfTheFirtsFile.getText();
        BrowserUtil.wait(2);
        try {
            Driver.getDriver().findElement(By.xpath("//button[@class='action-item action-item--single sharing-entry__actions icon-add new-share-link undefined has-tooltip']")).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("File already has share link");
        }


        filesPage.copyToClipboard.click();

    }

    @And("User open link in a new tab")
    public void userOpenLinkInANewTab() {
        String url = "";
        try {
            url = (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("url = " + url);

        Driver.getDriver().get(url);
    }

    @Then("User can see the file is open")
    public void userCanSeeTheFileIsOpen() {

        String fileName = Driver.getDriver().findElement(By.xpath("//h1[@class='header-appname']")).getText();

        System.out.println("firstFileName = " + firstFileName);
        System.out.println("fileName = " + fileName);

        //   Assert.assertEquals(firstFileName.substring(0, firstFileName.indexOf(".")), fileName.substring(0, fileName.indexOf(".")));
        if(fileName.contains(".")){
        Assert.assertTrue(fileName.startsWith(firstFileName.substring(0, firstFileName.indexOf(".") - 1)));
        Assert.assertTrue(fileName.endsWith(firstFileName.substring(firstFileName.indexOf("."))));
        }else {
            Assert.assertEquals(fileName, firstFileName);
        }


    }


    @And("Click plus icon")
    public void clickPlusIcon() {
        filesPage.plusBtn.click();
    }


    @And("Select folder in dropdown menu")
    public void selectFolderInDropdownMenu() {
        filesPage.newFolder.click();
    }

    @And("Give the File name {string}")
    public void giveTheFileName(String name) {

        filesPage.provideNameForNewFolder(name);

    }

    @Then("Folder {string} should be displayed on the page")
    public void folderShouldBeDisplayedOnThePage(String name) {
        BrowserUtil.wait(2);

        Assert.assertTrue(filesPage.getListEachNameOfFiles().contains(name));
    }

    @And("Folder {string} can be deleted")
    public void folderCanBeDeleted(String name) {

        Actions action = new Actions(Driver.getDriver());

        for (WebElement eachName : filesPage.listAllFiles) {
            if (eachName.getText().contains(name)) {
                action.moveToElement(eachName).contextClick().perform();
                break;
            }
        }

        BrowserUtil.wait(5);
        filesPage.delete.click();

        BrowserUtil.wait(1);

        Assert.assertFalse(filesPage.getListEachNameOfFiles().contains(name));
    }
}



