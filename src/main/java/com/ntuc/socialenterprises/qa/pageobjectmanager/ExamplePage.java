package com.ntuc.socialenterprises.qa.pageobjectmanager;

import com.ntuc.socialenterprises.qa.basepackage.BaseWebBrowserService;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ExamplePage extends BaseWebBrowserService {

    WebDriver driver;

    public ExamplePage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "developer-name")
    protected WebElement textFieldDeveloperName;
    @FindBy(how = How.ID, using = "submit-button")
    protected WebElement buttonSubmit;
    @FindBy(how = How.ID, using = "comments")
    protected WebElement textAreaComment;
    @FindBy(how = How.ID, using = "slider")
    protected WebElement sliderRatingScale;
    @FindBy(how = How.ID, using = "tried-test-cafe")
    protected WebElement checkboxTestCafe;
    @FindBy(how = How.ID, using = "preferred-interface")
    protected WebElement dropdownInterface;
    @FindBy(how = How.ID, using = "populate")
    protected WebElement buttonPopulate;

    @FindBy(how = How.XPATH, using = "//div[@class='slider-value']")
    protected List<WebElement> sliderRatingValues;
    @FindBy(how = How.XPATH, using = "//legend[contains(text(),'Which features are important to you:')]//parent::fieldset//label")
    protected List<WebElement> checkboxFeatureList;
    @FindBy(how = How.XPATH, using = "//legend[contains(text(),'What is your primary Operating System:')]//parent::fieldset//label")
    protected List<WebElement> radioOSList;
    @FindBy(how = How.XPATH, using = "//span[contains(@class,'ui-slider-handle')]")
    protected WebElement sliderElement;



    public static class TextMap {

        public static String defaultPageTitle = "TestCafe Example Page";
        public static String defaultDeveloper = "Peter Parker";
        public static String popUp = "Reset information before proceeding?";

    }

    public void setDeveloperName(String userInput) {
        setString(textFieldDeveloperName, userInput);
    }

    public String getDeveloperName() {
        return getAttributeValue(textFieldDeveloperName,"value");
    }

    public void clearDeveloperName() {
        clearString(textFieldDeveloperName);
        textFieldDeveloperName.sendKeys(Keys.BACK_SPACE);
    }

    public void clickSubmit() {
      if(buttonSubmit.isEnabled())  clickOperation(buttonSubmit);
      else throw new RuntimeException("No");
    }

    public boolean isButtonEnable() {
        return isElementEnabled(buttonSubmit);
    }

    public boolean isCommentEnable() {
        return isElementEnabled(textAreaComment);
    }

    public void setRatingComment(String stringComment) { setString(textAreaComment,stringComment); }

    public boolean isRatingEnable() {
        String attributeValue = getAttributeValue(sliderRatingScale, "class");
        System.out.println("Submit Attribute Value: " + attributeValue);
        return attributeValue.contains("ui-slider-disabled ui-state-disabled");
    }

    public String isFeaturePresent(String importantFeature) {
        return getString(presenceOfWebElementInList(checkboxFeatureList, importantFeature));
    }

    public WebElement getCheckboxWebElement(List<WebElement> elementList, String checkboxString){
        return presenceOfWebElementInList(elementList, checkboxString).findElement((By.tagName("input")));
    }

    public void clickFeature(String importantFeature) {
        clickOperation(getCheckboxWebElement(checkboxFeatureList,importantFeature));
    }

    public boolean isFeatureClicked(String importantFeature) {
        return isElementSelected(getCheckboxWebElement(checkboxFeatureList,importantFeature));
    }

    public String isOSPresent(String osType) {
        return getString(presenceOfWebElementInList(radioOSList, osType));
    }

    public void clickOSClicked(String osType) {
        clickOperation(getCheckboxWebElement(radioOSList,osType));
    }

    public boolean isOSClicked(String osType) {
        return isElementSelected(getCheckboxWebElement(radioOSList,osType));
    }

    public boolean isInterfacePresent(String interfaceType) {
        return isDropdownOptionPresent(dropdownInterface, interfaceType);
    }

    public void selectInterface(String interfaceType) {
        selectDropdownOption(dropdownInterface, interfaceType);
    }

    public String selectedInterface(String interfaceType) {
        return isDropdownOptionSelected(dropdownInterface);
    }

    public void checkTestCafe() {
        clickOperation(checkboxTestCafe);
    }

    public boolean isAllRatingOptionsDisplayed() {
        Integer noOfRating = sliderRatingValues.size();
        if (!noOfRating.equals(10))
            throw new RuntimeException("1-10 OPTIONS NOT AVAILABLE only " + noOfRating + " options available");
        return true;
    }

    public void clickRatingAndComment(int ratingNumber, String ratedString) {

        Actions action = new Actions(driver);
        clickOperation(sliderElement);
        for (int i=1; i<ratingNumber; i++)
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();
        setRatingComment(ratedString);
    }

    public String validateRatingAndComment(String elementType){

        if(elementType.equals("comment")) return getAttributeValue(textAreaComment,"value");
        if(elementType.equals("rating")) {
            String rateValue = getAttributeValue(sliderElement, "style").split(":")[1].trim();
            if(rateValue.charAt(0)=='1' && rateValue.charAt(1)=='0') return "10";
            if(rateValue.charAt(0)=='0') return "1";
            switch (rateValue.charAt(0)) {
                case '1' :  return "2";
                case '2' :  return "3";
                case '3' :  return "4";
                case '4' :  return "5";
                case '5' :  return "6";
                case '6' :  return "7";
                case '7' :  return "8";
                case '8' :  return "9";
                default  :  return (rateValue);
            }
        }
        throw new RuntimeException("element is not rating or comment type");
    }

    public void clickPopulateButton(){
        clickOperation(buttonPopulate);
    }

    public void handlingPopUp(){
        if(!driver.switchTo().alert().getText().contains(TextMap.popUp))
            throw new RuntimeException("Pop up message not displayed correctly");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }
}
