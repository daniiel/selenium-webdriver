package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setupDriver() throws MalformedURLException {

        // BROWSER : [chrome, firefox, etc..]
        // HUB_HOST : [localhost, IP (10.0.0.2), hostname]

        DesiredCapabilities capabilities = DesiredCapabilities.chrome();

        if (System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("Firefox")) {
            capabilities = DesiredCapabilities.firefox();
        }

        String host = System.getProperty("HUB_HOST") == null ?  "localhost" : System.getProperty("HUB_HOST");

        StringBuilder sbUrl = new StringBuilder("http://");
        sbUrl.append(host).append(":").append("4444").append("/wd/hub");

        this.driver = new RemoteWebDriver(new URL(sbUrl.toString()), capabilities);
    }

    @AfterTest
    public void quitBrowser() {
        this.driver.quit();
    }

}
