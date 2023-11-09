@smoke
  Feature: F06_homeSliders | user could user home slider

    @F01_homeSlider
    Scenario: first slider is clickable on home page
      Given user go to slider in home page
      When click on first slider Iphone pro
      Then it directs to Iphone pro product page

     @F02_homeSlider
     Scenario: second slider is clickable on home page
       Given user go to slider in home page
       When click on second slider Galaxy ultra
       Then it directs to Galaxy ultra product page


