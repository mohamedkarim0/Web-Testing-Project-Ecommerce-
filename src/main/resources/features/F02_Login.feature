@smoke
  Feature: F02_Login | user could login functionality to use their accounts

    @F01_Login
    Scenario: user could login with valid email and password
      Given user go to login page
      When user login with valid "mohamedkarim@gmail.com" and "mohamed2020"
      And user press on login button
      Then user login to the system successfully

      @FO2_Login
      Scenario: user could login with invalid email and password
      Given user go to login page
      When user login with invalid "mohamedkarim@yahoo.com" and "123456"
      And user press on login button
      Then user could not login to the system