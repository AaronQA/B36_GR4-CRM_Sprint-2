@US_12
Feature: As a user, I should be able to utilize Appreciation functionality: upload files, send text etc.

  Background: User located on the Login Page
    Given user is on the login page

  @US_12 @AC_1 @Smoke @Regression
  Scenario Outline: user (HR, HelpDesk, Marketing) can upload files and pictures in supported the format
    When user logs in as "<userType>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    Then uploads supported files
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_12 @AC_2
  Scenario Outline: user (HR, HelpDesk, Marketing) can insert the files and images into the text
    When user logs in as "<userType>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    Then clicks on the Insert in text button
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_12 @AC_3
  Scenario Outline: user (HR, HelpDesk, Marketing) can remove files and images
    When user logs in as "<userType>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    And clicks on the Insert in text button
    Then clicks on remove button
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |
