package ecommerce.saucedemo.steps;

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

}
