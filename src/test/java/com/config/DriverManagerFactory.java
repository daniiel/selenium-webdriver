package com.config;

import com.config.drivers.ChromeDriverManager;
import com.config.drivers.FirefoxDriverManager;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType driverType) {

        DriverManager driverManager;

        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:
                throw new UnsupportedOperationException("Not supported driver");
        }

        return driverManager;
    }


}
