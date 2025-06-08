package ecommerce.saucedemo.tests;

import ecommerce.saucedemo.steps.SaucedemoUser;
import net.serenitybdd.annotations.Steps;
import org.junit.jupiter.api.Test;

public class WhenWeLoginWithInvalidCredentials {

    @Steps
    SaucedemoUser arley;

    @Test()
    public void shouldNotLogin() {

        arley.goToSaucedemo()
                .ingressInvalidCredentials("standard_user", "wrong_password")
                .clickLoginButton()
                .verifyLoginFailure("Epic sadface");
    }

}
