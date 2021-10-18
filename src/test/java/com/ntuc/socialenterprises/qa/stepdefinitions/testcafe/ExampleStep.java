package com.ntuc.socialenterprises.qa.stepdefinitions.testcafe;

import com.ntuc.socialenterprises.qa.drivermanager.DriverManager;
import com.ntuc.socialenterprises.qa.pageobjectmanager.ExamplePage;
import com.ntuc.socialenterprises.qa.stepdefinitions.BaseTest;
import com.ntuc.socialenterprises.qa.utilspackage.HardAssertion;

import com.ntuc.socialenterprises.qa.utilspackage.SoftAssertion;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class ExampleStep {

    DriverManager driverManager;
    ExamplePage examplePage;

    public ExampleStep(BaseTest baseTest) {
        driverManager = baseTest.getWebDriverManager();
        examplePage   = baseTest.getPageObjectManager().getExamplePage();
    }

    @Given("the user open testcafe example webpage and validates page title")
    public void loadApplicationPage(){
        driverManager.navigateToApplicationURL();
        HardAssertion.assertCompareString(driverManager.getTitle(), ExamplePage.TextMap.defaultPageTitle, "Page Title - " + ExamplePage.TextMap.defaultPageTitle);
    }


    @When("^the user enters name as (.+)$")
    public void setNameField(String stringName) { examplePage.setDeveloperName(stringName); }

    @When("the user clear the name field")
    public void clearNameField() { examplePage.clearDeveloperName(); }

    @When("the user submit the example page")
    public void submitExamplePage() { examplePage.clickSubmit(); }


    @Then("^the user validates (:?submit|comment|rating) element is (:?enable|disable)$")
    public void validateElementEnabled(String action, String status){
        switch (action) {
            case "submit"   :   if(status.equals("disable"))    HardAssertion.assertFalse(examplePage.isButtonEnable(), "Submit Button Disable");
                                if(status.equals("enable"))     HardAssertion.assertTrue(examplePage.isButtonEnable(), "Submit Button Enable");
                                break;
            case "comment"  :   if(status.equals("disable"))    HardAssertion.assertFalse(examplePage.isCommentEnable(), "Comment Text Area Disable");
                                if(status.equals("enable"))     HardAssertion.assertTrue(examplePage.isCommentEnable(), "Comment Text Area Enable");
                                break;
            case "rating"   :   if(status.equals("disable"))    HardAssertion.assertTrue(examplePage.isRatingEnable(), "Rating Slider Disable");
                                if(status.equals("enable"))     HardAssertion.assertFalse(examplePage.isRatingEnable(), "Rating Slider Enable");
                                break;
            default         :   throw new RuntimeException("Invalid Action Type");
        }
    }

    @Then("the user click on TestCafe Checkbox")
    public void clickOperation(){ examplePage.checkTestCafe(); }

    @Then("^the user validates 1-10 rating options are displayed$")
    public void validateRatingOptions(){
        HardAssertion.assertTrue(examplePage.isAllRatingOptionsDisplayed(),"Rating value displayed from 1-10");
    }

    @And("^the user (:?select|verify) rating as (.+) and add comment$")
    public void selectRating(String action, String ratingValue){
        String ratedString = "Rated: " + ratingValue;
        int ratingNumber = Integer.parseInt(ratingValue);
        switch (action) {
            case "select"   :   examplePage.clickRatingAndComment(ratingNumber, ratedString);
                                break;
            case "verify"   :   HardAssertion.assertCompareString(examplePage.validateRatingAndComment("comment"),ratedString,"Rating Comment: " + ratedString);
                                HardAssertion.assertCompareString(examplePage.validateRatingAndComment("rating"),ratingValue,"Rating Value: " + ratingValue);
                                break;
            default         :   throw new RuntimeException("Invalid Action Type");
        }
    }

    @Given("the user validates {word} following important features")
    public void validateFeatureList(String action, DataTable dataTable) {
        SoftAssertion softAssertion = new SoftAssertion();
        for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
            String featureString=(String) data.get("featureList");

            switch (action) {
                case "find"     :   softAssertion.assertCompareString(examplePage.isFeaturePresent(featureString),featureString,"Feature Option - " + featureString);
                                    break;
                case "select" :     examplePage.clickFeature(featureString);
                                    break;
                case "selected" :   softAssertion.assertTrue(examplePage.isFeatureClicked(featureString),"Selected Feature - " + featureString);
                                    break;
                default         :   throw new RuntimeException("Invalid Action Type");
            }
        }
        softAssertion.assertAll();
    }

    @When("the user validates {word} following operating system")
    public void validateOperatingSystem(String action, DataTable dataTable) {
        SoftAssertion softAssertion = new SoftAssertion();
        for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
            String osString = (String) data.get("OSList");
            System.out.println(action);
            switch (action) {
                case "find"     :   softAssertion.assertCompareString(examplePage.isOSPresent(osString), osString, "OS Option - " + osString);
                                    break;
                case "select"   :   examplePage.clickOSClicked(osString);
                                    break;
                case "selected" :   softAssertion.assertTrue(examplePage.isOSClicked(osString),"Selected OS - " + osString);
                                    break;
                default         :   throw new RuntimeException("Invalid Action Type");
            }
        }
        softAssertion.assertAll();
    }

    @When("the user validates {word} following interface")
    public void validateInterface(String action, DataTable dataTable) {
        SoftAssertion softAssertion = new SoftAssertion();
        for (Map<Object, Object> data : dataTable.asMaps(String.class, String.class)) {
            String interfaceString = (String) data.get("interfaceList");
            System.out.println(interfaceString);
            switch (action) {
                case "find"     :   softAssertion.assertTrue(examplePage.isInterfacePresent(interfaceString),"Interface Option - " + interfaceString);
                                    break;
                case "select"   :   examplePage.selectInterface(interfaceString);
                                    break;
                case "selected" :   softAssertion.assertCompareString(examplePage.selectedInterface(interfaceString),interfaceString,"Interface Option - " + interfaceString);
                                    break;
                default         :   throw new RuntimeException("Invalid Action Type");
            }
        }
        softAssertion.assertAll();
    }


    @Then("^the user clicks on Populate button$")
    public void clickPopulateButton(){
        examplePage.clickPopulateButton();
    }
    @And("^the user validates the pop up message and clicks OK$")
    public void validatePopMessageAndClickOK(){
        examplePage.handlingPopUp();
    }

    @And("^the user validates the (:?entered|default) name is displayed as (.+)$")
    public void validateUserName(String userType, String userName){

        switch (userType) {
            case "entered"  :   HardAssertion.assertCompareString(examplePage.getDeveloperName(),userName," User Name - : " + userName);
                                break;
            case "default"  :   HardAssertion.assertCompareString(examplePage.getDeveloperName(),ExamplePage.TextMap.defaultDeveloper," User Name - : " + userName);
                                break;
            default         :   throw new RuntimeException("Invalid Action Type");
        }
    }
}
