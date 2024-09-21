Feature: Test login functionality

  @smoketest
  Scenario Outline: Check login is successfull with valid credentials
    Given ld browser is open
    And ld user is on login page
    When ld user enters "username" and "password"
    And ld user clicks on login
    Then ld user is navigated to home page