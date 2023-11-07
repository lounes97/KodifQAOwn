package com.minted.steps;

import com.minted.pages.TrustPage;
import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.File;

import static org.junit.Assert.*;

public class TrustStepDef {
    private long questionSentTime;
    private long responseReceivedTime;
    private long timeDifference;
    TrustPage trustPage = new TrustPage();

    @Given("the user is on the TrustWallet chat interface")
    public void theUserIsOnTheTrustWalletChatInterface() {

        Driver.getDriver().switchTo().frame("kodif-chat-widget");
        BrowserUtils.waitForVisibility(trustPage.trustSearchBox, 20);
        trustPage.trustSearchBox.sendKeys("What is wallet?");
        trustPage.submitBtn.click();

    }

    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {

        BrowserUtils.waitForClickablility(trustPage.here, 25);
        trustPage.here.click();

    }

    @Then("the link provided should not be blank")
    public void thenTheLinkProvidedShouldNotBeBlank() {


        assertNotNull("Link is null", trustPage.here);
        assertFalse("Link href is blank", trustPage.here.getAttribute("href").isEmpty());

        System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");


    }

    @When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
        BrowserUtils.waitForClickablility(trustPage.thumbUpIcon, 25);
        trustPage.thumbUpIcon.click();
        BrowserUtils.waitFor(20);
    }

    @Then("the thumbs-up icon should change color to green")
    public void theThumbsUpIconShouldChangeColorToGreen() {
        WebElement regularThumbUpIcon = trustPage.thumbUpIcon;
        BrowserUtils.waitForVisibility(trustPage.greenThumbUpIcon, 25);
        WebElement greenThumbUpIcon= trustPage.greenThumbUpIcon;
        String regularIconColor = regularThumbUpIcon.getCssValue("color");
        String greenIconColor = greenThumbUpIcon.getCssValue("color");
        assertNotEquals(regularIconColor, greenIconColor);
    }

    @And("the thumbs-down icon should remain unchanged")
    public void theThumbsDownIconShouldRemainUnchanged() {

    }

    @When("the user clicks the thumbs-down icon")
    public void theUserClicksTheThumbsDownIcon() {
        WebElement regularThumbDownIcon = trustPage.thumbDownIcon;
        regularThumbDownIcon.click();
        BrowserUtils.waitFor(15);
        WebElement redThumbDownIcon = trustPage.redThumbDownIcon;
        String regularIconColor = regularThumbDownIcon.getCssValue("color");
        String redIconColor = redThumbDownIcon.getCssValue("color");
        assertNotEquals(regularIconColor, redIconColor);
        System.out.println("***\n\n\n" + regularIconColor + "\n\n\n" + redIconColor + "\n\n\n***");
    }

    @Then("the thumbs-down icon should change color to red")
    public void theThumbsDownIconShouldChangeColorToRed() {

    }

    @And("the thumbs-up icon should remain unchanged")
    public void theThumbsUpIconShouldRemainUnchanged() {
    }

    @When("the user clicks the refresh button")
    public void theUserClicksTheRefreshButton() {
        trustPage.refreshIcon.click();
        BrowserUtils.waitFor(10);
    }

    @Then("the chat interface should reload and clear the previous response")
    public void theChatInterfaceShouldReloadAndClearThePreviousResponse() {
    }

    @Then("check for the presence of the default message")
    public void checkForThePresenceOfTheDefaultMessage() {
        Assert.assertTrue("***\n\n\nDefault message is not present after refreshing the chat interface\n\n\n***", trustPage.defaultMsg2.isDisplayed());
    }

    @When("the user records the time the question was sent")
    public void theUserRecordsTheTimeTheQuestionWasSent() {
        // Record the current time when the question is sent
        questionSentTime = System.currentTimeMillis();

    }

    @And("records the time the response was received")
    public void recordsTheTimeTheResponseWasReceived() {
        // Record the current time when the response is received
        responseReceivedTime = System.currentTimeMillis();
    }

    @Then("the time difference between sending and receiving should be calculated")
    public void theTimeDifferenceBetweenSendingAndReceivingShouldBeCalculated() {
        // Calculate the time difference between sending and receiving
        timeDifference = responseReceivedTime - questionSentTime;
        System.out.println("\n\n\n****timeDifference  = " + timeDifference + "\n\n\n***");
        String times = trustPage.sendMsgTime.getText();

    }


    @And("the calculated time difference should be within an acceptable threshold")
    public void theCalculatedTimeDifferenceShouldBeWithinAnAcceptableThreshold() {
        long acceptableThreshold = 25000;

        if (timeDifference > acceptableThreshold) {
            throw new AssertionError("Time difference exceeds the acceptable threshold.");

        }
    }

    @Given("the user is on the chat interface")
    public void theUserIsOnTheChatInterface() {
    }

    @When("the user clicks the attachment button")
    public void theUserClicksTheAttachmentButton() {
        BrowserUtils.waitForVisibility(trustPage.attachFileIcon, 15);
        trustPage.attachFileIcon.click();
        BrowserUtils.waitFor(10);
    }

    @Then("a file attachment dialog should appear")
    public void aFileAttachmentDialogShouldAppear() {
    }

    @When("the user clicks the emoji button")
    public void theUserClicksTheEmojiButton() {
        BrowserUtils.waitForVisibility(trustPage.emojiBtn, 15);
        trustPage.emojiBtn.click();
        BrowserUtils.waitFor(10);
    }

    @Then("an emoji selection dialog should appear")
    public void anEmojiSelectionDialogShouldAppear() {
    }

    String path;
    String fileName;

    @When("the user selects a .docx file to attach")
    public void theUserSelectsAFileToAttach() throws AWTException {

        // path = "/Users/adilyadanil/IdeaProjects/KodifQAOwn/attachments/What is wallet.docx";
        path = System.getProperty("user.dir")+ File.separator +"attachments"+File.separator+"Attachment.docx";

        int i = path.lastIndexOf(File.separator);
        int j = path.lastIndexOf(".");
        fileName = path.substring(i + 1, j);
        StringSelection str = new StringSelection(path);

        WebElement fileInput = Driver.getDriver().findElement(By.cssSelector("input[type='file']"));
        fileInput.sendKeys(path);
//
//        Robot robot = new Robot();
//        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//
//        // cmd + tab is needed since it launches a java app and the browser looses focus
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_TAB);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        //open goto window
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_SHIFT);
//        robot.keyPress(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        //paste the clipboard value
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.delay(500);
//
//        //Press Enter key twice to close the Goto window and Upload window
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(500);
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);

        BrowserUtils.waitForPresenceOfElement(By.xpath("//div[contains(text(),'" + fileName + "')]"),10);
        BrowserUtils.waitFor(10);

    }

    @Then("file is successfully attached")
    public void fileIsSuccessfullyAttached() {
        WebElement attachedDoc = Driver.getDriver().findElement(By.xpath("//div[contains(text(),'" + fileName + "')]"));
        Assert.assertTrue(attachedDoc.isDisplayed());
    }

}

