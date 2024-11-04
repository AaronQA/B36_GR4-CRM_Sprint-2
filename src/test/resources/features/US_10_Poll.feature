@US_10
Feature: As a user, I should be able to create a poll by clicking on Poll tab in the Activity Stream

  Background: User is already on the login page
    Given user is on the login page

  @US_10 @AC_1
  Scenario Outline: Delivery is set to default value when a poll is being created.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    Then user should see default delivery "All employees"
    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_2
  Scenario Outline: User can create a poll by adding questions and multiple answers.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    And user enters Message Title
    And user enters Question
    And user enters Answer 1
    And user enters Answer 2
    And user enters Answer 3
    And user submits poll by clicking SEND button
    Then successfully created poll is displayed in the feed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_3
  Scenario Outline: User can select the "Allow multiple choice" checkbox.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    Then user can select multiple choice checkbox

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_4
  Scenario Outline: Error message displayed when trying to create a poll with blank "Message title" field.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    And user enters Question
    And user enters Answer 1
    And user enters Answer 2
    And user submits poll by clicking SEND button
    Then Error message "The message title is not specified" is displayed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_5
  Scenario Outline: Error message displayed when trying to create a poll with blank "To:" recipient field.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    And user enters Message Title
    And user enters Question
    And user enters Answer 1
    And user enters Answer 2
    And user cancels default delivery
    And user submits poll by clicking SEND button
    Then Error message "Please specify at least one person." is displayed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_6
  Scenario Outline: Error message displayed when trying to create a poll with blank "Question" field.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    And user enters Message Title
    And user enters Answer 1
    And user enters Answer 2
    And user submits poll by clicking SEND button
    Then Error message "The question text is not specified." is displayed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |

  @US_10 @AC_7
  Scenario Outline: Error message displayed when trying to create a poll with blank "Answer" fields.
    Given user logs in as "<userType>"
    When user navigates to poll section by clicking POLL button
    And user enters Message Title
    And user enters Question
    And user submits poll by clicking SEND button
    Then Error message "The question \""..."\" has no answers."  is displayed

    Examples:
      | userType  |
      | hr        |
      | helpdesk  |
      | marketing |