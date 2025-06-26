package com.epam.training.munara_narkozieva.finalTask.steps;

import com.epam.training.munara_narkozieva.finalTask.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private String errorMessage;

    @Given("the user is on the SauceDemo login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("the user clears the username and password fields using XPath")
    public void clearInputs() {
        // First input something (requirement of UC-1)
        loginPage.enterUsername("temp_user");
        loginPage.enterPassword("temp_pass");

        // Then clear
        loginPage.clearUsername();
        loginPage.clearPassword();
    }

    @When("the user enters {string} in the username field using XPath")
    public void enterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("enters {string} in the password field using XPath")
    public void enterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("clears the password field using XPath")
    public void clearPasswordField() {
        // UC-2 requires typing first, then clearing
        loginPage.enterPassword("temp_pass");
        loginPage.clearPassword();
    }

    @When("clicks the login button using XPath")
    public void clickLogin() {
        loginPage.clickLogin();
    }

    @Then("an error message {string} should appear using XPath")
    public void verifyErrorMessage(String expectedMessage) {
        errorMessage = loginPage.getErrorMessage();
        assertThat(errorMessage, containsString(expectedMessage));
    }

    @Then("the user should be redirected to the inventory page with title {string}")
    public void verifyDashboardTitle(String expectedTitle) {
        assertThat(driver.getTitle(), is(expectedTitle));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}