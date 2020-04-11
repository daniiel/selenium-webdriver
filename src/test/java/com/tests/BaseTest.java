package com.tests;

import com.config.DriverManagerFactory;
import com.config.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver; // children class access

    @BeforeTest
    public void setupDriver() {
        this.driver = DriverManagerFactory.getDriverManager(DriverType.CHROME).getWebDriver();
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }

}
