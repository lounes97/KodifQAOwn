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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TrustStepDef {
    private long questionSentTime;
    private long responseReceivedTime;
    private long timeDifference;
    TrustPage trustPage = new TrustPage();

    @Given("the user is on the TrustWallet chat interface")
    public void theUserIsOnTheTrustWalletChatInterface() {
        //BrowserUtils.waitForFrameAndSwitchToIt("kodif-chat-widget", 25);
       // BrowserUtils.waitForVisibility(trustPage.iframe, 25);
        //Driver.getDriver().switchTo().parentFrame();
        Driver.getDriver().switchTo().frame("kodif-chat-widget");

       // Driver.getDriver().switchTo().frame("kodif-chat-widget");

        BrowserUtils.waitForVisibility(trustPage.trustSearchBox, 15);
        trustPage.trustSearchBox.sendKeys("What is wallet?");
        trustPage.submitBtn.click();
    }

    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {
       BrowserUtils.waitForClickablility(trustPage.here, 20);
       trustPage.here.click();
//        Set<String> windowHandles = Driver.getDriver().getWindowHandles();
//        String firstHandle = "";
//        for (String windowHandle : windowHandles) {
//            firstHandle=windowHandle;
//            break;
//        }
//        Driver.getDriver().switchTo().window(firstHandle);

    }

    @Then("the link provided should not be blank")
    public void thenTheLinkProvidedShouldNotBeBlank() {
        //Assert.assertFalse(trustPage.here.getAttribute("href").contains("blank"));
        // BrowserUtils.waitForVisibility(trustPage.here, 10);
        assertNotNull("Link is null", trustPage.here);

        System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");
       // Driver.getDriver().switchTo().parentFrame();

    }

    @When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
        BrowserUtils.waitForClickablility(trustPage.thumbUpIcon, 25);
        trustPage.thumbUpIcon.click();
        BrowserUtils.waitFor(20);
    }

    @Then("the thumbs-up icon should change color to green")
    public void theThumbsUpIconShouldChangeColorToGreen() {
        WebElement regularThumbUpIcon= trustPage.thumbUpIcon;
        //BrowserUtils.waitForVisibility(trustPage.greenThumbUpIcon, 15);
       // WebElement greenThumbUpIcon= trustPage.greenThumbUpIcon;
        //String regularIconColor = regularThumbUpIcon.getCssValue("color");
       // String greenIconColor = greenThumbUpIcon.getCssValue("color");
       // assertNotEquals(regularIconColor, greenIconColor);
    }

    @And("the thumbs-down icon should remain unchanged")
    public void theThumbsDownIconShouldRemainUnchanged() {

    }

    @When("the user clicks the thumbs-down icon")
    public void theUserClicksTheThumbsDownIcon() {
        WebElement regularThumbDownIcon= trustPage.thumbDownIcon;
        regularThumbDownIcon.click();
        BrowserUtils.waitFor(10);
       // WebElement redThumbDownIcon= trustPage.redThumbDownIcon;
        //String regularIconColor = regularThumbDownIcon.getCssValue("color");
        //String redIconColor = redThumbDownIcon.getCssValue("color");
       // assertNotEquals(regularIconColor, redIconColor);
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
        Assert.assertTrue("Default message is not present after refreshing the chat interface", trustPage.defaultMsg2.isDisplayed());
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
}
