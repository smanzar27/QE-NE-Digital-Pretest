package com.ntuc.socialenterprises.qa.drivermanager;

public class DriverFactory {


    public  static DriverManager browserDriverManager;
    public  static DriverFactory driverFactory;

    public  static  DriverFactory getInstance( ) {
        driverFactory = new DriverFactory();
        return driverFactory;
    }

    DriverFactory() { }

    public DriverManager getDriverManager(String driverType){
        switch (DriverType.valueOf(driverType)){
            case CHROME: return browserDriverManager = new ChromeDriverManager();
            case FIREFOX: System.out.println("FIREFOX PLACE HOLDER");
            default: throw new RuntimeException("INVALID DRIVER: " +  driverType);
        }
    }
}

enum DriverType {
    FIREFOX,
    CHROME;

    DriverType() {}
}

enum ExecutionLocation {
    LOCAL,
    REMOTE,
}