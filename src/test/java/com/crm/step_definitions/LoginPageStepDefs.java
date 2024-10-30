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

    @When("user attempts to log in with either incorrect email or password: {string} and {string}")
    public void user_attempts_to_log_in_with_either_incorrect_email_or_password(String email, String password) {
        loginPage.login(email, password);
    }

    @Then("user should see {string} error message")
    public void user_should_see_error_message(String expectedErrorMessage) {

        String actual_errorMessage = loginPage.incorrect_loginOrPassword.getText();
        Assert.assertEquals(expectedErrorMessage, actual_errorMessage);
    }

    @When("user attempts to log in with {string} and {string}")
    public void user_attempts_to_log_in_with_empty_credentials(String email, String password) {
        loginPage.login(email, password);
    }

    @When("user should see {string} link")
    public void user_should_see_link(String expectedCheckbox) {

        Assert.assertTrue(loginPage.rememberMe_checkbox_text.isDisplayed());

    }

    @Then("user should be able to click on {string} link")
    public void user_should_be_able_to_click_on_link(String checkbox) {

        loginPage.rememberMe_checkbox.click();
        loginPage.rememberMe_checkbox.isSelected();
    }

    @When("user sees the password field")
    public void user_sees_the_password_field() {
        loginPage.passwordInput.isDisplayed();
    }

    @When("user enters {string} in the password field")
    public void user_enters_in_the_password_field(String randomCharacters) {
        loginPage.passwordInput.sendKeys(randomCharacters);
    }

    @Then("user should see password field with {string} attribute type")
    public void user_should_see_password_field_with_signs_by_default(String expected_attributeType) {

        Assert.assertTrue(loginPage.passwordType.getAttribute("type").equals(expected_attributeType));
    }

    @When("user logs in as {string} \\(StepanVersion)")
    public void user_logs_in_as_stepan_version(String string) { // makeshift approach, haha!

        String password = "UserUser";

        loginPage.userInput.sendKeys(string);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();

    }


}
