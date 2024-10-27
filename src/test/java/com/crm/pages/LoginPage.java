package com.crm.pages;

import com.crm.utilities.BrowserUtils;
import com.crm.utilities.ConfigurationReader;
import com.crm.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement userInput;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@type='checkbox']")
    public WebElement rememberMe_checkbox;

    @FindBy(xpath = "//label[@for='USER_REMEMBER']")
    public WebElement rememberMe_text;




    public void login(String username, String password) {
        this.userInput.sendKeys(username);
        this.passwordInput.sendKeys(password);
        this.loginButton.click();
    }


    public void login(String userType) {
        this.userInput.sendKeys(ConfigurationReader.getProperty(userType+"_username"));
        this.passwordInput.sendKeys(ConfigurationReader.getProperty(userType+"_password"));
        this.loginButton.click();
    }



}
