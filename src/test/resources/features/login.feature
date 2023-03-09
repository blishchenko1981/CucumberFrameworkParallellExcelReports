
@ui
Feature: User can login to the application with correct credentials



  Scenario: home page is open after user provide correct credentials

    Given User provide url
    When User input credentials and click Login button
    Then Home page is displayed


