package ecommerce.saucedemo.screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class DisplayedTitle {

    public static Question<String> of(Target locator) {
        return actor ->
                Text.of(locator)
                        .answeredBy(actor);   // ← aquí también
    }
}