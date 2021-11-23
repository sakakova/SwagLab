Feature: Web Login

  <!-- As a Swag Labs customer who is not locked out, I need to be able to log in so that I can purchase Sauce Labs merch. -->
Scenario: 1 Successful Login
Given User is on the Login Page
When  User enters Username and the Password credentials
And User clicks loginButton
Then User redirected to the Main Page
And User verify the App Logo exists