package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class AddLinkInMessagesStepDefs {


    ActivityStreamPage addLink = new ActivityStreamPage();
    private String originalWindow;

    @When("from the message editing tools selects Link option \\(chain icon)")
    public void from_the_message_editing_tools_selects_link_option_chain_icon() {
        addLink.linkOption.click();

    }

    @And("enters {string} in the Link text field")
    public void entersInTheLinkTextField(String string) {
        String text = ConfigurationReader.getProperty(string);
        addLink.linkTextField.sendKeys(text);
        BrowserUtils.sleep(1);

    }

    @And("enters the {string} in the URL text field")
    public void entersTheInTheURLTextField(String string) {
        String link = ConfigurationReader.getProperty(string);
        addLink.linkURLField.sendKeys(link);
        BrowserUtils.sleep(1);

    }


    @When("presses {string} button")
    public void presses_button(String SaveButton) {
        addLink.SaveButton.click();
        BrowserUtils.sleep(1);

    }

    @And("press {string} button")
    public void pressButton(String SendButton) {
        addLink.SendButton.click();
        BrowserUtils.sleep(1);
    }















    @And("clicks on the hyperlink {string}")
    public void clicksOnTheHyperlink(String string) {
        addLink.getLink(string).click();
    }



    @Then("user navigates to the {string}")
    public void user_navigates_to_the_tesla_url(String string) {

        WebDriver driver = Driver.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for the URL to be the expected one

        // Get the actual URL after navigation
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = ConfigurationReader.getProperty(string);

        wait.until(ExpectedConditions.urlContains(expectedUrl));

        // Output the URLs for debugging purposes
        System.out.println("Expected URL: " + expectedUrl);
        System.out.println("Actual URL: " + actualUrl);

        // Assert that the actual URL starts with the expected URL
        assert actualUrl != null;
        Assert.assertTrue("The user did not navigate to the expected URL", actualUrl.contains(expectedUrl));

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




