package ecommerce.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ecommerce.saucedemo.screenplay.ui.HomePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddToCart implements Task {
    private final String product;

    public AddToCart(String product) {
        this.product = product;
    }

    public static AddToCart item(String product) {
        return Tasks.instrumented(AddToCart.class, product);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                // aseguro que el botón exista y sea visible
                WaitUntil.the(HomePage.ADD_TO_CART_BUTTON(product), isVisible()).forNoMoreThan(5).seconds(),
                Click.on(HomePage.ADD_TO_CART_BUTTON(product))
        );
    }
}