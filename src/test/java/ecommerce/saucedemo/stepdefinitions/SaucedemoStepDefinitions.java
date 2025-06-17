package ecommerce.saucedemo.stepdefinitions;

import ecommerce.saucedemo.screenplay.tasks.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.*;

import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;

import ecommerce.saucedemo.screenplay.ui.LoginPage;
import ecommerce.saucedemo.screenplay.ui.HomePage;
import ecommerce.saucedemo.screenplay.ui.CartPage;
import ecommerce.saucedemo.screenplay.ui.CheckoutPage;
import ecommerce.saucedemo.screenplay.questions.DisplayedTitle;
import ecommerce.saucedemo.screenplay.questions.CartBadgeCount;
import ecommerce.saucedemo.screenplay.questions.ThankYouMessage;

public class SaucedemoStepDefinitions {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^\"([^\"]*)\" navigates to: (.*)$")
    public void go_to_saucedemo(String actor, String url) {
        String fullUrl = url.startsWith("http") ? url : "https://" + url;
        OnStage.theActorCalled(actor)
                .wasAbleTo(Open.url(fullUrl));
    }

    @When("{string} enter {string} in the field Username and enter {string} in the field Password")
    public void ingress_credentials(String actor, String user, String pass) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        LoginWith.credentials(user,pass)
                );
    }

    @And("{string} clicks on the button Login")
    public void click_login_button(String actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        WaitUntil.the(LoginPage.LOGIN_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(LoginPage.LOGIN_BUTTON)
                );
    }

    @Then("{string} should sees the title: {string} in the current page")
    public void verify_login_success(String actor, String expectedTitle) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(DisplayedTitle.of(HomePage.TITLE),
                                equalTo(expectedTitle))
                );
    }

    @Then("{string} should sees the message: {string}")
    public void verify_login_failure(String actor, String message) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(DisplayedTitle.of(HomePage.ERROR_MESSAGE),
                                containsString(message))
                );
    }

    @And("{string} should see the initial number of items in the cart")
    public void get_initial_add_cart_number_of_items(String actor) {
        int initial = CartBadgeCount.value()
                .answeredBy(OnStage.theActorInTheSpotlight());
        OnStage.theActorInTheSpotlight().remember("initialCount", initial);
    }

    @And("{string} clicks on the button Add to cart for product: {string}")
    public void click_add_to_cart_button(String actor, String product) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        AddToCart.item(product)
                );
    }

    @Then("{string} should see that the number of items in the cart is added by 1")
    public void verify_number_of_items_in_cart(String actor) {
        int initial = OnStage.theActorInTheSpotlight().recall("initialCount");
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(CartBadgeCount.value(),
                                equalTo(initial + 1))
                );
    }

    @And("{string} clicks on the button Cart")
    public void click_on_cart_button(String actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        OpenCart.now()
                );
    }

    @And("{string} verifies that the cart contains item: {string}")
    public void verify_cart_contains_item(String actor, String product) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(DisplayedTitle.of(CartPage.PRODUCT_NAME.of(product)),
                                equalTo(product))
                );
    }

    @And("{string} clicks on the button Checkout")
    public void click_checkout_button(String actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        StartCheckout.now()
                );
    }

    @And("{string} enters {string} in the field First Name")
    public void enter_first_name(String actor, String firstName) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        CheckoutInformation.with(firstName,null,null)
                );
    }

    @And("{string} enters {string} in the field Last Name")
    public void enter_last_name(String actor, String lastName) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        CheckoutInformation.with(null,lastName,null)
                );
    }

    @And("{string} enters {string} in the field Postal Code")
    public void enter_postal_code(String actor, String postalCode) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        CheckoutInformation.with(null,null,postalCode)
                );
    }

    @And("{string} clicks on the button Continue")
    public void click_continue_button(String actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        WaitUntil.the(CheckoutPage.CONTINUE_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                        Click.on(CheckoutPage.CONTINUE_BUTTON)
                );
    }

    @And("{string} should see the title: {string}")
    public void verify_checkout_overview_title(String actor, String expected) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(DisplayedTitle.of(CheckoutPage.OVERVIEW_TITLE),
                                equalTo(expected))
                );
    }

    @And("{string} clicks on the button Finish")
    public void click_finish_button(String actor) {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        FinishOrder.now()
                );
    }

    @Then("{string} should see the message: {string}")
    public void verify_thank_you_message(String actor, String expectedMessage) {
        OnStage.theActorInTheSpotlight()
                .should(
                        seeThat(ThankYouMessage.displayed(),
                                equalTo(expectedMessage))
                );
    }
}