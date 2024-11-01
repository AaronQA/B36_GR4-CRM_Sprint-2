Feature: As a user, I should be able to access my profile page.

  Background: User located on the Login Page
    Given user is on the login page

  @wip
  Scenario Outline: Verify Profile Page for different user roles (HR, HelpDesk, Marketing)
    When user logs in as "<userType>"
    When user clicks on the profile icon
    And user selects "My Profile" from the dropdown
    Then user should be redirected to the "My Profile" page
    And user should see the following tabs:
      | General       |
      | Drive         |
      | Tasks         |
      | Calendar      |
      | Conversations |

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

#    And the "<actualEmail>" under the General tab should match the "<expectedEmail>"
#    Examples:
#      | actualEmail          | expectedEmail        |
#      | hr58@cydeo.com       | hr58@cydeo.com       |
#      | helpdesk33@cydeo.com | helpdesk33@cydeo.com |
#      | marketing9@cydeo.com | marketing9@cydeo.com |