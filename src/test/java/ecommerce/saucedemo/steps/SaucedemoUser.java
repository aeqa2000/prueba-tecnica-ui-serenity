package ecommerce.saucedemo.steps;

import ecommerce.saucedemo.pageobject.SaucedemoCartPage;
import ecommerce.saucedemo.pageobject.SaucedemoCheckoutPage;
import ecommerce.saucedemo.pageobject.SaucedemoHomePage;
import ecommerce.saucedemo.pageobject.SaucedemoLoginPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.core.steps.ScenarioActor;
import org.junit.Assert;

public class SaucedemoUser extends ScenarioActor {

    String actor;

    @Steps(shared = true)
    SaucedemoLoginPage loginPage;

    @Steps(shared = true)
    SaucedemoHomePage homePage;

    @Steps(shared = true)
    SaucedemoCartPage cartPage;

    @Steps(shared = true)
    SaucedemoCheckoutPage checkoutPage;

    int numberOfItemsInCart;

    @Step("#actor go to Saucedemo login page")
    public void goToSaucedemo() {
        loginPage.setDefaultBaseUrl("https://www.saucedemo.com/");
        loginPage.open();
    }

    @Step("#actor ingress credentials: {0} / {1}")
    public void ingressCredentials(String username, String password) {
        loginPage.ingressCredentials(username, password);
    }

    @Step("#actor click on the login button")
    public void clickLoginButton() {
        loginPage.clickLoginButton();
    }

    @Step("#actor verify login success with assertion: {0}")
    public void verifyLoginSuccess(String assertion) {
        Assert.assertEquals(assertion, homePage.returnLoginSuccessTitle());
    }

    @Step("#actor verify login failure that contains this message: {0}")
    public void verifyLoginFailure(String message) {
        Assert.assertTrue(homePage.returnLoginFailedMessage(message).contains(message));
    }

    @Step("#actor gets the initial add cart number of items")
    public void getInitialAddCartNumberOfItems() {
        numberOfItemsInCart = homePage.getAddNumberOfItemsInCart();
    }

    @Step("#actor clicks on the button Add to cart for product: {0}")
    public void clickAddToCartButton(String productName) {
        homePage.clickOnAddToCartButton(productName);
        cartPage.setProductName(productName);
    }

    @Step("#actor verifies that the number of items in the cart is: {0}")
    public void verifyNumberOfItemsInCart() {
        Assert.assertEquals(numberOfItemsInCart+1, homePage.getAddNumberOfItemsInCart());
    }

    @Step("#actor clicks on the cart button")
    public void clickOnCartButton() {
        homePage.clickOnCartButton();
    }

    @Step("#actor verifies that the product {0} is in the cart")
    public void verifyProductInCart(String productName) {
        Assert.assertEquals(productName, cartPage.getSpanProductName());
    }

    @Step("#actor clicks on the checkout button")
    public void clickCheckoutButton() {
        cartPage.clickCheckoutButton();
    }

    @Step("#actor enters our first name: {0}")
    public void enterFirstName(String firstName) {
        checkoutPage.enterFirstName(firstName);
    }

    @Step("#actor enters our last name: {0}")
    public void enterLastName(String lastName) {
        checkoutPage.enterLastName(lastName);
    }

    @Step("#actor enters our postal code: {0}")
    public void enterPostalCode(String postalCode) {
        checkoutPage.enterPostalCode(postalCode);
    }

    @Step("#actor clicks on the continue button")
    public void clickContinueButton() {
        checkoutPage.clickContinueButton();
    }

    @Step("#actor verifies that the checkout overview title is: {0}")
    public void verifyCheckoutOverviewTitle(String expectedTitle) {
        Assert.assertEquals(expectedTitle, checkoutPage.getCheckoutOverviewTitle());
    }

    @Step("#actor clicks on the finish button")
    public void clickFinishButton() {
        checkoutPage.clickFinishButton();
    }

    @Step("#actor verifies that the thank you message is: {0}")
    public void verifyThankYouMessage(String expectedMessage) {
        Assert.assertEquals(expectedMessage, checkoutPage.getThankYouMessage());
    }

}
