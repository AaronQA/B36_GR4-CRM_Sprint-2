@Appreciation
Feature: As a user, I should be able to utilize Appreciation functionality: upload files, send text etc.

  Background: User located on the Login Page
    Given user is on the login page

  @AppreciationUploadTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can upload files and pictures in supported the format
    When user logs in as "<userType>" (StepanVersion)
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    Then uploads supported files
    Examples:
      | userType              |
      | hr55@cydeo.com        |
      | hr56@cydeo.com        |
      | hr57@cydeo.com        |
      | helpdesk55@cydeo.com  |
      | helpdesk56@cydeo.com  |
      | helpdesk57@cydeo.com  |
      | marketing55@cydeo.com |
      | marketing56@cydeo.com |
      | marketing57@cydeo.com |

  @AppreciationInsertInTextTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can insert the files and images into the text
    When user logs in as "<userType>" (StepanVersion)
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    Then clicks on the Insert in text button
    Examples:
      | userType              |
      | hr55@cydeo.com        |
      | hr56@cydeo.com        |
      | hr57@cydeo.com        |
      | helpdesk55@cydeo.com  |
      | helpdesk56@cydeo.com  |
      | helpdesk57@cydeo.com  |
      | marketing55@cydeo.com |
      | marketing56@cydeo.com |
      | marketing57@cydeo.com |

  @AppreciationDeleteFileTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can remove files and images
    When user logs in as "<userType>" (StepanVersion)
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    And clicks on the Insert in text button
    Then clicks on remove button
    Examples:
      | userType              |
      | hr55@cydeo.com        |
      | hr56@cydeo.com        |
      | hr57@cydeo.com        |
      | helpdesk55@cydeo.com  |
      | helpdesk56@cydeo.com  |
      | helpdesk57@cydeo.com  |
      | marketing55@cydeo.com |
      | marketing56@cydeo.com |
      | marketing57@cydeo.com |
