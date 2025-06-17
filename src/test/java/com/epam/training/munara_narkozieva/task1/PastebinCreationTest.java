package com.epam.training.munara_narkozieva.task1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PastebinCreationTest {
    private WebDriver driver;
    private PastebinHomePage pastebinHomePage;

    private final String PASTE_CODE = "Hello from WebDriver";
    private final String PASTE_EXPIRATION = "10 Minutes";
    private final String PASTE_NAME = "helloweb";

    @BeforeEach
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        pastebinHomePage = new PastebinHomePage(driver);
    }

    @Test
    void testCreateNewPaste() {

        pastebinHomePage.openPage();
        assertTrue(pastebinHomePage.getPageTitle().contains("Pastebin"), "We are not on the correct page");

        pastebinHomePage.enterPasteCode(PASTE_CODE);

        pastebinHomePage.selectPasteExpiration(PASTE_EXPIRATION);

        pastebinHomePage.enterPasteName(PASTE_NAME);

        pastebinHomePage.clickCreatePaste();

        assertTrue(pastebinHomePage.getPageTitle().contains(PASTE_NAME), "New paste was not created successfully.");
    }


    @AfterEach
    void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}