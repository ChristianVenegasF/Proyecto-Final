package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.CheckoutPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import net.serenitybdd.annotations.Steps; // CAMBIADO
import static org.assertj.core.api.Assertions.assertThat;

public class CartSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    ProductsPage productsPage;

    @Steps
    CartPage cartPage;

    @Steps
    CheckoutPage checkoutPage;

    @Given("el usuario ha iniciado sesión exitosamente")
    public void userHasLoggedIn() {
        loginPage.openApplication();
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();
    }

    @When("agrega el producto {string} al carrito")
    public void addProductToCart(String productName) {
        productsPage.addProductToCart(productName);
    }

    @When("accede al carrito de compras")
    public void goToCart() {
        productsPage.goToCart();
    }

    @Then("el producto {string} debe estar en el carrito")
    public void productShouldBeInCart(String productName) {
        assertThat(cartPage.isProductInCart(productName)).isTrue();
    }

    @When("remueve el producto {string} del carrito")
    public void removeProductFromCart(String productName) {
        cartPage.removeProduct(productName);
    }

    @Then("el carrito debe estar vacío")
    public void cartShouldBeEmpty() {
        assertThat(cartPage.getCartItemCount()).isEqualTo(0);
    }

    @When("inicia el proceso de checkout")
    public void startCheckoutProcess() {
        cartPage.clickCheckout();
    }

    @Then("debe estar en la página de información de checkout")
    public void shouldBeOnCheckoutInfoPage() {
        assertThat(checkoutPage.isOnCheckoutStepOne()).isTrue();
    }
}