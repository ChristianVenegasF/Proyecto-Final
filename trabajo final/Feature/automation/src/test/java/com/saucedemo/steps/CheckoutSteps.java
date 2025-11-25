package com.saucedemo.steps;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps; // CAMBIADO
import static org.assertj.core.api.Assertions.assertThat;

public class CheckoutSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    ProductsPage productsPage;

    @Steps
    CartPage cartPage;

    @Steps
    CheckoutPage checkoutPage;

    @Given("el usuario ha agregado un producto al carrito")
    public void userHasAddedProductToCart() {
        productsPage.addProductToCart("Sauce Labs Backpack");
    }

    @When("completa el checkout con {string} {string} {string}")
    public void completeCheckout(String firstName, String lastName, String postalCode) {
        checkoutPage.enterPersonalInfo(firstName, lastName, postalCode);
        checkoutPage.clickContinue();
        checkoutPage.clickFinish();
    }

    @When("intenta completar el checkout sin ingresar datos")
    public void tryCheckoutWithoutData() {
        checkoutPage.clickContinue();
    }

    @Then("debe ver la página de confirmación con el mensaje {string}")
    public void shouldSeeConfirmationMessage(String expectedMessage) {
        assertThat(checkoutPage.isOnCheckoutComplete()).isTrue();
        String actualMessage = checkoutPage.getConfirmationMessage();
        assertThat(actualMessage).isEqualTo(expectedMessage);
    }

    @Then("debe mostrar un mensaje de error en checkout {string}")
    public void shouldShowCheckoutErrorMessage(String expectedMessage) {
        String actualMessage = checkoutPage.getErrorMessage();
        assertThat(actualMessage).contains(expectedMessage);
    }

    @And("ha agregado un producto al carrito")
    public void hasAddedProductToCart() {
        productsPage.addProductToCart("Sauce Labs Backpack");
    }
}