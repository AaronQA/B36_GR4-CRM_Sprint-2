package com.crm.step_definitions;

import com.crm.pages.SendMessageArea;
import io.cucumber.java.en.And;

public class SendMessageAreaStepDefs {

    public SendMessageArea messagePage = new SendMessageArea();

    @And("clicks on the message text area")
    public void clicks_on_the_message_text_area() {
        messagePage.clickMessageTextArea();
    }

}