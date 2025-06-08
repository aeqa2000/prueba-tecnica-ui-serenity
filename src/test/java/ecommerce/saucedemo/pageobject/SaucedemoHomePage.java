package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;

public class SaucedemoHomePage extends PageObject {

    public static final String assertLoginSuccessTitle = "//span[text()='Products']";
    public static final String assertLoginFailedMessage = "//h3[@data-test='error' and contains(.,'{0}')]";

    public String returnLoginSuccessTitle() {
        return findBy(assertLoginSuccessTitle).then().getText();
    }

    public String returnLoginFailedMessage(String message) {
        return findBy(assertLoginFailedMessage, message).then().getText();
    }
}
