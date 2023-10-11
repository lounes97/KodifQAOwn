@TrustSmoke @ui
Feature: User on the TrustWallet chat


  Scenario: user use chat for asking questions
    When user ask a question
    And if chat will provide answer with a link to the related article
    Then link should not be blank


