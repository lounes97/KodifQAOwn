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

    @FindBy(css = "svg[data-testid='RefreshIcon']")
    public WebElement refreshIcon;

    @FindBy(css = "svg[data-testid='ThumbDownIcon']")
    public WebElement thumbDownIcon;

    @FindBy(css = "svg[class='MuiSvgIcon-root MuiSvgIcon-colorError MuiSvgIcon-fontSizeSmall css-fj16jz-MuiSvgIcon-root']")
    public WebElement redThumbDownIcon;

    @FindBy(css = "svg[data-testid='ThumbUpIcon']")
    public WebElement thumbUpIcon;

    @FindBy(css = "svg[class='MuiSvgIcon-root MuiSvgIcon-colorSuccess MuiSvgIcon-fontSizeSmall css-5n9jjn-MuiSvgIcon-root']")
    public WebElement greenThumbUpIcon;

   @FindBy(css = "svg[data-testid='AttachFileIcon']")
    public WebElement attachFileIcon;

   @FindBy(css = "svg[data-testid='SentimentVerySatisfiedIcon']")
           public WebElement emojiBtn;
   @FindBy(css = "iframe[id='kodif-chat-widget']")
    public WebElement iframe;




}
