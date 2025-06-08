package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class SaucedemoHomePage extends PageObject {

    @FindBy(xpath = "//span[text()='Products']")
    WebElementFacade productsTitle;

    public void verifyLoginSuccess(String assertion) {
        Assert.assertEquals("The login was not successful", assertion, productsTitle.getText());
    }

}
