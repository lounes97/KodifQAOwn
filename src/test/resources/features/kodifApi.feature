@Api
Feature: testing trust wallet chat

  Scenario: User login and successfully get token
    When user loging in with correct credential
    Then success code should be 200 and url should be valid