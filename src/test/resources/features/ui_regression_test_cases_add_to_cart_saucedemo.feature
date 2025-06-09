@Cucumber
Feature: Arley tries to aggregate products in the cart

  Background:
    Given "Arley" navigates to: www.saucedemo.com

  @Regression
  Scenario Template: Arley adds products to the cart and checks the cart badge

    When "Arley" enter "standard_user" in the field Username and enter "secret_sauce" in the field Password
    And "Arley" clicks on the button Login
    And "Arley" should see the initial number of items in the cart
    And "Arley" clicks on the button Add to cart for product: "<product>"
    Then "Arley" should see that the number of items in the cart is added by 1

    Examples:
      | product                |
      | Sauce Labs Backpack    |
      | Sauce Labs Bike Light  |
      | Sauce Labs Bolt T-Shirt|

  @Regression
  Scenario: Arley completes the checkout process

    When "Arley" enter "standard_user" in the field Username and enter "secret_sauce" in the field Password
    And "Arley" clicks on the button Login
    And "Arley" clicks on the button Add to cart for product: "Sauce Labs Backpack"
    And "Arley" clicks on the button Cart
    And "Arley" verifies that the cart contains item: "Sauce Labs Backpack"
    And "Arley" clicks on the button Checkout
    And "Arley" enters "Esteban" in the field First Name
    And "Arley" enters "Quintero" in the field Last Name
    And "Arley" enters "12345" in the field Postal Code
    And "Arley" clicks on the button Continue
    Then "Arley" should see the title: "Checkout: Overview"
    And "Arley" clicks on the button Finish
    Then "Arley" should see the message: "Thank you for your order!"