Feature: Free CRM login feature
    @regression
    Scenario: Login using DatatableScenario
    Given User Launch and click Login
    Then User enters username and password
    |rocky@gmail.com|Punjab@123|

  @smoke
  Scenario: Login using DataMapScenario
    Given User Launch and click Login again
    Then User enters username and password again
    |username|password|
      |rocky@gmail.com|Punjab@123|
    |      ravi@gmail.com|Delhi@123          |
@tags
 Scenario Outline: Free CRM login Test Scenario
    Given User is on Login Page
    When title of login page is freecrm
    Then User Clicks Login Button
    Then User Enters Username "<username>"
    And User Enters Password "<password>"
   Then User Authenticates with Login Button
     Examples:
     | username | password |
     |  ridham23@gmail.com        |Punjab@123|
@tags
Scenario Outline: Free CRM User Creation Test
  Given User navigates to Contacts Page
  Then  User Enters FirstName "<firstname>"
  Then User Enters LastName "<lastname>"
  Then User Enters Category "<category>"
  Then User Clicks Save
  Examples:
  |firstname|lastname|category|
  |    Mohit     |Varma        |Lead|
  |    Sorabh    |sharma       | Customer   |

  @tags
  Scenario: Close the browser
    Given Browser is closed






