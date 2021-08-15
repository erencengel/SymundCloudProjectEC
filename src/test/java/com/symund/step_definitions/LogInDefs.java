package com.symund.step_definitions;

import com.github.javafaker.Faker;
import com.symund.pages.DashBoardPage;
import com.symund.pages.LoginPage;
import com.symund.utilitites.BrowserUtils;
import com.symund.utilitites.ConfigurationReader;
import com.symund.utilitites.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import sun.rmi.runtime.Log;

public class LogInDefs {

    Faker faker = new Faker();

    @When("the user enter valid credential")
    public void theUserEnterValidCredential() {
        new LoginPage().usernameBox.sendKeys(ConfigurationReader.get("username"));
        new LoginPage().passwordBox.sendKeys(ConfigurationReader.get("password"));
    }


    @When("the user click login button")
    public void the_user_click_login_button() {
        new LoginPage().loginButton.click();
        BrowserUtils.waitForVisibility(new DashBoardPage().userLink,10);
    }

    @Then("the user should able to login")
    public void the_user_should_able_to_login() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("dashboard"));
        System.out.println("Driver.get().getCurrentUrl() = " + Driver.get().getCurrentUrl());

    }

    @Then("the user should be seen under profile icon as expected")
    public void the_user_should_be_seen_under_profile_icon_as_expected() {
        String expectedOutput = "erencengel";
        String actualOutput = new DashBoardPage().iconName.getAttribute("title");
        System.out.println("new DashBoardPage().iconName.getAttribute(\"title\") = " + new DashBoardPage().iconName.getAttribute("title"));

    }

    @When("the user hit enter button")
    public void the_user_hit_enter_button() {
        //new LoginPage().usernameBox.sendKeys(Keys.ENTER);
        new LoginPage().loginButton.sendKeys(Keys.ENTER);
    }

    @When("the user enter invalid credentials as {string} and {string}")
    public void theUserEnterInvalidCredentialsAsAnd(String arg0, String arg1) {
        new LoginPage().usernameBox.sendKeys(arg0);
        new LoginPage().passwordBox.sendKeys(arg1);
        new LoginPage().loginButton.click();
    }

    @Then("Verify that error message should be seen")
    public void verifyThatErrorMessageShouldBeSeen() {
        String expectedErrorMessage = "Wrong username or password.";
        String actualErrorMessage = new LoginPage().wronginputMessage.getText();
        Assert.assertEquals(expectedErrorMessage,actualErrorMessage);
    }

    @Then("Verify that invalid message{int} should be seen")
    public void verifyThatInvalidMessageShouldBeSeen(int arg0) {
        String expectedOutput = "Please fill out this field.";
        String actualOutput1 = new LoginPage().usernameBox.getAttribute("validationMessage");
        String actualOutput2 = new LoginPage().passwordBox.getAttribute("validationMessage");
        System.out.println("new LoginPage().usernameBox.getAttribute(\"validationMessage\") = " + new LoginPage().usernameBox.getAttribute("validationMessage"));
        System.out.println("new LoginPage().passwordBox.getAttribute(\"validationMessage\") = " + new LoginPage().passwordBox.getAttribute("validationMessage"));
        Assert.assertTrue((actualOutput1).equals(expectedOutput) || (actualOutput2).equals(expectedOutput));
        //Assert.assertEquals(expectedOutput,actualOutput);
    }

    @When("the user enter invalid credentials as wrongInput and blank")
    public void theUserEnterInvalidCredentialsAsWrongInputAndBlank() {
        new LoginPage().usernameBox.sendKeys(faker.name().fullName());
        new LoginPage().loginButton.click();
    }

    @When("the user enter any password")
    public void theUserEnterAnyPassword() {
        new LoginPage().passwordBox.sendKeys(faker.pokemon().name());
    }

    @Then("the user should see dots as default")
    public void theUserShouldSeeDotsAsDefault() {
        String expected = "password";
        String actual = new LoginPage().passwordBox.getAttribute("type");
        Assert.assertTrue(expected.equals(actual));
    }

    @Then("the user should see password if needed")
    public void theUserShouldSeePasswordIfNeeded() {
        new LoginPage().eyeClickMethod();
        String expected = "text";
        String actual = new LoginPage().passwordBox.getAttribute("type");
        Assert.assertTrue(expected.equals(actual));
    }

    @Then("the user should able to see forgot password button")
    public void theUserShouldAbleToSeeForgotPasswordButton() {
        String expected = "Forgot password?";
        String actual = new LoginPage().forgetPasswordButton.getText();
        Assert.assertTrue((new LoginPage().forgetPasswordButton.isDisplayed()) && expected.equals(actual));
    }

    @And("the user should able to click forgot button")
    public void theUserShouldAbleToClickForgotButton() {
        new LoginPage().clickForgetPasswordButton();
    }

    @Then("the user should able to see reset password button")
    public void theUserShouldAbleToSeeResetPasswordButton() {
        Assert.assertTrue((new LoginPage().resetPasswordButton.isDisplayed()));
    }

    @When("the user send valid inputs into related buttons")
    public void theUserSendValidInputsIntoRelatedButtons() {

    }

    @Then("the user should able to see valid placeholder in the username box")
    public void theUserShouldAbleToSeeValidPlaceholderInTheUsernameBox() {
        Assert.assertTrue((new LoginPage()).usernameBox.getAttribute("placeholder").equals("Username or email"));
    }

    @Then("the user should able to see valid placeholder in the password box")
    public void theUserShouldAbleToSeeValidPlaceholderInThePasswordBox() {
        Assert.assertTrue((new LoginPage()).passwordBox.getAttribute("placeholder").equals("Password"));
    }
}

