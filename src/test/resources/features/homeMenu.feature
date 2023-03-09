@ui
Feature: user can use home menu

  Scenario: tabs are displayed on home page

    Given User provide url
    When User input credentials and click Login button
    Then User can see home menu modules