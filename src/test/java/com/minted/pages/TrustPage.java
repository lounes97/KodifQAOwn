package com.minted.pages;

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

    //@FindBy(xpath = "//p[contains(text(),'Is there anything else I can assist you with?')]")
    //public WebElement anythingElseMsg;


    @FindBy(xpath = "//a[contains(text(),'here')]")
    public WebElement here;

    @FindBy(css = "svg[data-testid='RefreshIcon']")
    public WebElement refreshIcon;

    //@FindBy(css = "svg[data-testid='ThumbDownIcon']")
    @FindBy(xpath = "//*[@data-testid='ThumbDownIcon']")
    public WebElement thumbDownIcon;

    // @FindBy(xpath = "(//button[contains(@class,'MuiButtonBase-root')])[2]")
    //@FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[2]")
    // @FindBy(xpath = "//*[name()='path' and contains(@d,'M15 3H6c-.')]")
    @FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[2]")
    public WebElement redThumbDownIcon;

    //@FindBy(css = "svg[data-testid='ThumbUpIcon']")
    @FindBy(xpath = "//*[@data-testid='ThumbUpIcon']")
    public WebElement thumbUpIcon;

    // @FindBy(css = "span[class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root']:first-child")
    //@FindBy(xpath = "//*[name()='path' and contains(@d,'M1 21h4V9H')]")
    @FindBy(xpath = "(//span[@class='MuiTouchRipple-root css-8je8zh-MuiTouchRipple-root'])[1]")
    public WebElement greenThumbUpIcon;

    @FindBy(xpath = "(//p[contains(@class,'MessageTime')])[2]")
    public WebElement sendMsgTime;

    @FindBy(xpath = "(//p[contains(@class,'MessageTime')])[3]")
    public WebElement responseMsgTime;

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

    @FindBy(xpath = "//div[contains(text(),'GIT COMMANDS.docx')]")
    public WebElement uploadedFile;
    @FindBy(xpath = "//div[contains(text(),'What is wallet')]")
    public WebElement uploadWalletText;

    @FindBy(css="input[type='file']")
    public WebElement fileInput;




}
