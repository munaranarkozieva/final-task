package com.epam.training.munara_narkozieva.utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class WebDriverFactory {

    private static final Logger logger = LoggerFactory.getLogger(WebDriverFactory.class);
    private static final ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public static WebDriver getDriver(String browser) {
        if (driverThreadLocal.get() == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverThreadLocal.set(new ChromeDriver());
                    logger.info("ChromeDriver initialized for thread: " + Thread.currentThread().getId());
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    System.setProperty("webdriver.edge.driver", "/Users/user/webdrivers/msedgedriver");
                    EdgeOptions options = new EdgeOptions();
                    driverThreadLocal.set(new EdgeDriver(options));
                    logger.info("EdgeDriver initialized for thread: " + Thread.currentThread().getId());
                    break;
                default:
                    logger.error("Unsupported browser: " + browser);
                    throw new IllegalArgumentException("Unsupported browser: " + browser);
            }
        }
        return driverThreadLocal.get();
    }

            public static void quitDriver () {
                WebDriver driver = driverThreadLocal.get();
                if (driver != null) {
                    try {
                        logger.info("Closing driver for thread: " + Thread.currentThread().getId());
                        driver.quit();
                    } catch (Exception e) {
                        logger.error("Error while closing driver", e);
                    } finally {
                        driverThreadLocal.remove();
                        logger.info("Driver cleanup completed for thread: " + Thread.currentThread().getId());
                    }
        }
    }
}
