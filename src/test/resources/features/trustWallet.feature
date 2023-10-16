@TrustSmoke @ui
Feature: User Interaction with TrustWallet Chat

  Background:
    Given the user is on the TrustWallet chat interface
    When the user asks a question and receives a response with a link

  Scenario: User Asks a Question and Receives a Valid Article Link
    Then the link provided should not be blank

@ThumbsUp&Down
Scenario: User Rates the Response
  Given the user is on the TrustWallet chat interface
  When the user asks a question and receives a response with a link

  When the user clicks the thumbs-up icon
  Then the thumbs-up icon should change color to green
  And the thumbs-down icon should remain unchanged

  When the user clicks the thumbs-down icon
  Then the thumbs-down icon should change color to red
  And the thumbs-up icon should remain unchanged

