Feature:User Story 04 Messages features
  As a user, I should be able to send messages by clicking on Message tab
  in the Activity Stream.

  Background: User is on the Portal login page
    Given User is on the Portal home page

  @loginAsHelpDeskUser
  Scenario: HelpDeskUser tries to send message without content
    When User clicks on the message content
    And User clicks on the send button without message
    Then Error message is displayed "The message title is not specified"

  @loginAsHrUser
  Scenario: HrUser tries to send message without content
    When User clicks on the message content
    And User clicks on the send button without message
    Then Error message is displayed "The message title is not specified"

  @loginAsMarketingUser
  Scenario: MarketingUser tries to send message without content
    When User clicks on the message content
    And User clicks on the send button without message
    Then Error message is displayed "The message title is not specified"

  @loginAsHrUser
 Scenario:HrUser tries to click to Recipient button without recipient
  When User click to Recipient button without recipient
  Then RecipientError message is displayed "Please specify at least one person."

  @loginAsHelpDeskUser
  Scenario:HelpDeskUser tries to click to Recipient button without recipient
    When User click to Recipient button without recipient
    Then RecipientError message is displayed "Please specify at least one person."

  @loginAsMarketingUser
    Scenario: MarketingUser tries to click to Recipient button without recipient
      When User click to Recipient button without recipient
      Then RecipientError message is displayed "Please specify at least one person."

  @loginAsMarketingUser
    Scenario: Message delivery is to "All employees" by default
      When User clicks on the message box
      Then Message delivery is to "All employees" by default

  @loginAsHrUser
  Scenario: Message delivery is to "All employees" by default
    When User clicks on the message box
    Then Message delivery is to "All employees" by default

  @loginAsHelpDeskUser
  Scenario: Message delivery is to "All employees" by default
    When User clicks on the message box
    Then Message delivery is to "All employees" by default

  @loginAsHrUser
    Scenario: HrUser can cancel sending message at any time
      When User wants to cancel the message
      Then The message will be cancelled