package ecommerce.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CartPage {
    public static final Target PRODUCT_NAME =
            Target.the("product name in cart").locatedBy("//div[text()='{0}']");
    public static final Target CHECKOUT_BUTTON =
            Target.the("checkout button").locatedBy("#checkout");
}