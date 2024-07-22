Feature: Test login functionality pom

  Scenario Outline: Check login is successfull with valid credentials pom
    Given pom browser is open
    And pom user is on login page
    When pom user enters <username> and <password>
    And pom user clicks on login
    Then pom user is navigated to home page

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | visual_user   | secret_sauce |
