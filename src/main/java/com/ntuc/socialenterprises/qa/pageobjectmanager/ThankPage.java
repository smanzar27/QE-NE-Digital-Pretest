package com.ntuc.socialenterprises.qa.pageobjectmanager;

import com.ntuc.socialenterprises.qa.basepackage.BaseWebBrowserService;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ThankPage extends BaseWebBrowserService {

    WebDriver driver;
    public ThankPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(how = How.ID, using = "article-header")
    protected WebElement stringThankMessage;
    @FindBy(how = How.LINK_TEXT, using = "devexpress.github.io/testcafe")
    protected WebElement linkTestCafe;



    public static class TextMap {
        public static String defaultPageTitle="Thank you!";
        public static String stringThanks="Thank you, ";
        public static String testCafePageTitle="Cross-Browser End-to-End Testing Framework | TestСafe";

    }

    public String getThanksMessage(){  return getString(stringThankMessage); }

    public void clickHyperLink(){ clickOperation(linkTestCafe);}
}
