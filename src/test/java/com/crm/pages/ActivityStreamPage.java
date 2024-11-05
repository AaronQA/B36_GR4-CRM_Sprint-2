package com.crm.pages;

import com.crm.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActivityStreamPage extends BasePage {

    @FindBy(xpath = "//span[@class='feed-add-post-form-link-text']")
    public WebElement moreButton;

    @FindBy(xpath = "//span[@class='menu-popup-item-text'][text()='Appreciation']")
    public WebElement appreciationButton;

    @FindBy(xpath = "//span[@id='bx-b-uploadfile-blogPostForm']")
    public WebElement uploadFilesButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadElement;

    @FindBy(xpath = "//span[text()='Insert in text']") // table where elements
    public WebElement webTable_InsertTextButton_FirstElement;

    @FindBy(xpath = "//span[@class='del-but']") //
    public WebElement webTable_DeleteButton_FirstElement;

    public static void clicksAndCheckIfNoDisplayed(WebElement element) { // clicks on the element and checks if it displays.

        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0)); // temporally set as 0 to avoid wainting

        try {
            while (element.isDisplayed()) {  // clicks on every visible "Insert in text" button
                element.click();
            }
        } catch (NoSuchElementException e) {
            // catches the exception as it already deleted all the visible elements.
            Assert.assertTrue(true);

        } finally {

            // Restore the original implicit wait time after the loop
            Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // Set this to your original implicit wait time back

        }

    }


//POLL

    @FindBy(id = "feed-add-post-form-tab-vote")
    public WebElement pollButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement titleFieldIframe;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement titleField;

    @FindBy(xpath = "(//span[@id='feed-add-post-destination-item']/span/span)[1]")
    public WebElement defaultDelivery;

    @FindBy(xpath = "//*[@id='feed-add-post-destination-item']/span/span[2]")
    public WebElement cancelDefaultDelivery;

    @FindBy(id = "question_0")
    public WebElement questionField;

    @FindBy(id = "answer_0__0_")
    public WebElement answer1Field;

    @FindBy(id = "answer_0__1_")
    public WebElement answer2Field;

    @FindBy(id = "answer_0__2_")
    public WebElement answer3Field;

    @FindBy(id = "multi_0")
    public WebElement multipleBox;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement titlePollFeed; // element for just created in feed poll's title

    @FindBy(xpath = "(//div[@class='bx-vote-question-title'])[1]")
    public WebElement questionPollFeed; // element for just created in feed poll's question

    @FindBy(xpath = "(//label[@for])[4]")
    public WebElement answer1PollFeed; // element for just created in feed poll's answer 1

    @FindBy(xpath = "(//label[@for])[6]")
    public WebElement answer2PollFeed; // element for just created in feed poll's answer 2

    @FindBy(xpath = "(//label[@for])[8]")
    public WebElement answer3PollFeed; // element for just created in feed poll's answer 3

    @FindBy(xpath = "//*[@id='feed-add-post-form-notice-blockblogPostForm']/div/span[2]")
    public WebElement errorMessage;


    //AddLinkInMessages

    @FindBy(id = "microoPostFormLHE_blogPostForm_inner")
    public WebElement messageTextArea;

    @FindBy(xpath = "//*[@title='Link']")
    public WebElement linkOption;

    @FindBy(xpath = "//*[@id='linkidPostFormLHE_blogPostForm-text']")
    public WebElement linkTextField;

    @FindBy(xpath = "//*[@id='linkidPostFormLHE_blogPostForm-href']")
    public WebElement linkURLField;

    @FindBy(xpath = "//*[@value='Save']")
    public WebElement SaveButton;

    @FindBy(id = "blog-submit-button-save")
    public WebElement SendButton;

    public WebElement getLinkTesla() {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='http://www.tesla.com']")));


    }
}