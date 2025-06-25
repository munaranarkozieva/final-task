package com.epam.training.munara_narkozieva.finalTask;

import com.epam.training.munara_narkozieva.utils.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Execution(ExecutionMode.CONCURRENT)
public class BaseTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    protected static final String BROWSER = System.getProperty("browser", "chrome");

    @BeforeEach
    void setUp() {
        WebDriverFactory.getDriver(BROWSER);
        logger.info("Started test in thread {}", Thread.currentThread().getId());
    }

    @AfterEach
    void tearDown() {
        WebDriverFactory.quitDriver();
    }
}
