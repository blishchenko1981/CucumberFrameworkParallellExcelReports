Feature: files tab functions

  Background:
    Given User provide url
    And   User input credentials and click Login button

  @ui
  Scenario: User can navigate to Files page and verify options
    When User click on module "files"
    Then All option to see files are presented on the Files page

  @ui
      #Precondition: at least 1 file uploaded to application
  Scenario: User can share file link and can access it by using that link
    When User click on module "files"
    And Click on Share icon on first file row
    Then Sharing widget is displayed
    And User copy the link
    And User open link in a new tab
    Then User can see the file is open

    @ui
  Scenario: User can add new folder on files page
    When User click on module "files"
    And Click plus icon
    And Select folder in dropdown menu
    And Give the File name "HappyTesting"
    Then Folder "HappyTesting" should be displayed on the page
    And Folder "HappyTesting" can be deleted
