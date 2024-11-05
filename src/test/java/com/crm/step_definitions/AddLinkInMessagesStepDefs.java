package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class AddLinkInMessagesStepDefs {

    ActivityStreamPage addLink = new ActivityStreamPage();
    private String originalWindow;

    @When("from the message editing tools selects Link option \\(chain icon)")
    public void from_the_message_editing_tools_selects_link_option_chain_icon() {
        addLink.linkOption.click();

    }

    @And("enters text in the Link text field")
    public void entersTextInTheLinkTextField() {
        addLink.linkTextField.sendKeys("Tesla");
    }

    @And("enters the URL in the URL text field")
    public void entersTheURLInTheURLTextField() {
        addLink.linkURLField.sendKeys("www.tesla.com");
    }

    @When("presses {string} button")
    public void presses_button(String SaveButton) {
        addLink.SaveButton.click();

    }

    @And("press {string} button")
    public void pressButton(String SendButton) {
        addLink.SendButton.click();
    }

    @Then("the specified text appears as a hyperlink in the posted message")
    public void the_specified_text_appears_as_a_hyperlink_in_the_posted_message() {
        addLink.getLinkTesla().isDisplayed();

    }

    @When("clicks on the hyperlink")
    public void clicks_on_the_hyperlink() {
        addLink.getLinkTesla().click();


    }

    @Then("user navigates to the correct URL")
    public void user_navigates_to_the_correct_url() {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the URL to be the expected one
        wait.until(ExpectedConditions.urlContains("tesla"));

        // Get the actual URL after navigation
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.tesla.com/";

        // Output the URLs for debugging purposes
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);

        // Assert that the actual URL starts with the expected URL
        Assert.assertTrue("The user did not navigate to the expected URL", actualUrl.startsWith(expectedUrl));

        // Close the new tab and switch back to the original window
        driver.close();
        driver.switchTo().window(originalWindow);
    }


    @Then("the link opens in a new tab")
    public void the_link_opens_in_a_new_tab() {

            WebDriver driver = Driver.getDriver();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Store the original window handle
            originalWindow = driver.getWindowHandle();


            // Wait for the new tab to open
            wait.until(ExpectedConditions.numberOfWindowsToBe(2));

            // Get all window handles
            Set<String> windowHandles = driver.getWindowHandles();

            // Switch to the new tab
            for (String windowHandle : windowHandles) {
                if (!windowHandle.equals(originalWindow)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }


    }




