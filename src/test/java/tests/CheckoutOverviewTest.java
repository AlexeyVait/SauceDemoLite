package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutOverviewTest extends BaseTest {

    @Test(description = "Check the value of total and item total prices when products have been added to the cart")
    public void validatePriceOfProducts() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openByClickingOnCartButton();
        cartPage.checkout();
        checkoutPage.submit("Alex", "Mamba", "149587");
        assertTrue(checkoutOverviewPage.isPageOpened());
        assertEquals(checkoutOverviewPage.getItemTotal(), "Item total: $37.98", "Item total is wrong");
        assertEquals(checkoutOverviewPage.getTotal(), "Total: $41.02", "Total is wrong");
    }

    @Test(description = "Check cancelling checkout when product has been added to the cart")
    public void cancelCheckoutWhenOneProductIsAdded() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Onesie");
        cartPage.openByClickingOnCartButton();
        cartPage.checkout();
        checkoutPage.submit("Alex", "Mamba", "149587");
        assertTrue(checkoutOverviewPage.isPageOpened());
        checkoutOverviewPage.cancelOrder();
        assertTrue(productsPage.isPageOpened());
        assertEquals(productsPage.getButtonText("Sauce Labs Onesie"), "REMOVE", "Text of button is wrong");
    }

    @Test(description = "Check successful checkout when products have been added to the cart", groups = {"Smoke"})
    public void successfulCheckoutWhenMultipleProductsAreAdded() {
        loginPage.isPageOpened();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
        productsPage.addToCart("Sauce Labs Onesie");
        productsPage.addToCart("Sauce Labs Backpack");
        cartPage.openByClickingOnCartButton();
        cartPage.checkout();
        checkoutPage.submit("Alex", "Mamba", "149587");
        assertTrue(checkoutOverviewPage.isPageOpened());
        checkoutOverviewPage.finishOrder();
        assertTrue(checkoutCompletePage.isPageOpened());
        assertEquals(checkoutCompletePage.getHeader(), "THANK YOU FOR YOUR ORDER", "Header of successful order is wrong");
        assertEquals(checkoutCompletePage.getDescription(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                "Description of successful order is wrong");
    }
}
