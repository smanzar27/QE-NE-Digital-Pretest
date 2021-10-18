package com.ntuc.socialenterprises.qa.basepackage;

import com.ntuc.socialenterprises.qa.configmanager.ReaderManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class BaseWebBrowserService {

    WebDriver driver;
    public BaseWebBrowserService(WebDriver driver) {
        this.driver=driver; PageFactory.initElements(driver, this);
    }

    public void setString(WebElement element, String textString) { element.clear(); element.sendKeys(textString); }

    public String getString(WebElement element) {
       return element.getText();
    }
    public void clearString(WebElement element) { element.clear(); }

    public String getAttributeValue(WebElement element,String attributeName) {
        if(isElementDisplayed(element)) return element.getAttribute(attributeName);
        return null;
    }

    public boolean isElementDisplayed(WebElement element) {  return element.isDisplayed(); }
    public boolean isElementSelected(WebElement element) {  return element.isSelected(); }
    public boolean isElementEnabled(WebElement element) {  return element.isEnabled(); }

    public void clickOperation(WebElement element) {if(element.isDisplayed()) element.click(); }

    public boolean validatePasswordField(WebElement element) { return element.getAttribute("type").equals("password"); }
    public void captureScreenshotByElement(WebElement element) {
        try {
            File file = element.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(file, new File("test.png"));
        } catch (IOException ex) { ex.printStackTrace(); }
    }

    public void scrollTillElementVisible(WebElement webElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public WebElement presenceOfWebElementInList(List<WebElement> webElementList, String searchString) {
        Optional<WebElement> webElement = webElementList.stream().filter(checkbox ->
                    getString(checkbox).equals(searchString)).findFirst();
            if (webElement.isPresent()) return webElement.get();
            else throw new RuntimeException("Web Element NOT Found for Search String: " + searchString);
    }

    public boolean isDropdownOptionPresent(WebElement webElement, String optionString) {
        Select select = new Select(webElement);
        List<WebElement> options = select.getOptions();
       for(WebElement option : options)
           if(option.getText().equals(optionString)) return true;
       return false;
    }

    public void selectDropdownOption(WebElement webElement, String optionString) {
        Select select = new Select(webElement);
        if(isDropdownOptionPresent(webElement,optionString))
            select.selectByVisibleText(optionString);
        else throw new RuntimeException("DROP DOWN OPTION NOT FOUND");
    }

    public String isDropdownOptionSelected(WebElement webElement) {
        Select select = new Select(webElement);
        return select.getFirstSelectedOption().getText();
    }

    protected void explicitWaitUntilInvisible(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ReaderManager.getInstance().getGUIConfigReader().getDefaultImplicitWaitTime()));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }
}
