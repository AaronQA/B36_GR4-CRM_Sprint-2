@US_6
Feature: As a user, I should be able to add link in message.

  Background: User is on the login page
    Given user is on the login page

  @US_6 @AC_1
  Scenario Outline: User can attach a link to the specified text.
    When user logs in as "<userType>"
    And clicks on the message text area
    And from the message editing tools selects Link option (chain icon)
    And enters text in the Link text field
    And enters the URL in the URL text field
    And presses "Save" button
    And press "Send" button

    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|

  @US_6 @AC_2
  Scenario Outline: User can navigate to the correct URL by clicking on the hyperlink
    When user logs in as "<userType>"
    And clicks on the message text area
    And from the message editing tools selects Link option (chain icon)
    And enters text in the Link text field
    And enters the URL in the URL text field
    And presses "Save" button
    And press "Send" button
    And clicks on the hyperlink
    Then user navigates to the correct URL
    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|


  @US_6 @AC_3
  Scenario Outline: Link is opened in a new tab.
    When user logs in as "<userType>"
    And clicks on the message text area
    And from the message editing tools selects Link option (chain icon)
    And enters text in the Link text field
    And enters the URL in the URL text field
    And presses "Save" button
    And press "Send" button
    And clicks on the hyperlink
    And the link opens in a new tab
    Then user navigates to the correct URL

    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|

