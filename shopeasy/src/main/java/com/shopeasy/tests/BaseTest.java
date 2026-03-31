package com.shopeasy.tests;

import com.shopeasy.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://www.saucedemo.com";

    @BeforeMethod
    public void setUp() {
        String browser = System.getProperty("browser", "chrome");
        driver = DriverFactory.createDriver(browser);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
