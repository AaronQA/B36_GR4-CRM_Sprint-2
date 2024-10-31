@Appreciation
Feature: As a user, I should be able to utilize Appreciation functionality: upload files, send text etc.

  Background: User located on the Login Page
    Given user is on the login page

  @AppreciationUploadTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can upload files and pictures in supported the format
    When user attempts to log in with either incorrect email or password: "<email>" and "<password>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    Then uploads supported files
    Examples:
      | email                 | password |
      | hr55@cydeo.com        | UserUser |
      #| hr56@cydeo.com        | UserUser |
      #| hr57@cydeo.com        | UserUser |
      | helpdesk55@cydeo.com  | UserUser |
      #| helpdesk56@cydeo.com  | UserUser |
      #| helpdesk57@cydeo.com  | UserUser |
      | marketing55@cydeo.com | UserUser |
      #| marketing56@cydeo.com | UserUser |
      #| marketing57@cydeo.com | UserUser |

  @AppreciationInsertInTextTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can insert the files and images into the text
    When user attempts to log in with either incorrect email or password: "<email>" and "<password>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    Then clicks on the Insert in text button
    Examples:
      | email                 | password |
      | hr55@cydeo.com        | UserUser |
      #| hr56@cydeo.com        | UserUser |
      #| hr57@cydeo.com        | UserUser |
      | helpdesk55@cydeo.com  | UserUser |
      #| helpdesk56@cydeo.com  | UserUser |
      #| helpdesk57@cydeo.com  | UserUser |
      | marketing55@cydeo.com | UserUser |
      #| marketing56@cydeo.com | UserUser |
      #| marketing57@cydeo.com | UserUser |

  @AppreciationDeleteFileTest
  Scenario Outline: user (HR, HelpDesk, Marketing) can remove files and images
    When user attempts to log in with either incorrect email or password: "<email>" and "<password>"
    And clicks on More button (dropdown)
    And clicks on Appreciation option
    And uploads supported files
    And clicks on the Insert in text button
    Then clicks on remove button
    Examples:
      | email                 | password |
      | hr55@cydeo.com        | UserUser |
      #| hr56@cydeo.com        | UserUser |
      #| hr57@cydeo.com        | UserUser |
      | helpdesk55@cydeo.com  | UserUser |
      #| helpdesk56@cydeo.com  | UserUser |
      #| helpdesk57@cydeo.com  | UserUser |
      | marketing55@cydeo.com | UserUser |
      #| marketing56@cydeo.com | UserUser |
      #| marketing57@cydeo.com | UserUser |
