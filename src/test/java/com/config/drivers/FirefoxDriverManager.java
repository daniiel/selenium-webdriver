package com.config.drivers;

import com.config.DriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {

    private static final String DEFAULT_DRIVER_PATH = "C:\\docker\\udemy\\webdrivers\\geckodriver.exe";

    @Override
    protected void createWebDriver() {
        String path = System.getenv(DRIVER_PATH_ENV_VAR);
        System.setProperty("webdriver.gecko.driver",path == null ? DEFAULT_DRIVER_PATH : path);
        FirefoxOptions options = new FirefoxOptions();
        this.driver = new FirefoxDriver(options);
    }
}
