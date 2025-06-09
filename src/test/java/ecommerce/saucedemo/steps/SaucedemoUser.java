package ecommerce.saucedemo.steps;

import ecommerce.saucedemo.pageobject.SaucedemoHomePage;
import ecommerce.saucedemo.pageobject.SaucedemoLoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class SaucedemoUser {

    String actor;

    @Steps
    SaucedemoLoginPage loginPage;

    @Steps
    SaucedemoHomePage homePage;

    @Given("I navigate to: www.saucedemo.com")
    public SaucedemoUser go_to_saucedemo() {
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
        return this;
    }

    @When("I enter {string} in the field Username and I enter {string} in the field Password")
    public SaucedemoUser ingress_credentials(String username, String password) {
        loginPage.ingressCredentials(username, password);
        return this;
    }

    @And("I click on the button Login")
    public SaucedemoUser click_login_button() {
        loginPage.clickLoginButton();
        return this;
    }

    @Then("I should see the title: {string} in the current page")
    public SaucedemoUser verify_login_success(String assertion) {
        Assert.assertEquals(assertion, homePage.returnLoginSuccessTitle());
        return this;
    }

    @Then("I should see the message: {string}")
    public SaucedemoUser verify_login_failure(String message) {
        Assert.assertTrue(homePage.returnLoginFailedMessage(message).contains(message));
        return this;
    }

}
