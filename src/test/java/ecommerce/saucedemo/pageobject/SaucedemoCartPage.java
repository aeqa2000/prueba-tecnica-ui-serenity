package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SaucedemoCartPage extends PageObject {

    private String productName;

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public String getSpanProductName() {
        return findBy("//div[text()='{0}']", getProductName()).waitUntilVisible().then().getText();
    }

    public void clickCheckoutButton() {
        checkoutButton.waitUntilVisible();
        checkoutButton.click();
    }

}
