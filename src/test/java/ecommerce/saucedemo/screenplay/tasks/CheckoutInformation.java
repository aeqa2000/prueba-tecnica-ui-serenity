package ecommerce.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ecommerce.saucedemo.screenplay.ui.CheckoutPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CheckoutInformation implements Task {
    private final String first, last, postal;

    public CheckoutInformation(String first, String last, String postal) {
        this.first = first;
        this.last = last;
        this.postal = postal;
    }

    public static CheckoutInformation with(String first, String last, String postal) {
        return Tasks.instrumented(CheckoutInformation.class, first, last, postal);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        if (first != null) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.FIRST_NAME_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                    Enter.theValue(first).into(CheckoutPage.FIRST_NAME_FIELD)
            );
        }
        if (last != null) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.LAST_NAME_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                    Enter.theValue(last).into(CheckoutPage.LAST_NAME_FIELD)
            );
        }
        if (postal != null) {
            actor.attemptsTo(
                    WaitUntil.the(CheckoutPage.POSTAL_CODE_FIELD, isVisible()).forNoMoreThan(5).seconds(),
                    Enter.theValue(postal).into(CheckoutPage.POSTAL_CODE_FIELD)
            );
        }
        // el click Continue
        actor.attemptsTo(
                WaitUntil.the(CheckoutPage.CONTINUE_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(CheckoutPage.CONTINUE_BUTTON)
        );
    }
}