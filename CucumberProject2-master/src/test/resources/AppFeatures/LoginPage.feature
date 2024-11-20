@Login
Feature: Login page feature
@smoke
  Scenario: Login page title
    Given user is on login page
    When user gets the title of the page
    Then page title should be "OrangeHRM"
@smoke @Skip
  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed
@Regression
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "Admin"
    And user enters password "admin123"
    And user clicks on Login button
    Then user gets the title of the page
    And page title should be "OrangeHRM"














