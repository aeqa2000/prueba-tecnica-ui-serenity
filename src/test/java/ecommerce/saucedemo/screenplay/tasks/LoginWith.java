package ecommerce.saucedemo.screenplay.tasks;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import ecommerce.saucedemo.screenplay.ui.LoginPage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginWith implements Task {
    private final String user, pass;

    public LoginWith(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }

    public static LoginWith credentials(String user, String pass) {
        return Tasks.instrumented(LoginWith.class, user, pass);
    }

    @Override
    public <T extends net.serenitybdd.screenplay.Actor> void performAs(T actor) {
        actor.attemptsTo(
                // espero a que esté visible, como hacías con waitUntilVisible()
                WaitUntil.the(LoginPage.USERNAME, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(user).into(LoginPage.USERNAME),

                WaitUntil.the(LoginPage.PASSWORD, isVisible()).forNoMoreThan(5).seconds(),
                Enter.theValue(pass).into(LoginPage.PASSWORD),

                WaitUntil.the(LoginPage.LOGIN_BUTTON, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }
}