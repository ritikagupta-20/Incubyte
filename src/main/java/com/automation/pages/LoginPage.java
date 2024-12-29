package com.automation.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "pass")
    WebElement password;

    @FindBy(id = "send2")
    WebElement loginButton;

    @FindBy(css = "div[data-ui-id='message-error']")
    WebElement pageErrorMessage;

    // Constructor to initialize driver and web elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Method to fill login form
    public void fillLoginForm(String emailID, String pwd) {
        email.sendKeys(emailID);
        password.sendKeys(pwd);
    }

    // Method to press Enter key after entering password
    public void pressPasswordEnterKey() {
        password.sendKeys(Keys.ENTER);
    }

    // Method to login
    public void login() {
        loginButton.click();
    }

    // Method to get page error message
    public String getPageErrorMessage() {
        return pageErrorMessage.getText();
    }

}