Feature: Free CRM new Customer Creation
@smoke
  Scenario Outline: Free CRM login Test Scenario
    Given User is on Login Page
    When title of login page is freecrm
    Then User Clicks Login Button
    Then User Enters Username "<username>"
    And User Enters Password "<password>"
    Then User Clicks Login Button
    Then User navigates to Contacts Page




    Examples:
      | username | password |
      |  ridham23@gmail.com        |Punjab@123|
      |sakshi@rana.com             |   Delhi@123|