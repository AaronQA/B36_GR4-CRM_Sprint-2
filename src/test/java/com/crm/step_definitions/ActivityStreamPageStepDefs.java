package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStreamPageStepDefs {

    ActivityStreamPage activity = new ActivityStreamPage();
    Wait<WebDriver> wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
    Faker faker = new Faker(); String input = faker.bothify("###???");
//-------------------------------------------Appreciation Features START----------------------------------------------//

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

        String projectPath = System.getProperty("user.dir") + "/src/test/resources/files"; // unique prop. + mid part

        activity.uploadFilesButton.click();

        activity.uploadElement.sendKeys(projectPath + "/TestDocx.docx");
        activity.uploadElement.sendKeys(projectPath + "/TestJpeg.jpg");
        activity.uploadElement.sendKeys(projectPath + "/TestPdf.pdf");
        activity.uploadElement.sendKeys(projectPath + "/TestPng.png");
        activity.uploadElement.sendKeys(projectPath + "/TestTxt.txt");

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

//-------------------------------------------Appreciation Features END------------------------------------------------//

//-------------------------------------------POLL Features START------------------------------------------------------//

    @When("user navigates to poll section by clicking POLL button")
    public void user_navigates_to_poll_section_by_clicking_poll_button() {
        activity.pollButton.click();
    }

    @Then("user should see default delivery {string}")
    public void user_should_see_default_delivery(String string) {
        wait.until(ExpectedConditions.visibilityOf(activity.defaultDelivery));
        Assert.assertEquals(activity.defaultDelivery.getText(), string);
    }

    @When("user enters Message Title")
    public void user_enters_message_title() {
    Driver.getDriver().switchTo().frame(activity.titleFieldIframe);
    activity.titleField.sendKeys(input);
    Driver.getDriver().switchTo().parentFrame();
    }

    @When("user enters Question")
    public void user_enters_question() {
       activity.questionField.sendKeys(input);
    }
    @When("user enters Answer {int}")
    public void user_enters_answer(Integer int1) {
        switch (int1){
            case 1-> activity.answer1Field.sendKeys(input);
            case 2-> activity.answer2Field.sendKeys(input);
            case 3-> activity.answer3Field.sendKeys(input);
        }
    }
    @When("user submits poll by clicking SEND button")
    public void user_submits_poll_by_clicking_send_button() {
        activity.sendButton.click();
    }
    @Then("successfully created poll is displayed in the feed")
    public void successfully_created_poll_is_displayed_in_the_feed() {
        //wait.until(ExpectedConditions.visibilityOf(activity.titlePollFeed)); not stable solution
        BrowserUtils.sleep(3);
        Assert.assertEquals(activity.titlePollFeed.getText(),input);
        Assert.assertEquals(activity.questionPollFeed.getText(),input);
        Assert.assertEquals(activity.answer1PollFeed.getText(),input);
        Assert.assertEquals(activity.answer2PollFeed.getText(),input);
        Assert.assertEquals(activity.answer3PollFeed.getText(),input);
    }

    @Then("user can select multiple choice checkbox")
    public void userCanSelectMultipleChoiceCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(activity.multipleBox));
        activity.multipleBox.click();
        Assert.assertTrue(activity.multipleBox.isSelected());
    }

    @And("user cancels default delivery")
    public void userCancelsDefaultDelivery() {
        wait.until(ExpectedConditions.elementToBeClickable(activity.defaultDelivery));
        activity.cancelDefaultDelivery.click();
    }

    @Then("Error message {string} is displayed")
    public void errorMessageIsDisplayed(String arg0) {
        wait.until(ExpectedConditions.visibilityOf(activity.errorMessage));
        Assert.assertEquals(activity.errorMessage.getText(), arg0);
    }

    @Then("Error message {string}...{string}  is displayed")
    public void errorMessageIsDisplayed(String arg0, String arg1) {
        wait.until(ExpectedConditions.visibilityOf(activity.errorMessage));
        Assert.assertEquals(activity.errorMessage.getText(), (arg0 + input + arg1));
    }


//-------------------------------------------POLL Features END------------------------------------------------------//
}
