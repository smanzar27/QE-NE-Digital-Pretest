package com.ntuc.socialenterprises.qa.drivermanager;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    ChromeOptions chromeOptions = new ChromeOptions();

    ChromeDriverManager() { }

    @Override
    protected WebDriver createWebDriver() {
        this.setDefaultCapabilities();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        return driver;
    }

    @Override
    protected void setDefaultCapabilities() {
        this.chromeOptions.addArguments("disable-infobars");
        this.chromeOptions.addArguments("--disable-notification");
        this.chromeOptions.addArguments("disable-extension");
        this.chromeOptions.addArguments("start-maximized");
    }
}
