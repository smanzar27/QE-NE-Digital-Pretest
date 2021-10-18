package com.ntuc.socialenterprises.qa.stepdefinitions.testcafe;

import com.ntuc.socialenterprises.qa.drivermanager.DriverManager;
import com.ntuc.socialenterprises.qa.pageobjectmanager.ThankPage;
import com.ntuc.socialenterprises.qa.stepdefinitions.BaseTest;
import com.ntuc.socialenterprises.qa.utilspackage.HardAssertion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ThankStep {

    DriverManager driverManager;
    ThankPage thankPage;

    public ThankStep(BaseTest baseTest) {
        driverManager = baseTest.getWebDriverManager();
        thankPage   = baseTest.getPageObjectManager().getThankPage();
    }

    @Given("the user validate thank you webpage title")
    public void loadApplicationPage(){
        HardAssertion.assertCompareString(driverManager.getTitle(), ThankPage.TextMap.defaultPageTitle, "Page Title - " + ThankPage.TextMap.defaultPageTitle);
    }

    @Then("^the user validates message on thank page for (.+)$")
    public void validateThanksMessage(String stringName){
        stringName=ThankPage.TextMap.stringThanks + stringName + "!";
        HardAssertion.assertCompareString(thankPage.getThanksMessage(),stringName,"Name Matched on Thank Page");
    }

    @When("the user click on href link for more detail TestCafe Application")
    public void validateMoreMessage(){
        thankPage.clickHyperLink();
    }

    @Given("the user validate TestCafe Web Application webpage title")
    public void loadTestCafePage(){
        HardAssertion.assertCompareString(driverManager.getTitle(), ThankPage.TextMap.testCafePageTitle, "Page Title - " + ThankPage.TextMap.testCafePageTitle);
    }
}
