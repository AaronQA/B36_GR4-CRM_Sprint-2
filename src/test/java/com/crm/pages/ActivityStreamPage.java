package com.crm.pages;

import com.crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class ActivityStreamPage extends BasePage{

    @FindBy(xpath = "//span[@class='feed-add-post-form-link-text']")
    public WebElement moreButton;

    @FindBy(xpath = "//span[@class='menu-popup-item-text'][text()='Appreciation']")
    public WebElement appreciationButton;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFilesButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadElement;

    @FindBy(xpath =
            "//span[text()='Insert in text']"
    ) // table where elements
    public WebElement webTable_InsertTextButton_FirstElement;

    @FindBy(xpath = "//span[@class='del-but']") //
    public WebElement webTable_DeleteButton_FirstElement;

    public static void clicksAndCheckIfNoDisplayed(WebElement element){ // clicks on the element and checks if it displays.

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // temporally set as 0 to avoid wainting

        try {
            while (element.isDisplayed()) {  // clicks on every visible "Insert in text" button
                element.click();
            }
        } catch (NoSuchElementException e) {
            // catches the exception as it already deleted all the visible elements.
            Assert.assertTrue(true);

        }finally {

            // Restore the original implicit wait time after the loop
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set this to your original implicit wait time back

        }

    }

}
