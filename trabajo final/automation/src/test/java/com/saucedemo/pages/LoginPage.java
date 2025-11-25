package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

    @FindBy(id = "user-name")
    WebElementFacade usernameField;

    @FindBy(id = "password")
    WebElementFacade passwordField;

    @FindBy(id = "login-button")
    WebElementFacade loginButton;

    @FindBy(css = "[data-test='error']")
    WebElementFacade errorMessage;

    public void openApplication() {
        openUrl("https://www.saucedemo.com/");
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public String getErrorMessage() {
        waitFor(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.getText();
    }

    public boolean isOnProductsPage() {
        return getDriver().getCurrentUrl().contains("inventory.html");
    }
}