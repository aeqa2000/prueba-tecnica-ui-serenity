package ecommerce.saucedemo.steps;

import ecommerce.saucedemo.pageobject.SaucedemoHomePage;
import ecommerce.saucedemo.pageobject.SaucedemoLoginPage;
import net.serenitybdd.annotations.Step;

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
        loginPage.ingressValidCredentials(username, password);
        return this;
    }

    @Step("#actor click on the login button")
    public SaucedemoUser clickLoginButton() {
        loginPage.clickLoginButton();
        return this;
    }

    @Step("#actor verify login success with assertion: {0}")
    public SaucedemoUser verifyLoginSuccess(String assertion) {
        homePage.verifyLoginSuccess(assertion);
        return this;
    }

}
