@US_6
Feature: As a user, I should be able to add link in message.

  Background: User is on the login page
    Given user is on the login page

  @US_6 @AC_1
  Scenario Outline: User can attach a link to the specified text.
    When user logs in as "<userType>"
    And clicks on the message text area
    And from the message editing tools selects Link option (chain icon)
    And enters "apple_text" in the Link text field
    And enters the "apple_url" in the URL text field
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
    And enters "tesla_text" in the Link text field
    And enters the "tesla_url" in the URL text field
    And presses "Save" button
    And press "Send" button
    And clicks on the hyperlink "tesla_url"
    And the link opens in a new tab
    Then user navigates to the "tesla_url"


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
    And enters "google_text" in the Link text field
    And enters the "google_url" in the URL text field
    And presses "Save" button
    And press "Send" button
    And clicks on the hyperlink "google_url"
    And the link opens in a new tab
    Then user navigates to the "google_url"


    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|

