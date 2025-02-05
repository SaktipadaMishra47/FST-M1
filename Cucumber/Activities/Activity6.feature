@activity6
Feature: Data driven test with DataTable

  Scenario: Testing with Data from DataTable
    Given the user is on the login page
    When the user enters the following credentials
      | Usernames | Passwords | Message             |
      | admin     | password  | Welcome Back, admin |
      | user      | secret    | Welcome Back, user  |
    And clicks the submit button
    Then get the confirmation text and verify the message as
      | Message             |
      | Welcome Back, admin |
      | Welcome Back, user  |
