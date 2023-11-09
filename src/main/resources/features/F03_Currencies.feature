@smoke
  Feature: F03_Currencies | User could change to the desired currency

    @F01_Currencies
    Scenario: User could change currency to dollar
      Given user go to home page
      When user selects "Euro" currency
      Then currency is updated successfully