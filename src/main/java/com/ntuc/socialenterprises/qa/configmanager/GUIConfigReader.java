package com.ntuc.socialenterprises.qa.configmanager;

import com.ntuc.socialenterprises.qa.exception.InvalidUserInputException;

import java.util.Properties;

public class GUIConfigReader  extends CommonConfigReader{

    private Properties properties;

    public GUIConfigReader(){
        super();
        properties=getProperties();
    }

    public String getBrowser() throws InvalidUserInputException {
        String browserName = properties.getProperty("browserName");
        if(browserName != null) return browserName.toUpperCase();
        else throw new InvalidUserInputException("browserName not specified in the configuration.properties file.");
    }

    public int getDefaultImplicitWaitTime()  {
        String implicitWait = properties.getProperty("implicitWait");
        if(implicitWait != null) return Integer.parseInt(implicitWait);
        else throw new RuntimeException("implicitWait not specified in the configuration.properties file.");
    }

    public String getApplicationWebURL() throws InvalidUserInputException {
        String applicationURL = properties.getProperty("guiApplicationURL");
        if(applicationURL != null) return applicationURL.toLowerCase();
        throw new InvalidUserInputException("Application URL not specified in the configuration.properties file.");
    }

    public long getDefaultPageLoadTime() {
        String pageLoadTime = properties.getProperty("pageLoadTime");
        if(pageLoadTime != null) return Long.parseLong(pageLoadTime);
        else throw new RuntimeException("pageLoadTime not specified in the configuration.properties file.");
    }

}
