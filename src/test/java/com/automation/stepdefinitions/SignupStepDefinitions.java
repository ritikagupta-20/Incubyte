package com.automation.stepdefinitions;

import com.automation.pages.LoginPage;
import com.automation.pages.SignupPage;
import com.automation.utils.Constants;

import io.cucumber.java.en.*;
import io.cucumber.java.After;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignupStepDefinitions {
    WebDriver driver;
    SignupPage signupPage;
    LoginPage loginPage;

    @Given("the user is on the signup page")
    public void userOnSignupPage() {
        driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        signupPage = new SignupPage(driver);
    }

    // Positive Scenario: Create an account with valid details
    @When("the user fills in signup details")
    public void fillSignupDetails() {
        signupPage.fillSignupForm("John", "Doe", Constants.USERNAME, Constants.PASSWORD);
    }

    @And("the user submits the signup form with valid details")
    public void submitSignupFormWithValidDetails() {
        signupPage.clickCreateAccount();
    }

    @Then("the user should be successfully registered with success message {string}")
    public void verifySignup(String expectedMessage) {
        String actualMessage = signupPage.getPageSuccessMessage();
        assertTrue("Signup not successful", actualMessage.contains(expectedMessage));
    }

    // Positive Scenario: Login with the same credentials
    @When("the user logs in with the same credentials")
    public void userLogsIn() {
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");
        loginPage = new LoginPage(driver);
        loginPage.fillLoginForm(Constants.USERNAME, Constants.PASSWORD);
        loginPage.login();
    }

    @Then("the user should be successfully logged in with the same credentials")
    public void verifyLogin() {
        String expectedURL = "https://magento.softwaretestingboard.com/customer/account/";
        String actualURL = driver.getCurrentUrl();
        assertTrue("Login not successful.", actualURL.equals(expectedURL));
    }

    // Negative Scenario: Fail to create an account due to invalid email
    @When("the user fills in signup details with an invalid email {string}")
    public void fillFormWithInvalidEmail(String invalidEmail) {
        signupPage.fillSignupForm("John", "Doe", invalidEmail, Constants.PASSWORD);
    }

    @And("the user submits the signup form with invalid email")
    public void submitSignupFormWithInvalidEmail() {
        signupPage.clickCreateAccount();
    }

    @Then("the user should see an error message for invalid email {string}")
    public void verifyErrorMessage(String expectedError) {
        String actualError = signupPage.getInvalidEmailErrorMessage();
        assertTrue("Error message not displayed correctly", actualError.contains(expectedError));
    }

    // Negative Scenario: Fail to create an account due to weak password
    @When("the user fills in signup details with a weak password {string}")
    public void fillFormWithWeakPassword(String weakPassword) {
        signupPage.fillSignupForm("John", "Doe", "testuser@example.com", weakPassword);
    }
    
    @And("the user submits the signup form with weak password")
    public void submitSignupFormWithWeakPassword() {
        signupPage.clickCreateAccount();
    }

    @Then("the user should see an error message for weak password {string}")
    public void verifyWeakPasswordError(String expectedError) {
        String actualError = signupPage.getWeakPasswordErrorMessage();
        assertTrue("Error message for weak password is not correct", actualError.contains(expectedError));
    }

    // Negative Scenario: Fail to create an account with an already registered email
    @When("the user fills in signup details with an already registered email {string}")
    public void fillFormWithRegisteredEmail(String registeredEmail) {
        signupPage.fillSignupForm("John", "Doe", registeredEmail, Constants.PASSWORD);
    }
    
    @And("the user submits the signup form with existing email")
    public void submitSignupFormWithExistingEmail() {
        signupPage.clickCreateAccount();
    }

    @Then("the user should see an error message for already registered email {string}")
    public void verifyExistingEmailError(String expectedError) {
        String actualError = signupPage.getPageErrorMessage();
        assertTrue("Expected error message for existing email not displayed.", actualError.contains(expectedError));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
