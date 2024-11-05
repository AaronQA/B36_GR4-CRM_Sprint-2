Feature: As a user, I should be able to login.

  Background: User is already on the login page
    Given user is on the login page


  Scenario Outline: Verify that <userType> user can log in with valid credentials and land on the home page after
  successful login.
    When user logs in as "<userType>"
    Then user should be able to see "Portal" as page title
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  Scenario Outline: Verify that "Incorrect login or password" error message is displayed for invalid credentials
    When user attempts to log in with either incorrect email or password: "<email>" and "<password>"
    Then user should see "Incorrect login or password" error message

    Examples:
      | email                   | password    |
      | hr13@cydeo.com          | invalidPass |
      | helpdesk62@cydeo.com    | abcDEF      |
      | marketing1000@cydeo.com | UserUser    |


  Scenario Outline: Verify that "Please fill out this field" error message is displayed if username or password is empty
    When user attempts to log in with "<email>" and "<password>"
    Then user should see "Please fill out this field" error message

    Examples:
      | email          | password |
      |                | UserUser |
      | hr13@cydeo.com |          |
      |                |          |


  Scenario: Verify that the "Remember me on this computer" link exists and is clickable on the login page
    When user should see "Remember me on this computer" link
    Then user should be able to click on "Remember me on this computer" link


  Scenario: Verify that the password is in bullet signs by default
    When user sees the password field
    And user enters "characters" in the password field
    Then user should see password field with "password" attribute type
