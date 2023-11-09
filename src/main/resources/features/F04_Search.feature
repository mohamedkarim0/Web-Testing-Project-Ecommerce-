@smoke
  Feature: F04_Search | user could search for and item

    @F01_Search
   Scenario Outline: user could search using product name
      Given user go to the home page
      When user search a product as  a name "<name>"
      Then product is found
      Examples:
        | name   |
        | book   |
        | laptop |
        | nike   |



    @F02_Search
    Scenario Outline: user could search using product sku
      Given user go to the home page
      When user search a product as sku "<sku>"
      And user select first result
      Then selected product is found by "<sku>"

      Examples:
        | sku      |
        | SCI_FAITH|
        | APPLE_CAM|
        | SF_PRO_11|


