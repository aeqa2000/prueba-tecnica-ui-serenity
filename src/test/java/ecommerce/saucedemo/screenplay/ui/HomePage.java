package ecommerce.saucedemo.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;

public class HomePage {

    public static final Target TITLE =
            Target.the("Products title")
                    .locatedBy("//span[text()='Products']");

    public static final Target ERROR_MESSAGE =
            Target.the("error message")
                    .locatedBy("//h3[@data-test='error']");

    public static Target ADD_TO_CART_BUTTON(String productName) {
        return Target.the("add to cart for " + productName)
                .locatedBy("//div[text()='{0}']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']")
                .of(productName);
    }

    public static final Target CART_BADGE_NUMBER =
            Target.the("cart badge number")
                    .locatedBy(".shopping_cart_badge");

    public static final Target CART_ICON =
            Target.the("cart icon")
                    .locatedBy(".shopping_cart_link");
}