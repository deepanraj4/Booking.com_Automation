@login @regression
Feature: Login functionality
  As a registered user
  I want to log in to the application
  So that I can access my account

  Background:
    Given the user is on the login page

  @smoke
  Scenario Outline: Login with valid credentials
    When the user enters username "<username>" and password "<password>"
    And clicks the login button
    Then the user should be redirected to the home page
    And the page title should be "<title>"

    Examples:
      | username | password     | title     |
      | Deepan   | Test@123     | Dashboard |

  @negative
  Scenario Outline: Login with invalid credentials
    When the user enters username "<username>" and password "<password>"
    And clicks the login button
    Then an error message "<error>" should be displayed
    And the user should remain on the login page

    Examples:
      | username | password   | error                        |
      | Deepan   | wrongPass  | Invalid username or password |
      | wrongUsr | Test@123   | Invalid username or password |
      |          | Test@123   | Username is required         |
      | Deepan   |            | Password is required         |
      |          |            | Username is required         |

  Scenario: Logout from the application
    Given the user is logged in with valid credentials
    When the user clicks the logout button
    Then the user should be redirected to the login page

  Scenario: Forgot password navigation
    When the user clicks the "Forgot Password" link
    Then the user should be navigated to the reset password page

  Scenario: Reset password with registered email
    Given the user is on the reset password page
    When the user enters a registered email "<email>"
    And submits the request
    Then a confirmation message "Reset link sent to your email" should be displayed