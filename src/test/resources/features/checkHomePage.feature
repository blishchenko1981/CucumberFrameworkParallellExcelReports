Feature: User can have use all modules on Home page

  Background:
    Given User provide url
    And   User input credentials and click Login button

  @ui
  Scenario Outline: User can open each module on Home page

    When  User click on module "<ModuleName>"
    Then "<ModuleName>" page is open
    And User log out

    Examples:
      | ModuleName |
      | dashboard  |
      | files      |
      | photos     |
      | activity   |
      | mail       |
      | contacts   |
      | circles    |
      | calendar   |
      | deck       |

@ui
  Scenario: User can use UserSettings dropdown

    When user click on settings
    Then dropdown is displayed and include names
      | Settings |
      | Help     |
      | Log out  |

  @ui
  Scenario: User can see online Status in settings

    When user click on settings
    Then status should have one of the next values
      | Do not disturb |
      | Online         |
      | Away           |
      | Invisible      |

  @ui
  Scenario: User can see online status window
    When user click on settings
    And click on online status
    Then online status window appear


  @ui
  Scenario Outline: User can choose any online status
    When user click on settings
    And click on online status
    And click on "<status>"
    Then online "<status>" should be updated
    And User log out

    Examples:
      | status         |
      | Do not disturb |
      | Online         |
      | Away           |
      | Invisible      |

  @ui
  Scenario: User can log out from the application
    When User log out
    Then User see the login page

  @ui
  Scenario: User can change fields in settings page
    When user click on settings
    And click  settings icon on dropdown
    Then setting page is displayed
    And user can change fields
    And navigate back to Home page
    Then name on the Home page greeting displayed correctly

