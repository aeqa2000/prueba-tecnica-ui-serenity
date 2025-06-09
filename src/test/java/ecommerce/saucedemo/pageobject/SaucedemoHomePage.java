package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SaucedemoHomePage extends PageObject {

    public static final String assertLoginSuccessTitle = "//span[text()='Products']";
    public static final String assertLoginFailedMessage = "//h3[@data-test='error' and contains(.,'{0}')]";
    public static final String addToCartButton = "//div[text()='{0}']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    @FindBy(css = ".shopping_cart_badge")
    WebElementFacade cartBadgeNumber;

    @FindBy(className = "shopping_cart_link")
    WebElementFacade cartBadge;

    public String returnLoginSuccessTitle() {
        return findBy(assertLoginSuccessTitle).waitUntilVisible().then().getText();
    }

    public String returnLoginFailedMessage(String message) {
        return findBy(assertLoginFailedMessage, message).waitUntilVisible().then().getText();
    }

    public void clickOnAddToCartButton(String productName) {
        findBy(addToCartButton, productName).then().click();
    }

    public int getAddNumberOfItemsInCart() {
        String cartCount = "";
        try{
            cartBadgeNumber.waitUntilVisible();
            cartCount = findBy(".shopping_cart_badge").then().getText();
        }catch (Exception e) {
            // If the cart badge is not present, it means there are no items in the cart
            cartCount = "0";
        }
        return Integer.parseInt(cartCount);
    }

    public void clickOnCartButton() {
        cartBadgeNumber.waitUntilVisible();
        cartBadge.click();
    }
}
