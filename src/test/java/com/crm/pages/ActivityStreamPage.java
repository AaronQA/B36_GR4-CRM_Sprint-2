package com.crm.pages;

import com.crm.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ActivityStreamPage extends BasePage{

    @FindBy(xpath = "//span[text()='More']")
    public WebElement moreButton;

    @FindBy(xpath = "//span[text()='Appreciation']")
    public WebElement appreciationButton;

    @FindBy(xpath = "//span[@title='Upload files']")
    public WebElement uploadFilesButton;

    @FindBy(xpath = "//input[@name='bxu_files[]']")
    public WebElement uploadElement;

    @FindBy(xpath =
            "//div[@id='diskuf-selectdialog-hzV3Wjd']//tbody[@class='diskuf-placeholder-tbody']//tr[1]//td[4]"
    ) // table where elements
    public WebElement webTable_InsertTextButton_FirstElement;

    @FindBy(xpath = "//tbody[@class='diskuf-placeholder-tbody']//tr[1]//td[5]") //
    public WebElement webTable_DeleteButton_FirstElement;


    public WebElement insertButton(int elementNumber){

        return Driver.getDriver().findElement(By.xpath(
                "//div[contains(@id, 'diskuf-selectdialog')]//tbody[@class='diskuf-placeholder-tbody']//tr[1]//td["+elementNumber+"]"
        ));

    } // clicks on the provided element

}
