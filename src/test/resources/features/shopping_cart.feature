Feature: Work with cart

  Scenario Outline: Cart Page Opens After Adding New Product
    Given I perform search of "<product>"
    When I add first product to the cart
    Then Cart page should open

    Examples:
      | product            |
      | Xiaomi Yi          |
      | Xiaomi Mi Band 2   |
      | AMD Ryzen 7 1800X  |

  Scenario: Shopping Cart Is Empty After Deleting All Items
    Given I open cart page
    And Cart is not empty
    When I delete all products from cart
    Then Cart is empty

  Scenario Outline: Product Is In Cart After Adding
    Given I perform search of "<product>"
    When I add first product to the cart
    Then "<product>" is in the cart

    Examples:
      | product             |
      | Intel Core i7-7700K |

  Scenario: Increasing Quantity Increasing Total Cost
    Given I open cart page
    And Cart is not empty
    When I increase quantity of product by 1
    Then Cost should grow

  Scenario: Decreasing Quantity Decreasing Total Cost
    Given I open cart page
    And Cart is not empty
    And Quantity of product is more then 1
    When I decrease quantity of product by 1
    Then Cost should fall
    And I delete all products from cart