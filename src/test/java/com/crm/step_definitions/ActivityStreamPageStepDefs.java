package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import com.crm.utilities.BrowserUtils;
import com.crm.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStreamPageStepDefs {

    ActivityStreamPage activity = new ActivityStreamPage();

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

//-------------------------------------------Appreciation Features END------------------------------------------------//

}
