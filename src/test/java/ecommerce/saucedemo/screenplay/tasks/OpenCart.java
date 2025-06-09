package ecommerce.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ecommerce.saucedemo.screenplay.ui.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenCart implements Task {
    public static OpenCart now() {
        return Tasks.instrumented(OpenCart.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(HomePage.CART_ICON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(HomePage.CART_ICON)
        );
    }
}