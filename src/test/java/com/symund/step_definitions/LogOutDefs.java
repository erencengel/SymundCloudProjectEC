package com.symund.step_definitions;

import com.symund.pages.DashBoardPage;
import com.symund.pages.LoginPage;
import com.symund.utilitites.BrowserUtils;
import com.symund.utilitites.ConfigurationReader;
import com.symund.utilitites.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOutDefs {

    @Given("the user is on the log in page")
    public void the_user_is_on_the_log_in_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }


    @And("the user enter valid credential and login")
    public void theUserEnterValidCredentialAndLogin() {
        new LoginPage().successLoginMethod();
        BrowserUtils.waitForClickablility(new DashBoardPage().userLink,10);
    }

    @When("the user should able to log out")
    public void theUserShouldAbleToLogOut() {
        new DashBoardPage().logOutMethod();
    }

    @Then("verify user logout")
    public void verifyUserLogout() {
        BrowserUtils.waitForVisibility(new LoginPage().usernameBox,10);
        String expectedOutput = "Symund - QA";
        String actualOutput = Driver.get().getTitle();
        Assert.assertEquals(expectedOutput,actualOutput);

    }

    @Then("verify that user can not go to home page again by clicking step back button")
    public void verifyThatUserCanNotGoToHomePageAgainByClickingStepBackButton(){
        BrowserUtils.waitForClickablility(new LoginPage().usernameBox,10);
        Driver.get().navigate().back();
        BrowserUtils.waitForClickablility(new LoginPage().usernameBox,10);
        String expectedOutput = "Symund - QA";
        String actualOutput = Driver.get().getTitle();
        Assert.assertEquals(expectedOutput,actualOutput);
    }


}
