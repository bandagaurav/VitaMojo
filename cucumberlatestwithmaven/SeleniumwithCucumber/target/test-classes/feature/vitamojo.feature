Feature: Login/Signup Action
  Background: User is on Home Page
    Given User clicks on Login Button

  Scenario: Successful Signup with Valid Credentials
    Given User clicks on create account tab
    When User enters Name
    And  User enters email address
    And  User enters password
    And User clicks on future discounts checkbox
    Then User clicks on create account button
    And  Message displayed Signup Successfully

   Scenario: Successful Login with Valid Credentials
     When User enters login email address
     And  User enters login password
     And  User Clicks on login button
     Then Message displayed Login Successfully

