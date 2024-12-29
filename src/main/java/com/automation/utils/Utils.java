package com.automation.utils;

import java.util.Random;

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
}
