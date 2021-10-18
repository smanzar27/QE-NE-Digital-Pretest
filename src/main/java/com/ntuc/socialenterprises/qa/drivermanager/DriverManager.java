package com.ntuc.socialenterprises.qa.drivermanager;

import com.ntuc.socialenterprises.qa.configmanager.ReaderManager;
import com.ntuc.socialenterprises.qa.exception.InvalidUserInputException;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class DriverManager {

    protected WebDriver driver;
    protected abstract WebDriver createWebDriver();
    protected abstract void setDefaultCapabilities();

    public void quitDriver(){ if(null != driver) { driver.close(); driver.quit(); } }

    public WebDriver getWebDriver(){ if(null == driver) createWebDriver(); return driver; }

    public String getTitle(){ return driver.getTitle(); }
    public String getCurrentURL(){ return driver.getCurrentUrl(); }

    public void maximizeWindowWebDriver(){ driver.manage().window().maximize(); }

    public Duration setDefaultImplicitWaitTime()  {  return Duration.ofSeconds(ReaderManager.getInstance().getGUIConfigReader().getDefaultImplicitWaitTime()); }
    public void includeImplicitWait() throws InvalidUserInputException { driver.manage().timeouts().implicitlyWait(setDefaultImplicitWaitTime()); }

    public void navigateToApplicationURL()  {  driver.navigate().to(constructURL()); }

    public URL constructURL()  {
        String urlString = null;
        try {
            urlString=ReaderManager.getInstance().getGUIConfigReader().getApplicationWebURL();
            return new URL(urlString);
        }   catch (Exception ex) {
            throw new RuntimeException("INVALID  URL: " + urlString);
        }
    }

    public void onFailureTakeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.log(scenario.getName()+ " Failed");
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
    }
}
