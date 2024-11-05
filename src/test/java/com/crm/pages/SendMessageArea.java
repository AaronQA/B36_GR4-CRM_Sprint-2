package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SendMessageArea extends BasePage {

    @FindBy(id = "microoPostFormLHE_blogPostForm_inner")
    public WebElement messageTextArea;



     // Method to click on the message text area
    public void clickMessageTextArea() {
        messageTextArea.click();
    }


}