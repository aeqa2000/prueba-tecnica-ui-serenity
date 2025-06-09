package ecommerce.saucedemo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import ecommerce.saucedemo.screenplay.ui.HomePage;

public class CartBadgeCount {

    public static Question<Integer> value() {
        return actor -> {
            try {
                // Intentamos leer el badge como antes
                String text = Text.of(HomePage.CART_BADGE_NUMBER)
                        .answeredBy(actor)
                        .trim();
                // Si llegase vacío o mal formado, fallaría aquí
                return Integer.parseInt(text);
            } catch (Exception e) {
                // Igual que catch de PageObject: sin badge ⇒ 0
                return 0;
            }
        };
    }
}