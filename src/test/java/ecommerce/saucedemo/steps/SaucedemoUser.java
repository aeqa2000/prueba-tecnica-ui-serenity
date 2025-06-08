package ecommerce.saucedemo.steps;

import ecommerce.saucedemo.pageobject.SaucedemoHomePage;
import ecommerce.saucedemo.pageobject.SaucedemoLoginPage;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;

public class SaucedemoUser {

    String actor;

    SaucedemoLoginPage loginPage;
    SaucedemoHomePage homePage;

    @Step("#actor go to Saucedemo login page")
    public SaucedemoUser goToSaucedemo() {
        loginPage.open();
        return this;
    }

    @Step("#actor ingress valid credentials: {0} / {1}")
    public SaucedemoUser ingressValidCredentials(String username, String password) {
        loginPage.ingressCredentials(username, password);
        return this;
    }

    @Step("#actor ingress invalid credentials: {0} / {1}")
    public SaucedemoUser ingressInvalidCredentials(String username, String password) {
        loginPage.ingressCredentials(username, password);
        return this;
    }

    @Step("#actor click on the login button")
    public SaucedemoUser clickLoginButton() {
        loginPage.clickLoginButton();
        return this;
    }

    @Step("#actor verify login success with assertion: {0}")
    public SaucedemoUser verifyLoginSuccess(String assertion) {
        Assert.assertEquals(assertion, homePage.returnLoginSuccessTitle());
        return this;
    }

    @Step("#actor verify login failure that contains this message: {0}")
    public SaucedemoUser verifyLoginFailure(String message) {
        Assert.assertTrue(homePage.returnLoginFailedMessage(message).contains(message));
        return this;
    }

}
