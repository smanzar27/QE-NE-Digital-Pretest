package com.ntuc.socialenterprises.qa.stepdefinitions;


import com.ntuc.socialenterprises.qa.drivermanager.DriverManager;
import com.ntuc.socialenterprises.qa.utilspackage.Constant;
import com.ntuc.socialenterprises.qa.utilspackage.FileOperation;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;

import java.util.List;


public class Hooks {

    DriverManager driverManager;
    boolean isGUI;

    public Hooks(BaseTest baseTest){
        driverManager = baseTest.getWebDriverManager();
    }

    @Before
    public void beforeScenario(Scenario scenario)  throws Exception {

        scenario.log("STARTING TEST: " + scenario.getName());
        System.out.println(scenario.getSourceTagNames());
        isGUI = scenario.getSourceTagNames().contains("@GUI");

        //scenario.log("Thread ID STARTED: " + String.valueOf(Thread.currentThread().getId()));


        if (isGUI) {
            driverManager.getWebDriver();
            driverManager.maximizeWindowWebDriver();
            driverManager.includeImplicitWait();
        }
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (isGUI)  driverManager.quitDriver();
        scenario.log(("COMPLETE TEST: " + scenario.getName()));
    }

    @BeforeStep
    public void beforeStep(Scenario scenario)  {

        FileOperation.createFile(Constant.stepFileName);

    }

    @AfterStep
    public void afterStep(Scenario scenario){

        if (isGUI) driverManager.onFailureTakeScreenShot(scenario);
        List<String> listStringLine = FileOperation.readFile(Constant.stepFileName);
        listStringLine.forEach(scenario::log);
        FileOperation.deleteFile(Constant.stepFileName);

    }

}
