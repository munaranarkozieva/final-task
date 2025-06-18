package com.epam.training.munara_narkozieva.task2;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPasteCreationPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By acceptCookiesButton = By.cssSelector(".qc-cmp2-summary-buttons button.qc-cmp2-btn.qc-cmp2-btn-secondary.qc-cmp2-btn-accept-all");
    private final By textArea = By.id("postform-text");
    private final By bashOption = By.xpath("//li[text()='Bash']");
    private final By syntaxDropdown = By.cssSelector("span.select2-selection__rendered");
    private final By expiration = By.id("select2-postform-expiration-container");
    private final By tenMinutesOption = By.xpath("//li[text()='10 Minutes']");
    private final By nameTitle = By.id("postform-name");
    private final By createNewPasteButton = By.cssSelector("button.btn.-big");
    private final By syntaxHighlightingResult = By.cssSelector("a.btn.-small.h_800");
    private final By pasteCodeResult = By.cssSelector("div.de1");


    public PastebinPasteCreationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openPage() {
        driver.get("https://pastebin.com/");
        try {
            WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesButton));
            acceptCookies.click();
        } catch (RuntimeException e) {
            System.out.println("No cookie pop-up appeared");
        }
    }

    public void enterPasteCode(String code) {
        WebElement textAreaElement = wait.until(ExpectedConditions.elementToBeClickable(textArea));
        textAreaElement.sendKeys(code);
    }


    public void selectSyntaxHighlighting() {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(syntaxDropdown));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ul.select2-results__options")));

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(bashOption));
        option.click();
    }

    public void pasteExpiration() {
        WebElement expirationDropdown = wait.until(ExpectedConditions.elementToBeClickable(expiration));
        expirationDropdown.click();
        WebElement tenMinutes = wait.until(ExpectedConditions.elementToBeClickable(tenMinutesOption));
        tenMinutes.click();
    }

    public void pasteName(String pasteName) {
        WebElement nameField = wait.until(ExpectedConditions.elementToBeClickable(nameTitle));
        nameField.sendKeys(pasteName);
    }

    public String pasteButton() {
        WebElement pasteButton = wait.until(ExpectedConditions.elementToBeClickable(createNewPasteButton));
        pasteButton.click();
        return driver.getCurrentUrl();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getSyntaxHighlighting() {
        WebElement syntaxElement = wait.until(ExpectedConditions.elementToBeClickable(syntaxHighlightingResult));
        return syntaxElement.getText();
    }

    public String getPasteCode() {
        WebElement codeElement = wait.until(ExpectedConditions.elementToBeClickable(pasteCodeResult));
        return codeElement.getText();
    }
}

