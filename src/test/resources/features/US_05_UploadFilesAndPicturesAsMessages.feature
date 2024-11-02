@US_5
Feature: File and Image Upload as Messages
  As a user, I should be able to log in and upload files and images as part of my messages.

  Background: User is on the login page
    Given user is on the login page

  @US_5 @AC_1
  Scenario Outline: Uploading supported file formats
    When user logs in as "<userType>"
    And clicks on the message text area
    Then uploads supported files

    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|

  @US_5 @AC_2
  Scenario Outline: Inserting files and images into the message
    When user logs in as "<userType>"
    And clicks on the message text area
    And uploads supported files
    Then clicks on the Insert in text button
    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|


  @US_5 @AC_3
  Scenario Outline: Removing files and images before sending
    When user logs in as "<userType>"
    And clicks on the message text area
    And uploads supported files
    And clicks on the Insert in text button
    Then clicks on remove button
    Examples:
      |userType|
      |hr      |
      |helpdesk|
      |marketing|

