Feature: Validate the signup functionality to ParaBank

  Scenario Outline: Login
    Given I hit the login url
    When I enter the details "<Username>", "<Password>", "<check>"
    And click on login
    Then if the details are valid it will redirect home page else it will stay in login page with error
    Examples:
      | Username                     | Password   | check      |
      | eric.hoch@aventriahealth.com | ^CTonMS21! | Valid      |
      | eric.hoch@aventriahealth.com | ss         | Invalid    |
      |                              |            | empty      |
      | eric.hoch@aventriahealth.com |            | Emptypass  |
      |                              | pass       | Emptyemail |

    Scenario: Resource link generator
      Given I login using "eric.hoch@aventriahealth.com" and "^CTonMS21!"
      When I click on resources
      And Click on View or Customize button
      When Click on the check box to generate the url
      Then Validate the Url is generated or not
