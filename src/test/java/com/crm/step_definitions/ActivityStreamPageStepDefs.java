package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStreamPageStepDefs {

    ActivityStreamPage activity = new ActivityStreamPage();

//-------------------------------------------Appreciation Features START----------------------------------------------//


    @Given("User is on the Portal home page")
    public void user_is_on_the_portal_home_page() {

        Driver.getDriver().get("https://login1.nextbasecrm.com/");
    }
    @When("User clicks on the message content")
    public void user_clicks_on_the_message_content() {
       activity.messageBox.click();

    }
    @When("User clicks on the send button without message")
    public void user_clicks_on_the_send_button_without_message() {

        activity.sendButton.click();
    }
    @Then("Error message is displayed {string}")
    public void error_message_is_displayed_the_message_title_is_not_specified(String errorText) {
        Assert.assertTrue(activity.errorMessageBox.isDisplayed());
        Assert.assertEquals(activity.errorMessageBox.getText(),errorText );
    }




    @When("clicks on More button \\(dropdown)")
    public void clicks_on_button_dropdown() {

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(4));
        wait.until(ExpectedConditions.elementToBeClickable(activity.moreButton));

        activity.moreButton.click();

    }

    @When("clicks on Appreciation option")
    public void clicks_on_option() {

        activity.appreciationButton.click();

    }

    @Then("uploads supported files")
    public void uploads_supported_files() {

        String projectPath = System.getProperty("user.dir")+"/src/test/resources/files"; // unique prop. + mid part

        activity.uploadFilesButton.click();

        activity.uploadElement.sendKeys(projectPath+"/TestDocx.docx");
        activity.uploadElement.sendKeys(projectPath+"/TestJpeg.jpg");
        activity.uploadElement.sendKeys(projectPath+"/TestPdf.pdf");
        activity.uploadElement.sendKeys(projectPath+"/TestPng.png");
        activity.uploadElement.sendKeys(projectPath+"/TestTxt.txt");

        BrowserUtils.sleep(4);  // waits until all the files are uploaded.

        Assert.assertTrue(activity.webTable_InsertTextButton_FirstElement.isDisplayed());
        // checks if the first element has been uploaded successfully.

    }

    @Then("clicks on the Insert in text button")
    public void clicks_on_the_button() {

        ActivityStreamPage.clicksAndCheckIfNoDisplayed(activity.webTable_InsertTextButton_FirstElement);

    }

    @Then("clicks on remove button")
    public void clicks_on_remove_button() {

        ActivityStreamPage.clicksAndCheckIfNoDisplayed(activity.webTable_DeleteButton_FirstElement);

    }

    @When("User click to Recipient button without recipient")
    public void userClickToRecipientButtonWithoutRecipient() {

        activity.messageBox.click();
        activity.recipientBox.click();
        activity.sendButton.click();
    }

    @Then("RecipientError message is displayed {string}")
    public void errorMessageIsDisplayed(String errorText) {
        Assert.assertTrue(activity.errorMessageBox.isDisplayed());
        Assert.assertEquals(activity.errorMessageBox.getText(),errorText );

    }

    @When("User clicks on the message box")
    public void userClicksOnTheMessageBox() {
        activity.messageBox.click();
        BrowserUtils.waitFor(3);

    }

    @Then("Message delivery is to {string} by default")
    public void messageDeliveryIsToByDefault(String allEmployees) {
        Assert.assertTrue(activity.allEmployeesBox.isDisplayed());
    }

    @When("User wants to cancel the message")
    public void userWantsToCancelTheMessage() {
        activity.messageBox.click();
        activity.cancelButton.click();
        BrowserUtils.waitFor(3);

    }

    @Then("The message will be cancelled")
    public void theMessageWillBeCancelled() {
      Assert.assertTrue(activity.messageBoxDefault.isDisplayed());
    }


//-------------------------------------------Appreciation Features END------------------------------------------------//

}
