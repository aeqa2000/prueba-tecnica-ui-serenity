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

    @And("{string} should see the initial number of items in the cart")
    public void get_initial_add_cart_number_of_items(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.getInitialAddCartNumberOfItems();
    }

    @And("{string} clicks on the button Add to cart for product: {string}")
    public void click_add_to_cart_button(String nameOfUser, String productName) {
        user.isCalled(nameOfUser);
        user.clickAddToCartButton(productName);
    }

    @Then("{string} should see that the number of items in the cart is added by 1")
    public void verify_number_of_items_in_cart(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.verifyNumberOfItemsInCart();
    }

    @And("{string} clicks on the button Cart")
    public void click_on_cart_button(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.clickOnCartButton();
    }

    @And("{string} verifies that the cart contains item: {string}")
    public void verify_cart_contains_item(String nameOfUser, String productName) {
        user.isCalled(nameOfUser);
        user.verifyProductInCart(productName);
    }

    @And("{string} clicks on the button Checkout")
    public void click_checkout_button(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.clickCheckoutButton();
    }

    @And("{string} enters {string} in the field First Name")
    public void enter_first_name(String nameOfUser, String firstName) {
        user.isCalled(nameOfUser);
        user.enterFirstName(firstName);
    }

    @And("{string} enters {string} in the field Last Name")
    public void enter_last_name(String nameOfUser, String lastName) {
        user.isCalled(nameOfUser);
        user.enterLastName(lastName);
    }

    @And("{string} enters {string} in the field Postal Code")
    public void enter_postal_code(String nameOfUser, String postalCode) {
        user.isCalled(nameOfUser);
        user.enterPostalCode(postalCode);
    }

    @And("{string} clicks on the button Continue")
    public void click_continue_button(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.clickContinueButton();
    }

    @And("{string} should see the title: {string}")
    public void verify_checkout_overview_title(String nameOfUser, String assertion) {
        user.isCalled(nameOfUser);
        user.verifyCheckoutOverviewTitle(assertion);
    }

    @And("{string} clicks on the button Finish")
    public void click_finish_button(String nameOfUser) {
        user.isCalled(nameOfUser);
        user.clickFinishButton();
    }

    @Then("{string} should see the message: {string}")
    public void verify_thank_you_message(String nameOfUser, String message) {
        user.isCalled(nameOfUser);
        user.verifyThankYouMessage(message);
    }

}
