package com.shopeasy.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        // GitHub Actions tự động set CI=true
        // Máy CI không có màn hình → bắt buộc headless
        boolean isCI = System.getenv("CI") != null;

        System.out.println("[DriverFactory] Browser: " + browser
                + " | CI mode: " + isCI);

        return switch (browser.toLowerCase()) {
            case "firefox" -> createFirefoxDriver(isCI);
            default        -> createChromeDriver(isCI);
        };
    }

    private static WebDriver createChromeDriver(boolean headless) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        if (headless) {
            // 3 dòng này BẮT BUỘC trên Linux CI
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");
            System.out.println("[Driver] Chrome HEADLESS");
        } else {
            options.addArguments("--start-maximized");
            System.out.println("[Driver] Chrome bình thường");
        }
        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver(boolean headless) {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        if (headless) {
            options.addArguments("-headless");
            System.out.println("[Driver] Firefox HEADLESS");
        }
        return new FirefoxDriver(options);
    }
}
