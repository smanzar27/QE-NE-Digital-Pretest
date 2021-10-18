package com.ntuc.socialenterprises.qa.pageobjectmanager;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;

    private ThankPage thankPage;
    private ExamplePage examplePage;

    public PageObjectManager(WebDriver driver) { this.driver = driver; }

    public ThankPage getThankPage(){ return (thankPage == null) ? thankPage = new ThankPage(driver) : thankPage; }
    public ExamplePage getExamplePage(){ return (examplePage == null) ? examplePage = new ExamplePage(driver) : examplePage; }

}
