package com.minted.pages;

import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrustPage {

    public TrustPage(){
        PageFactory.initElements(Driver.getDriver(), this);


    }
    @FindBy(xpath = "//input[@name='chat-box']")
    public WebElement trustSearchBox;

    @FindBy(xpath = "//div[@class='makeStyles-submitBtn-21']")
    public WebElement submitBtn;

    @FindBy(xpath = "//a[contains(text(),'here')]")
    public WebElement here;


}
