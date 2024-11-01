package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage {

    //Define locator for the profile icon
    @FindBy(xpath = "//div[@id='user-block']")
    public WebElement profileIcon;

    //Define locator for My profile button
    @FindBy(xpath = "//span[.='My Profile']")
    public WebElement myProfileButton;

    //Define locators for the buttons
    @FindBy(xpath = "//a[.='General']")
    public WebElement generalButton;

    @FindBy(xpath = "//a[.='Drive']")
    public WebElement driveButton;

    @FindBy(xpath = "//a[.='Tasks']")
    public WebElement tasksButton;

    @FindBy(xpath = "//a[.='Calendar']")
    public WebElement calendarButton;

    @FindBy(xpath = "//a[.='Conversations']")
    public WebElement conversationsButton;

//    @FindBy()
//    public WebElement email;

    //Method to click on the profile button
    public void clickProfileIcon(){
        profileIcon.click();
    }

    //Method to verify the presence of each button
    public boolean buttonsAreDisplayed(){
        return generalButton.isDisplayed() && driveButton.isDisplayed() &&
                tasksButton.isDisplayed() && calendarButton.isDisplayed() &&
                conversationsButton.isDisplayed();
    }

//    //Method to retrieve the email text from the General tab
//    public String getEmailText(){
//        return email.getText();
//    }




}
