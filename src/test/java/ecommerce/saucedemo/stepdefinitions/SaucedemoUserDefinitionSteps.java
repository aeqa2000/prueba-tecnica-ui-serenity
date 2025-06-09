package ecommerce.saucedemo.stepdefinitions;

import ecommerce.saucedemo.steps.SaucedemoUser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import org.junit.Assert;

public class SaucedemoUserDefinitionSteps {

    @Steps(shared = true)
    SaucedemoUser user;

    @Given("{string} navigates to: www.saucedemo.com")
    public void go_to_saucedemo(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.goToSaucedemo();
    }

    @When("{string} enter {string} in the field Username and enter {string} in the field Password")
    public void ingress_credentials(String nameOfUser, String username, String password) {
        user.isCalled(nameOfUser);
        user.ingressCredentials(username, password);
    }

    @And("{string} clicks on the button Login")
    public void click_login_button(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.clickLoginButton();
    }

    @Then("{string} should sees the title: {string} in the current page")
    public void verify_login_success(String nameOfUser, String assertion) {
        user.isCalled(nameOfUser);
        user.verifyLoginSuccess(assertion);
    }

    @Then("{string} should sees the message: {string}")
    public void verify_login_failure(String nameOfUser, String message) {
        user.isCalled(nameOfUser);
        user.verifyLoginFailure(message);
    }

}
