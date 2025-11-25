package com.saucedemo.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;

public class ProductsPage extends PageObject {

    @FindBy(className = "inventory_item")
    List<WebElementFacade> productItems;

    @FindBy(css = ".shopping_cart_link")
    WebElementFacade cartIcon;

    @FindBy(className = "title")
    WebElementFacade pageTitle;

    public void addProductToCart(String productName) {
        for (WebElementFacade product : productItems) {
            if (product.findBy(".inventory_item_name").getText().equals(productName)) {
                product.findBy(".btn_inventory").click();
                break;
            }
        }
    }

    public void goToCart() {
        cartIcon.click();
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }
}