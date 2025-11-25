package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class CartPage extends PageObject {

    @FindBy(className = "cart_item")
    List<WebElementFacade> cartItems;

    @FindBy(id = "checkout")
    WebElementFacade checkoutButton;

    @FindBy(className = "cart_button")
    List<WebElementFacade> removeButtons;

    public boolean isProductInCart(String productName) {
        for (WebElementFacade item : cartItems) {
            if (item.findBy(".inventory_item_name").getText().equals(productName)) {
                return true;
            }
        }
        return false;
    }

    public void clickCheckout() {
        checkoutButton.click();
    }

    public void removeProduct(String productName) {
        for (int i = 0; i < cartItems.size(); i++) {
            WebElementFacade item = cartItems.get(i);
            if (item.findBy(".inventory_item_name").getText().equals(productName)) {
                // Usar el selector correcto para el botón de remover
                item.findBy("button[class*='btn']").click();
                break;
            }
        }
    }

    public int getCartItemCount() {
        return cartItems.size();
    }
}