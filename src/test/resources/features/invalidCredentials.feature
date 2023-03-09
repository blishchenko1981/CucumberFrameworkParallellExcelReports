Feature: invalid credentials

  Scenario Outline: error message should be displayed if user provide wrong email or password
    Given User provide url
    When User input wrong "<Username>" or "<Password>" and click Login button
    Then Error message is displayed
    Examples:
      | Username  | Password    |
      | WrongName | Userpass123 |
      | User1     | WrongPass   |