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

    @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[2]")
    public WebElement redThumbDownIcon;

    @FindBy(css = "svg[data-testid='ThumbUpIcon']")
    public WebElement thumbUpIcon;

    @FindBy(css = "span[class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root']:first-child")
    public WebElement greenThumbUpIcon;

   @FindBy(css = "svg[data-testid='AttachFileIcon']")
    public WebElement attachFileIcon;

   @FindBy(css = "svg[data-testid='SentimentVerySatisfiedIcon']")
           public WebElement emojiBtn;
   @FindBy(css = "iframe[id='kodif-chat-widget']")
    public WebElement iframe;

   @FindBy(xpath = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1gpkj7r-MuiButtonBase-root-MuiButton-root']")
    public WebElement newConversationBtn;

   @FindBy(xpath = "//div[@class='MuiBox-root css-1bkwata']")
    public WebElement sessionHasExpired;

   @FindBy(xpath = "(//div[@class='makeStyles-messageBubble-31 makeStyles-agentMessageBubble-32'])[2]")
    public WebElement defaultMsg2;




}
