@smoke
  Feature: FO5_hoverCategories |

    @F01_Hover
    Scenario: user could Hover a product using mouse
      Given user go to Main page
      When user selects random product category
      Then directs to products of that category