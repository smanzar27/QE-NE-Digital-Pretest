package com.ntuc.socialenterprises.qa;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        plugin = {  "pretty"
                    ,"html:target/cucumber"
                    ,"json:target/cucumber.json"
                    ,"junit:target/cucumber.xml"
                    ,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
        ,   features = "src/test/resources/features"
        ,   glue = {"com.ntuc.socialenterprises.qa.stepdefinitions"}
        ,   tags = "@TC"
        ,   monochrome = true
)

public class CucumberRunner extends AbstractTestNGCucumberTests {

 /*   @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

}
