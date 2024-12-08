Feature:User Story 04 Messages features
  As a user, I should be able to send messages by clicking on Message tab
  in the Activity Stream.

  Background: User is on the Portal login page
#    Given User is on the Portal home page
  @aaron
  Scenario Outline: Verify that the user can send a message by filling in the mandatory fields.
    When user logs in as "<userType>"
    And user clicks "Activity Stream"
    And user clicks "Message" in activity stream
    And User add text
    And user clicks Send button
    Then user should be able to see message which is sent
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: user (HR, HelpDesk, Marketing) tries to send message without content
    When user logs in as "<userType>"
    When User clicks on the message content
    And User clicks on the send button without message
    Then Error message is displayed "The message title is not specified"
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: user (HR, HelpDesk, Marketing) tries to click to Recipient button without recipient
    When user logs in as "<userType>"
    When User click to Recipient button without recipient
    Then RecipientError message is displayed "Please specify at least one person."
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  Scenario Outline: Message delivery is to "All employees" by default
    When user logs in as "<userType>"
    When User clicks on the message box
    Then Message delivery is to "All employees" by default
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |


  @loginAsUser
  Scenario: User can cancel sending message at any time
    When user logs in as "<userType>"
    When User wants to cancel the message
    Then The message will be cancelled