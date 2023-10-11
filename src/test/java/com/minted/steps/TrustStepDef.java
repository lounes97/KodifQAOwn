package com.minted.steps;

import com.minted.pages.TrustPage;
import com.minted.utility.BrowserUtils;
import com.minted.utility.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrustStepDef {
     TrustPage trustPage = new TrustPage();
    @When("user ask a question")
    public void user_ask_a_question() {
        Driver.getDriver().switchTo().frame("kodif-chat-widget");
        //BrowserUtils.waitForVisibility(trustPage.trustSearchBox, 15);
    trustPage.trustSearchBox.sendKeys("What is wallet?");
    trustPage.submitBtn.click();
    }
    @When("if chat will provide answer with a link to the related article")
    public void if_chat_will_provide_answer_with_a_link_to_the_related_article() {
        BrowserUtils.waitForClickablility(trustPage.here,15);
            trustPage.here.click();
        }

    @Then("link should not be blank")
    public void link_should_not_be_blank() {
        Assert.assertFalse(trustPage.here.getAttribute("href").contains("blank"));
        System.out.println("\n\n\n" + trustPage.here.getAttribute("href").toString() + "\n\n\n");

    }

}
