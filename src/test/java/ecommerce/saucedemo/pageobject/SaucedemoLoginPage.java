package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SaucedemoLoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade usernameField;

    @FindBy(id = "password")
    WebElementFacade passwordField;

    //se usa xpath con el fin de mostrar un ejemplo de uso de este tipo de localizador
    @FindBy(xpath = "//input[@type='submit']")
    WebElementFacade loginButton;

    public void ingressCredentials(String username, String password) {
        usernameField.type(username);
        passwordField.type(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

}
