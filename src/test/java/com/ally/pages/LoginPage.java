package com.ally.pages;

import com.ally.utilities.Driver;
import com.ally.utilities.ExcelReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(), 'Wrong username or password.')]")
    public WebElement errorMessage;


    public void loginAsUser(int userNumber){
        String user = "User" + userNumber ;
        userName.sendKeys(user);

        String pass= ExcelReader.getRowCell(userNumber,2);
        password.sendKeys(pass);

        loginBtn.click();

    }

    public void loginWithWrongCredentials(String username, String pswd){

        userName.sendKeys(username);
        password.sendKeys(pswd);
        loginBtn.click();

    }


}
