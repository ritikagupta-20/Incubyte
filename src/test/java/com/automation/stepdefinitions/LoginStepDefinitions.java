package com.automation.stepdefinitions;

import com.automation.pages.LoginPage;
import com.automation.utils.Constants;

import io.cucumber.java.en.*;
import io.cucumber.java.After;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LoginStepDefinitions {
    WebDriver driver;
    LoginPage loginPage;

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
    }

    @When("the user enters valid login credentials")
    public void enterValidLoginCredentials() {
        loginPage.fillLoginForm(Constants.USERNAME, Constants.PASSWORD);
    }

    @And("the user submits the login form with valid credentials")
    public void submitLoginWithValidCredentials() {
        loginPage.login();
    }

    @Then("the user should be successfully logged in with valid credentials")
    public void verifySuccessfulLogin() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/";
        String actualURL = driver.getCurrentUrl();
        assertTrue("Login not successful.", actualURL.equals(expectedURL));
    }

    // Negative Scenario: Unsuccessful login with invalid credentials
    @When("the user enters invalid login credentials {string} and {string}")
    public void enterInvalidLoginCredentials(String email, String password) {
        loginPage.fillLoginForm(email, password);
    }

    @And("the user submits the login form with invalid credentials")
    public void submitLoginWithInvalidCredentials() {
        loginPage.login();
    }

    @Then("the user should see an error message for invalid credentials {string}")
    public void verifyLoginInvalidCredentialsErrorMessage(String expectedError) {
        String actualError = loginPage.getPageErrorMessage();
        assertTrue("Expected error message for invalid credentials not displayed.", actualError.contains(expectedError));
    }

    // Negative Scenario: Unsuccessful login with blank fields
    @When("the user submits login form with blank fields")
    public void submitLoginWithBlankFields() {
        loginPage.login();
    }

    @Then("the user should see an error message for invalid blank input {string}")
    public void verifyLoginBlankFieldsErrorMessage(String expectedError) {
        String actualError = loginPage.getPageErrorMessage();
        assertTrue("Expected error message for invalid blank fields not displayed.", actualError.contains(expectedError));
    }

    // Negative Scenario: Unsuccessful login with empty password
    @When("the user enters email {string}")
    public void enterLoginEmail(String email) {
        loginPage.fillLoginForm(email, "");
    }

    @And("the user submits the login form without filling password")
    public void submitLoginWithEmptyPassword() {
        loginPage.login();
    }

    @Then("the user should see an error message for missing password {string}")
    public void verifyLoginEmptyPasswordErrorMessage(String expectedError) {
        String actualError = loginPage.getPageErrorMessage();
        assertTrue("Expected error message for empty password not displayed.", actualError.contains(expectedError));
    }

    // Negative Scenario: Unsuccessful login with empty email
    @When("the user enters password {string}")
    public void enterLoginPassword(String password) {
        loginPage.fillLoginForm("", password);
    }

    @And("the user submits the login form without filling email")
    public void submitLoginWithEmptyEmail() {
        loginPage.login();
    }

    @Then("the user should see an error message for missing email {string}")
    public void verifyLoginEmptyEmailErrorMessage(String expectedError) {
        String actualError = loginPage.getPageErrorMessage();
        assertTrue("Expected error message for empty email not displayed.", actualError.contains(expectedError));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
