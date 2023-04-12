@GetCEOname
Feature: this feature is to get CEO name from OPenHRM app

  Scenario: This test is to verify CEO name
    When user is logged in succesfully on home page
    Given when user clicks directory option from menu bar
    And user selects job title as HR from dropdown
    Then user should see HR name as "John Smith"
