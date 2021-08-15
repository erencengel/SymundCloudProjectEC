package com.symund.runners;

import com.github.javafaker.Faker;
import com.symund.pages.DashBoardPage;
import com.symund.pages.LoginPage;
import com.symund.utilitites.ConfigurationReader;
import com.symund.utilitites.Driver;
import sun.rmi.runtime.Log;

public class extra {
    public static void main(String[] args) throws InterruptedException {
        Driver.get().get(ConfigurationReader.get("url"));
        //new LoginPage().usernameBox.sendKeys();
        //new LoginPage().passwordBox.sendKeys();
        //new LoginPage().loginButton.click();
        //Thread.sleep(3);
        //System.out.println("new LoginPage().usernameBox.getAttribute(\"validationMessage\") = " + new LoginPage().usernameBox.getAttribute("validationMessage"));
        //System.out.println("new LoginPage().passwordBox.getAttribute(\"validationMessage\") = " + new LoginPage().passwordBox.getAttribute("validationMessage"));
        //Driver.get().quit();
//        Faker faker = new Faker();
//        new LoginPage().passwordBox.sendKeys(faker.pokemon().name());
//        new LoginPage().eyeClickMethod();
//        System.out.println(new LoginPage().passwordBox.getAttribute("type"));
        //System.out.println(new LoginPage().forgetPasswordButton.getText());
        System.out.println(new LoginPage().usernameBox.getAttribute("placeholder"));
        System.out.println(new LoginPage().passwordBox.getAttribute("placeholder"));
    }
}
