@getTimeSheets
Feature: This feature is to get timesheets

  Scenario: This test is to verify pending timesheets
    When user sucesfully logged on home page
    Given when user clicks time option from menu bar
    And user enters name as "John Smith" and click view button
    Then user should see the message as "<message>"
