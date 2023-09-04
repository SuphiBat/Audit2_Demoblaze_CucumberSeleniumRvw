package com.demoblaze.pages;

import com.demoblaze.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id="login2")
    public WebElement loginHomePage;
    @FindBy(id="loginusername")
    public WebElement loginusername;
    @FindBy(id="loginpassword")
    public WebElement loginpassword;
    @FindBy(css ="[onclick='logIn()']")
    public WebElement logInBtn;
    public void login(){
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");
        loginHomePage.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        logInBtn.click();
    }
    public void login(String username, String password){

        loginHomePage.click();
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        logInBtn.click();
    }

}
