package ecommerce.saucedemo.tests;

import ecommerce.saucedemo.steps.SaucedemoUser;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public class WhenWeLoginWithValidCredentials {

    @Steps
    SaucedemoUser arley;

    @Test
    public void shouldLoginSuccessfully() {

        arley.goToSaucedemo()
                .ingressValidCredentials("standard_user", "secret_sauce")
                .clickLoginButton()
                .verifyLoginSuccess("Products");
    }

}
