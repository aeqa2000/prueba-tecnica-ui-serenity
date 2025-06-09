package ecommerce.saucedemo.pageobject;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class SaucedemoCheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade firstNameField;

    @FindBy(id = "last-name")
    WebElementFacade lastNameField;

    @FindBy(id = "postal-code")
    WebElementFacade postalCodeField;

    @FindBy(id = "continue")
    WebElementFacade continueButton;

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    WebElementFacade checkoutOverviewTitle;

    @FindBy(id = "finish")
    WebElementFacade finishButton;

    @FindBy(xpath = "//h2[text()='thank you for your order!']")
    WebElementFacade thankYouMessage;

    public void enterFirstName(String firstName) {
        firstNameField.waitUntilVisible();
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.waitUntilVisible();
        lastNameField.type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.waitUntilVisible();
        postalCodeField.type(postalCode);
    }

    public void clickContinueButton() {
        continueButton.waitUntilVisible();
        continueButton.click();
    }

    public String getCheckoutOverviewTitle() {
        checkoutOverviewTitle.waitUntilVisible();
        return checkoutOverviewTitle.getText();
    }

    public void clickFinishButton() {
        finishButton.waitUntilVisible();
        finishButton.click();
    }

    public String getThankYouMessage() {
        thankYouMessage.waitUntilVisible();
        return thankYouMessage.getText();
    }

}
