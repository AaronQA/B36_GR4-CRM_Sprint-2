package com.crm.step_definitions;

import com.crm.pages.LoginPage;
import com.crm.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageStepDefs {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {

        System.out.println("DONE IN HOOKS");

    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String userType) {
        loginPage.login(userType);
    }

    @Then("user should be able to see {string} as page title")
    public void userShouldLandOnHomePageWith(String title) {
        BrowserUtils.verifyTitleContains(title);
    }




}
