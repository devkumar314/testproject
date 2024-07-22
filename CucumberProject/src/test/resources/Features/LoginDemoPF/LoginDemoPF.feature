Feature: Test login functionality PF

	@SmokeTest
  Scenario Outline: Check login is successfull with valid credentials PF
    Given pf browser is open
    And pf user is on login page
    When pf user enters <username> and <password>
    And pf user clicks on login
    Then pf user is navigated to home page

    Examples: 
      | username  | password |
      |standard_user|secret_sauce |
      |visual_user|secret_sauce|
