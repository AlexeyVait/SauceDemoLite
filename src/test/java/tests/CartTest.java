package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test(description = "Check removing product from the cart in the Your cart page when it has been added")
    public void removeProductFromCart() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.open();
        cartPage.removeItemFromCart("Sauce Labs Fleece Jacket");
        assertEquals(cartPage.getAmountOfProducts(), 0, "Amount of products is wrong");
    }

    @Test(description = "Check that product is still in the cart when user continues shopping")
    public void continueShopping() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openByClickingOnCartButton();
        cartPage.continueShopping();
        assertEquals(productsPage.getButtonText("Sauce Labs Fleece Jacket"), "REMOVE",
                "Product isn't added to the cart when user continues shopping");
    }


}
