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


