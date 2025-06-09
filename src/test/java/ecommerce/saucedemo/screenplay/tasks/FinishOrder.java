package ecommerce.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ecommerce.saucedemo.screenplay.ui.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class FinishOrder implements Task {
    public static FinishOrder now() {
        return Tasks.instrumented(FinishOrder.class);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.FINISH_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(CheckoutPage.FINISH_BUTTON)
        );
    }
}