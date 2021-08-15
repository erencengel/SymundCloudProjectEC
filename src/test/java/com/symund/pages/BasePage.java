package com.symund.pages;

import com.symund.utilitites.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = "#expand>div>img")
    public WebElement userLink;

    @FindBy(css = "li[data-id='logout']")
    public WebElement logoutButton;

    public void logOutMethod(){
        userLink.click();
        logoutButton.click();
    }

    @FindBy(css = "#expanddiv>ul>li>div>span")
    public WebElement iconName;

}
