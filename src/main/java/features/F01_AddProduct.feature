Feature: F01_Add product to cart  functionality

  Scenario: user add product to cart
    Given user go to categories screen
    When  user choose category list
    And   user select sub category
    And   user select product
    And   user select color
    And   user add item to the cart
    Then  item should be added successfully to the cart