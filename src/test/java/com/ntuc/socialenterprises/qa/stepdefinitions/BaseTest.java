package com.ntuc.socialenterprises.qa.stepdefinitions;

import com.ntuc.socialenterprises.qa.configmanager.ReaderManager;
import com.ntuc.socialenterprises.qa.drivermanager.DriverFactory;
import com.ntuc.socialenterprises.qa.drivermanager.DriverManager;
import com.ntuc.socialenterprises.qa.pageobjectmanager.PageObjectManager;

public class BaseTest {

    private final DriverManager driverManager;
    private final PageObjectManager pageObjectManager;

    public BaseTest() throws Exception {

        System.out.println("Test Base Setting Started");
        String browserName = ReaderManager.getInstance().getGUIConfigReader().getBrowser();
        System.out.println( "Running Browser: " + browserName);
        driverManager = DriverFactory.getInstance().getDriverManager(browserName);
        pageObjectManager = new PageObjectManager(driverManager.getWebDriver());
        System.out.println("Test Base Setting Completed");
    }

    public DriverManager getWebDriverManager() { return driverManager; }

    public PageObjectManager getPageObjectManager() { return pageObjectManager; }
}
