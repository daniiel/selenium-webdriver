package com.config;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected WebDriver driver;

    // Environment variable defined in docker-compose
    public static final String DRIVER_PATH_ENV_VAR = "DRIVER_PATH";

    protected abstract void createWebDriver();

    public WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }
}
