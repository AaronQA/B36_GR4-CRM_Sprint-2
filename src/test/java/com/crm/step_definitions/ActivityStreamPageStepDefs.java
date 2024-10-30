package com.crm.step_definitions;

import com.crm.pages.ActivityStreamPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ActivityStreamPageStepDefs {

    ActivityStreamPage activity = new ActivityStreamPage();

//-------------------------------------------Appreciation Features START----------------------------------------------//

    @When("clicks on More button \\(dropdown)")
    public void clicks_on_button_dropdown() {

        activity.moreButton.click();

    }

    @When("clicks on Appreciation option")
    public void clicks_on_option() {

        activity.appreciationButton.click();

    }

    @Then("uploads supported files")
    public void uploads_supported_files() {

        String testDocx = "C:\\Users\\grrra\\IdeaProjects\\B36_GR4-CRM_Sprint-2\\src\\test\\resources\\files\\TestDocx.docx";
        String testJpeg = "C:\\Users\\grrra\\IdeaProjects\\B36_GR4-CRM_Sprint-2\\src\\test\\resources\\files\\TestJpeg.jpg";
        String testPdf = "C:\\Users\\grrra\\IdeaProjects\\B36_GR4-CRM_Sprint-2\\src\\test\\resources\\files\\TestPdf.pdf";
        String testPng = "C:\\Users\\grrra\\IdeaProjects\\B36_GR4-CRM_Sprint-2\\src\\test\\resources\\files\\TestPng.png";
        String testTxt = "C:\\Users\\grrra\\IdeaProjects\\B36_GR4-CRM_Sprint-2\\src\\test\\resources\\files\\TestTxt.txt";

        activity.uploadFilesButton.click();

        activity.uploadElement.sendKeys(testDocx);
        activity.uploadElement.sendKeys(testJpeg);
        activity.uploadElement.sendKeys(testPdf);
        activity.uploadElement.sendKeys(testPng);
        activity.uploadElement.sendKeys(testTxt);

        Assert.assertTrue(activity.webTable_InsertTextButton_FirstElement.isDisplayed());
        // checks if the first element has been uploaded successfully.

    }

    @Then("clicks on the Insert in text button")
    public void clicks_on_the_button() {

        int i = 1;

        while(activity.insertButton(i).isDisplayed()){  // clicks on every visible "Insert in text" button

            activity.insertButton(i).click();
            i++;

        }

    }

    @Then("clicks on remove button")
    public void clicks_on_remove_button() {

        while(activity.webTable_DeleteButton_FirstElement.isDisplayed()){   // deletes every uploaded element.

            activity.webTable_DeleteButton_FirstElement.click();

        }

    }

//-------------------------------------------Appreciation Features END------------------------------------------------//

}
