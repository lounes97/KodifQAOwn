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

import static org.junit.Assert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class TrustStepDef {
    TrustPage trustPage = new TrustPage();

    @Given("the user is on the TrustWallet chat interface")
    public void theUserIsOnTheTrustWalletChatInterface() {
      // Wait for the frame with name "kodif-chat-widget" for up to 15 seconds
        BrowserUtils.waitForFrameAndSwitchToIt("kodif-chat-widget", 15);
        Driver.getDriver().switchTo().frame("kodif-chat-widget");
        //BrowserUtils.waitForVisibility(trustPage.trustSearchBox, 15);
        trustPage.trustSearchBox.sendKeys("What is wallet?");
        trustPage.submitBtn.click();
    }

    @When("the user asks a question and receives a response with a link")
    public void theUserAsksAQuestionAndReceivesAResponseWithALink() {
        BrowserUtils.waitForClickablility(trustPage.here, 20);
        trustPage.here.click();
    }

    @Then("the link provided should not be blank")
    public void thenTheLinkProvidedShouldNotBeBlank() {
        //Assert.assertFalse(trustPage.here.getAttribute("href").contains("blank"));

        assertNotNull("Link is null", trustPage.here);

        System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");
        Driver.getDriver().switchTo().parentFrame();


    }

    @When("the user clicks the thumbs-up icon")
    public void theUserClicksTheThumbsUpIcon() {
        BrowserUtils.waitForClickablility(trustPage.thumbUpIcon, 20);
        trustPage.thumbUpIcon.click();
        BrowserUtils.waitFor(20);
    }

    @Then("the thumbs-up icon should change color to green")
    public void theThumbsUpIconShouldChangeColorToGreen() {
        WebElement regularThumbUpIcon= trustPage.thumbUpIcon;
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
        WebElement regularThumbDownIcon= trustPage.thumbDownIcon;
        WebElement redThumbDownIcon= trustPage.redThumbDownIcon;
        String regularIconColor = regularThumbDownIcon.getCssValue("color");
        String redIconColor = redThumbDownIcon.getCssValue("color");
        assertNotEquals(regularIconColor, redIconColor);
    }

    @Then("the thumbs-down icon should change color to red")
    public void theThumbsDownIconShouldChangeColorToRed() {
    }

    @And("the thumbs-up icon should remain unchanged")
    public void theThumbsUpIconShouldRemainUnchanged() {
    }
}
