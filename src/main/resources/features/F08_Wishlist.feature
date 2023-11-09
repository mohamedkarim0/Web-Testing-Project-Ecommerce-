@smoke
  Feature: F08_Wishlist | user could add product to wishlist

    @F01_Wishlist
    Scenario: User could add HTC One M8 smartphone to wishlist
      Given user go to home page
      When user click on wishlist button
      Then user added product to wishlist successfully

    @F02_Wishlist
    Scenario: user could add HTC One M8 smartphone to wishlist and navigate to wishlist
      Given user go to home page
      When user click on wishlist button
      Then user navigates to wishlist page