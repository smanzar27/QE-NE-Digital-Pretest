package com.ntuc.socialenterprises.qa.configmanager;

import com.ntuc.socialenterprises.qa.exception.InvalidUserInputException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;


public class CommonConfigReader {

    private Properties properties;

    public CommonConfigReader(){
        properties=getProperties();
    }

    public Properties getProperties() {

        String propertyFilePath= Paths.get(System.getProperty("user.dir"),"src","test","resources").toString();
        String propertyFileName=Paths.get(propertyFilePath,"configuration.properties").toString();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyFileName));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("configuration.properties not found at " + propertyFileName);
        }
        return properties;
    }


}
