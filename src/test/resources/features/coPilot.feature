@smoke @ui
Feature: User Authentication
  User Story:
  As a user, I should be able to login with correct credentials via Salesforce platform.

  Background: Login a user
    When user enters the username
    And user enters the password
    Then user clicks on login button
    And when the user clicks on the Kodif icon, the coPilot window pops up
  @max&min @ui
  Scenario: Maximize and minimize coPilot Window
    When the user selects the maximize option the coPilot window should expand
    And the user selects the minimize option the coPilot window should minimize

  @commandButton @ui
  Scenario: Command button in Copilot Window
    When user clicks on command button he should see at least one element

  @commandInput @ui
  Scenario: User clicks on command button and select one of the action
    When user enter a string in input field and press enter key

  @ticketSwitch @ui
  Scenario: User on the main page and shift the ticket
    When user clicks on different ticket the default message should appear on the coPilot window

  @insertSuggestion @ui
  Scenario: User clicks on Suggestion action to insert the suggestion to the Post section
    When user clicks on Suggestion action the insert button will appear under the suggestion text
    And user clicks on insert button which will copy and paste the text to the Post field
    Then user verifies that the text inserted into the Post field matches the suggested response

  @insertDisposition @ui
  Scenario: User clicks on Disposition action to insert the suggestion to the Case Notes section
    When user clicks on Disposition action the insert button will appear under the disposition info
    And user clicks on insert button which will copy and paste the info to Case Notes field
   Then verify that the text inserted to Case Notes is matching with the suggested response
