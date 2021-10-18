package com.ntuc.socialenterprises.qa.stepdefinitions.string;

import io.cucumber.java.en.When;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StringOperationStep {

    String originalString = "Testing is fun";
    String expectedString = "TESTING IS FUN";

    @When("^UpperCase Operation$")
    public void TestToUpperCase() { Assert.assertEquals(originalString.toUpperCase(), expectedString); }

    @When("^LowerCase Operation$")
    public void TestToLowerCase() { Assert.assertEquals(originalString.toLowerCase(), expectedString.toLowerCase()); }

    @When("^SubString Operation$")
    public void TestSubstring()
    {
        String originalText = "Isuru Uyanage";
        String substringText = originalText.substring(2, 5);
        String expected = "uru";
        Assert.assertEquals(substringText, expected);
    }

}
