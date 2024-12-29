Feature: Account Signup

  Scenario: Create an account and sign in
    Given the user is on the signup page
    When the user fills in signup details
    And the user submits the signup form with valid details
    Then the user should be successfully registered with success message "Thank you for registering with Main Website Store."

  Scenario: Login with the same credentials
    Given the user is on the signup page
    When the user logs in with the same credentials
    Then the user should be successfully logged in with the same credentials

  Scenario: Fail to create an account due to invalid email
    Given the user is on the signup page
    When the user fills in signup details with an invalid email "invalidemail"
    And the user submits the signup form with invalid email
    Then the user should see an error message for invalid email "Please enter a valid email address (Ex: johndoe@domain.com)."

  Scenario: Fail to create an account due to weak password
    Given the user is on the signup page
    When the user fills in signup details with a weak password "12345"
    And the user submits the signup form with weak password
    Then the user should see an error message for weak password "Minimum length of this field must be equal or greater than 8 symbols. Leading and trailing spaces will be ignored."

  Scenario: Fail to create an account with an already registered email
    Given the user is on the signup page
    When the user fills in signup details with an already registered email "john.doe@example.com"
    And the user submits the signup form with existing email
    Then the user should see an error message for already registered email "There is already an account with this email address."
