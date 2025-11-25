package com.saucedemo.steps;

import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.ProductsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps; // CAMBIADO
import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    @Steps
    LoginPage loginPage;

    @Steps
    ProductsPage productsPage;

    @Given("el usuario está en la página de login de SauceDemo")
    public void userIsOnLoginPage() {
        loginPage.openApplication();
    }

    @When("ingresa el usuario {string} y contraseña {string}")
    public void enterCredentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("hace clic en el botón Login")
    public void clickLoginButton() {
        loginPage.clickLogin();
    }

    @Then("debe redirigirse a la página de productos")
    public void shouldBeRedirectedToProductsPage() {
        assertThat(loginPage.isOnProductsPage()).isTrue();
        assertThat(productsPage.getPageTitle()).isEqualTo("Products");
    }

    @Then("debe mostrar un mensaje de error {string}")
    public void shouldShowErrorMessage(String expectedMessage) {
        String actualMessage = loginPage.getErrorMessage();
        assertThat(actualMessage).contains(expectedMessage);
    }
}