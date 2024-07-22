Feature: bk Check login functionaliry

Background: bk user is logged in
Given bk user is on login page
When bk user enter username and password
And bk clicks on ligin button
Then bk user is navigated to home page

	Scenario: bk Check logout link
    Given bk user is logged in
    When bk user clicks on welcome link
    Then bk logout link is displayed

    
  Scenario: bk verify quick launch
    Given bk user is logged in
    When bk user clicks on dashboard button
    Then bk quick launch displayed
    