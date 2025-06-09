package ecommerce.saucedemo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ecommerce.saucedemo.screenplay.ui.CheckoutPage;

public class ThankYouMessage {

    public static Question<String> displayed() {
        return actor ->
                Text.of(CheckoutPage.THANK_YOU_MESSAGE)
                        .answeredBy(actor);  // ← y aquí
    }
}