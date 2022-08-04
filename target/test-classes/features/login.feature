Feature: login
  As valid user I would like to log into the application

  Scenario: login successfully with valid account
    Given the user is in Login Page
    When the user input "quan" into Username textbox
    And the user input "@Abcd1234" into Password textbox
    And the user click Login button
    Then the UserName "quan" is show correctly
    And When the user input "quan" into aaa textbox