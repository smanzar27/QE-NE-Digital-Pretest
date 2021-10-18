package com.ntuc.socialenterprises.qa.stepdefinitions.number;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ArithmeticOperationStep {

    int numberOne,numberTwo;
    int actualNumber;
    @Given("^the user passes two input numbers: (.*) and (.*)$")
    public void inputNumbers(int numberOne, int numberTwo){
        this.numberOne=numberOne;
        this.numberTwo=numberTwo;
    }

    @When("^the user performs (:?addition) operation on numbers$")
    public void numberOperation(String operation) {
        switch(operation) {
            case "addition": actualNumber = numberOne + numberTwo; break;
            case "multiplication": actualNumber = numberOne * numberTwo; break;
            case "subtraction": actualNumber = numberOne - numberTwo; break;
        }
    }

    @Then("^the user validate (:?addition) result$")
    public void validateOperation(String operation) {
        switch (operation) {
            case "addition": Assert.assertEquals(actualNumber, numberOne + numberTwo); break;
            case "multiplication": Assert.assertEquals(actualNumber, numberOne * numberTwo); break;
            case "subtraction": Assert.assertEquals(actualNumber, numberOne - numberTwo); break;
        }
    }
}
