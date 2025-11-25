package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageObject {

    @FindBy(id = "first-name")
    WebElementFacade firstNameField;

    @FindBy(id = "last-name")
    WebElementFacade lastNameField;

    @FindBy(id = "postal-code")
    WebElementFacade postalCodeField;

    @FindBy(id = "continue")
    WebElementFacade continueButton;

    @FindBy(id = "finish")
    WebElementFacade finishButton;

    @FindBy(className = "complete-header")
    WebElementFacade confirmationMessage;

    @FindBy(css = "[data-test='error']")
    WebElementFacade errorMessage;

    @FindBy(className = "cart_button")
    WebElementFacade cancelButton;

    public void enterFirstName(String firstName) {
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        postalCodeField.type(postalCode);
    }

    public void enterPersonalInfo(String firstName, String lastName, String postalCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        finishButton.click();
    }

    public void clickCancel() {
        cancelButton.click();
    }

    public String getConfirmationMessage() {
        waitFor(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }

    public String getErrorMessage() {
        waitFor(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isOnCheckoutStepOne() {
        return getDriver().getCurrentUrl().contains("checkout-step-one");
    }

    public boolean isOnCheckoutComplete() {
        return getDriver().getCurrentUrl().contains("checkout-complete");
    }
}