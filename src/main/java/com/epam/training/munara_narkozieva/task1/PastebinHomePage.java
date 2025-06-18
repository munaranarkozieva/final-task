package com.epam.training.munara_narkozieva.task1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PastebinHomePage {


    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By codeTextarea = By.id("postform-text");
    private final By pasteExpirationDropdown = By.id("select2-postform-expiration-container");
    private final By pasteNameInput = By.id("postform-name");
    private final By createNewPasteButton = By.cssSelector("button.btn.-big");
    private final By acceptCookiesButton = By.cssSelector(".qc-cmp2-summary-buttons button.qc-cmp2-btn.qc-cmp2-btn-secondary.qc-cmp2-btn-accept-all");

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openPage() {
        driver.get("https://pastebin.com/");
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookies.click();
        } catch (Exception e) {
            System.out.println("no cookies pop-up appeared");
        }
    }

    public void enterPasteCode(String code) {
        WebElement textarea = wait.until(ExpectedConditions.elementToBeClickable(codeTextarea));
        textarea.sendKeys(code);
    }


    public void selectPasteExpiration(String optionText) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationDropdown));
        dropdown.click();

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(pasteExpirationOption(optionText)));
        option.click();
    }

    private By pasteExpirationOption(String optionText) {
        return By.xpath("//ul[@id='select2-postform-expiration-results']/li[text()='" + optionText + "']");
    }

    public void enterPasteName(String name) {
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(pasteNameInput));
        nameInput.sendKeys(name);
    }

    public void clickCreatePaste() {
        WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(createNewPasteButton));
        createButton.click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}