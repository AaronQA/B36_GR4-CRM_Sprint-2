package com.CRM.pages;

import com.CRM.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }



    public  void login( String userName, String password ){


    }



}
