package com.automation.utils;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {

    /**
     * Generates a random number within the specified range.
     *
     * @param min the minimum value (inclusive)
     * @param max the maximum value (exclusive)
     * @return a random number between min (inclusive) and max (exclusive)
     */
    public static int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    /**
     * Generates a random email address.
     *
     * @return a random email address with the format user{randomNumber}@example.com
     */
    public static String generateRandomEmail() {
        int randomNumber = generateRandomNumber(1000, 9999); // Generate a 4-digit random number
        return "user" + randomNumber + "@example.com";
    }

    // /**
    //  * Waits for the element's text to appear or update and then returns the text.
    //  *
    //  * @param driver the WebDriver
    //  * @param element the element
    //  * @param expectedText the expected text
    //  * @param timeoutInSeconds the maximum time to wait in seconds
    //  * @return the element's text
    //  */
    // public static WebElement getTextAfterWait(
    //     WebDriver driver,
    //     WebElement element,
    //     String expectedText,
    //     int timeoutInSeconds,
    // ) {
    //     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    //     wait.until(ExpectedConditions.textToBePresentInElement(element, expectedText));
    //     return element.getText();
    // }
}
