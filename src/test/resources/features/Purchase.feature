Feature: The user should be able to place order from the website
@purchase
  Scenario: Placing a successful order
    Given The user is on the login page
    And The user enters "metehanmar" and "12345mete" credential
    When The user adds "Iphone 6 32gb" from "Phones"
    And The user adds "Sony vaio i5" from "Laptops"
    And The user adds "MacBook Pro" from "Laptops"
    And The user adds "Apple monitor 24" from "Monitors"
    And The user removes "Sony vaio i5" from Cart
    And The user places order and captures and log amounts
    Then The user verifies purchase amount
