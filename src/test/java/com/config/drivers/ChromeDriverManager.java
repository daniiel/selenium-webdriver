package com.config.drivers;

import com.config.DriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    // Use it for local testing, this path can be changed to where the driver is located
    private static final String DEFAULT_DRIVER_PATH = "C:\\docker\\udemy\\webdrivers\\chromedriver.exe";

    @Override
    protected void createWebDriver() {
        String path = System.getenv(DRIVER_PATH_ENV_VAR);
        System.setProperty("webdriver.chrome.driver", path == null ? DEFAULT_DRIVER_PATH : path);
        ChromeOptions options = new ChromeOptions();

        // For linux environments, no GUI is required, comment the if condition if you want to test
        // without opening the chrome window in Windows environment
        if(path != null) {
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        this.driver = new ChromeDriver(options);
    }
}
