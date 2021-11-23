Feature: Web Login

  Scenario: Failed Login
  Given User is on the Login Page
  When  User enters Username and the Password credentials
  And User clicks loginButton
  Then User verify the Error Message