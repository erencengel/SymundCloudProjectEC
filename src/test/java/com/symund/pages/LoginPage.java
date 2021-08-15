package com.symund.pages;

import com.symund.utilitites.ConfigurationReader;
import com.symund.utilitites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    String username = ConfigurationReader.get("username");
    String password = ConfigurationReader.get("password");

    @FindBy(css = "#user")
    public WebElement usernameBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = "#submit-form")
    public WebElement loginButton;

    public void successLoginMethod(){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

    @FindBy(css = ".warning.wrongPasswordMsg")
    public WebElement wronginputMessage;

    @FindBy(css = ".toggle-password>img")
    public WebElement eyeButton;

    public void eyeClickMethod(){
        eyeButton.click();
    }

    @FindBy(css = "#lost-password")
    public WebElement forgetPasswordButton;

    public void clickForgetPasswordButton(){
        forgetPasswordButton.click();
    }

    @FindBy(css = "#reset-password-submit")
    public WebElement resetPasswordButton;



}
