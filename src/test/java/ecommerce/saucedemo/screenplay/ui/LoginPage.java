package ecommerce.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {

    public static final Target USERNAME =
            Target.the("username field")
                    .locatedBy("#user-name");

    public static final Target PASSWORD =
            Target.the("password field")
                    .locatedBy("#password");

    // Volvemos al XPath que funciona en tu aplicación
    public static final Target LOGIN_BUTTON =
            Target.the("login button")
                    .locatedBy("//input[@type='submit']");
}