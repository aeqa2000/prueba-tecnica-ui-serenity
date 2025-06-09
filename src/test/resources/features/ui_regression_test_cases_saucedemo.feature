
@Cucumber
Feature: I try to login to the Saucedemo application

  Background:
    Given I navigate to: www.saucedemo.com

  Scenario: I try to login with valid credentials
    When I enter "standard_user" in the field Username and I enter "secret_sauce" in the field Password
    And I click on the button Login
    Then I should see the title: "Products" in the current page

  Scenario: I try to login with invalid credentials
    When I enter "standard_user" in the field Username and I enter "wrong_password" in the field Password
    And I click on the button Login
    Then I should see the message: "Epic sadface: Username and password do not match any user in this service"