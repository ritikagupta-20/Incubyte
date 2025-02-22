package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;
import java.time.Duration;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {
    WebDriver driver;

    @FindBy(id = "firstname")
    WebElement firstName;

    @FindBy(id = "lastname")
    WebElement lastName;

    @FindBy(id = "email_address")
    WebElement email;

    @FindBy(id = "password")
    WebElement password;

    @FindBy(id = "password-confirmation")
    WebElement confirmPassword;

    // @FindBy(xpath = "//button[@title='Create an Account']")
    @FindBy(css = "button[title='Create an Account']")
    WebElement createAccountButton;

    @FindBy(css = "#password-error")
    WebElement passwordErrorMessage;

    @FindBy(css = "#email_address-error")
    WebElement emailErrorMessage;

    @FindBy(css = "div[data-ui-id='message-error']")
    WebElement pageErrorMessage;

    @FindBy(css = ".message-success")
    WebElement pageSuccessMessage;

    @FindBy(css = "#password-strength-meter-label")
    WebElement passwordStrengthMeterLabel;

    // Constructor to initialize driver and web elements
    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to fill signup form
    public void fillSignupForm(String fName, String lName, String emailID, String pwd) {
        firstName.sendKeys(fName);
        lastName.sendKeys(lName);
        email.sendKeys(emailID);
        password.sendKeys(pwd);
        confirmPassword.sendKeys(pwd);
    }

    // Method to click on Create Account button
    public void clickCreateAccount() {
        createAccountButton.click();
    }

    // Method to get page success message
    public String getPageSuccessMessage() {
        return pageSuccessMessage.getText();
    }

    // Method to get error message for wrong password
    public String getWeakPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    // Method to get error message for invalid email
    public String getInvalidEmailErrorMessage() {
        return emailErrorMessage.getText();
    }

    // Method to get page error message
    public String getPageErrorMessage() {
        return pageErrorMessage.getText();
    }

    /**
     * Method to get the password feedback message.
     *
     * @param driver the WebDriver
     * @param expectedText the expected text
     * @param timeoutInSeconds the maximum time to wait in seconds
     * @return the password feedback message
     */
    public String getPasswordFeedbackMessage(WebDriver driver, String expectedText, int timeoutInSeconds) 
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.textToBePresentInElement(passwordStrengthMeterLabel, expectedText));
        return passwordStrengthMeterLabel.getText();
    }
}