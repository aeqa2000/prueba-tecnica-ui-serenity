
@Cucumber
Feature: Arley tries to login to the Saucedemo application

  Background:
    Given "Arley" navigates to: www.saucedemo.com

  @Regression
  Scenario Template: Arley tries to login with valid credentials
    When "Arley" enter "<username>" in the field Username and enter "<password>" in the field Password
    And "Arley" clicks on the button Login
    Then "Arley" should sees the title: "Products" in the current page

    Examples:
        | username        | password      |
        | standard_user   | secret_sauce  |
        | problem_user    | secret_sauce  |
        | performance_glitch_user | secret_sauce |

  @Regression
  Scenario Template: Arley tries to login with invalid credentials
    When "Arley" enter "<username>" in the field Username and enter "<password>" in the field Password
    And "Arley" clicks on the button Login
    Then "Arley" should sees the message: "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username      | password       |
      | wrong_user    | secret_sauce   |
      | standard_user | wrong_password |
      | wrong_user    | wrong_password |