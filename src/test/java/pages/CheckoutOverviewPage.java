package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage extends BasePage {

    private static final By CHECKOUT_OVERVIEW_TITLE = By.cssSelector(".title");
    private static final By ITEM_TOTAL = By.cssSelector(".summary_subtotal_label");
    private static final By TOTAL = By.cssSelector(".summary_total_label");
    private static final By FINISH_BUTTON = By.cssSelector(".cart_button");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link");

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        isVisible(CHECKOUT_OVERVIEW_TITLE);
        return true;
    }

    public String getItemTotal() {
        return driver.findElement(ITEM_TOTAL).getText();
    }

    public String getTotal() {
        return driver.findElement(TOTAL).getText();
    }

    public void finishOrder() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void cancelOrder() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
