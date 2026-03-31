package com.shopeasy.tests;

import com.shopeasy.driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected WebDriver driver;
    protected static final String BASE_URL = "https://www.saucedemo.com";

    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) {
        // Ưu tiên System Property từ Maven (-Dbrowser=)
        // Nếu không có thì dùng giá trị từ testng.xml
        String browserToUse = System.getProperty("browser", browser);

        System.out.println("[BaseTest] Khởi động browser: " + browserToUse);
        driver = DriverFactory.createDriver(browserToUse);
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
