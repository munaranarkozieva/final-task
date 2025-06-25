package com.epam.training.munara_narkozieva.finalTask.steps;


import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class LoginSteps {

    private  WebDriver driver;
    private String errorMessage;

    @Given ("the user is on the SauceDemo login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When ("the user clears the username and password fields")
    public void clearInputs() {
        driver.findElement(By.xpath("/input[@data-test='username']")).clear();
        driver.findElement(By.xpath("//input[@data-test='password']")).clear();
    }

    @When ("clicks the button")
    public void clickLogin(){
        driver.findElement(By.xpath("//input[@data-test='login-button']")).click();
    }

    @Then ("an error message {string} should appear")
    public void verifyErrorMessage( String expectedMessage) {
       errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
       assertThat(errorMessage, containsString(expectedMessage));
    }

    @Then ("the user should be redirected to the dashboard with title {string}")
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
