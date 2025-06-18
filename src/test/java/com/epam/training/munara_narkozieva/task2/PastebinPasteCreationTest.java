package com.epam.training.munara_narkozieva.task2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PastebinPasteCreationTest {
    private WebDriver driver;
    private PastebinPasteCreationPage pastebinPasteCreationPage;


    private final String PASTE_CODE = "git config --global user.name  \"New Sheriff in Town\"\n"
            + "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n"
            + "git push origin master --force";
    private final String SYNTAX_HIGHLIGHTING = "Bash";
    private final String PASTE_EXPIRATION = "10 Minutes";
    private final String PASTE_NAME = "how to gain dominance among developers";

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        pastebinPasteCreationPage = new PastebinPasteCreationPage(driver);
    }


    @Test
    public void testCreateNewPaste() {
        pastebinPasteCreationPage.openPage();

        pastebinPasteCreationPage.enterPasteCode(PASTE_CODE);

        pastebinPasteCreationPage.selectSyntaxHighlighting();

        pastebinPasteCreationPage.pasteExpiration();

        pastebinPasteCreationPage.pasteName(PASTE_NAME);

        String pasteUrl = pastebinPasteCreationPage.pasteButton();

        assertTrue(pasteUrl.contains("pastebin.com"));

        driver.getTitle();

        String actualTitle = driver.getTitle();
        assertTrue(actualTitle.contains(PASTE_NAME), "Page title doesn't match paste name.");

        String actualSyntax = pastebinPasteCreationPage.getSyntaxHighlighting();
        assertTrue(actualTitle.contains(SYNTAX_HIGHLIGHTING), "Syntax highlighting is not Bash.");

        String actualCode = pastebinPasteCreationPage.getPasteCode();
        assertTrue(actualCode.contains("git config"), "Paste code doesn't match the input.");


    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

