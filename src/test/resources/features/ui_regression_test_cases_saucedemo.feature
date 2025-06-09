
@Cucumber
Feature: I try to login to the Saucedemo application

  Background:
    Given I navigate to: www.saucedemo.com

  Scenario Template: : I try to login with valid credentials
    When I enter "<username>" in the field Username and I enter "<password>" in the field Password
    And I click on the button Login
    Then I should see the title: "Products" in the current page

    Examples:
        | username        | password      |
        | standard_user   | secret_sauce  |
        | problem_user    | secret_sauce  |
        | performance_glitch_user | secret_sauce |

  Scenario Template: I try to login with invalid credentials
    When I enter "<username>" in the field Username and I enter "<password>" in the field Password
    And I click on the button Login
    Then I should see the message: "Epic sadface: Username and password do not match any user in this service"

    Examples:
      | username      | password       |
      | wrong_user    | secret_sauce   |
      | standard_user | wrong_password |
      | wrong_user    | wrong_password |

