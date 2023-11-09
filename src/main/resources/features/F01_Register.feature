@smoke
Feature: F01_Register | users could register with new accounts

  Scenario: guest user could register with valid data successfully
    Given user go to register page
    When user selects the gender "male"
    And user enters his first name "Mohamed" and last name "Karim"
    And  user enter his birth date day "9" month "12" year "2000"
    And  user enters his mail "mohamedkarim@gmail.com"
    And user enter company's name "google"
    And user  wants unsubscribe to newsletters
    And user enters and confirm his password "mohamed2020"
    Then registration complete