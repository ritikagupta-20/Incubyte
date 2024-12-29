Feature: User Login

    Scenario: Successful login with valid credentials
        Given the user is on the login page
        When the user enters valid login credentials
        And the user submits the login form with valid credentials
        Then the user should be successfully logged in with valid credentials

    Scenario: Unsuccessful login with invalid credentials
        Given the user is on the login page
        When the user enters invalid login credentials "invaliduser@example.com" and "WrongPassword"
        And the user submits the login form with invalid credentials
        Then the user should see an error message for invalid credentials "The account sign-in was incorrect"

    Scenario: Unsuccessful login with blank fields
        Given the user is on the login page
        When the user submits login form with blank fields
        Then the user should see an error message for invalid blank input "A login and a password are required."

    Scenario: Unsuccessful login with empty password
        Given the user is on the login page
        When the user enters email "email@example.com"
        And the user submits the login form without filling password
        Then the user should see an error message for missing password "A login and a password are required."

    Scenario: Unsuccessful login with empty email
        Given the user is on the login page
        When the user enters password "Password123"
        And the user submits the login form without filling email
        Then the user should see an error message for missing email "A login and a password are required."
