@smoke
  Feature: FO7_followUs | user could open followUs links

    @F01_followUs
    Scenario: user opens facebook link
      Given user go to home page
      When user press on facebook link
      Then facebook link is opened in new tab

    @F02_followUs
    Scenario: user opens twitter link
      Given user go to home page
      When user press on twitter link
      Then twitter link is opened in new tab

    @F02_followUs
    Scenario: user opens rss link
      Given user go to home page
      When user press on rss link
      Then rss link is opened in new tab

    @F02_followUs
    Scenario: user opens youtube link
      Given user go to home page
      When user press on youtube link
      Then youtube link is opened in new tab

