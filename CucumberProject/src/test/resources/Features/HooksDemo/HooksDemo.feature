Feature: hk Check login functionaliry

	@smoketest
  Scenario: hk Check login is successfull using valid credentials
    Given hk user is on login page
    When hk user enters username and password
    And hk clicks on login button
    Then hk user is navigated to home page
