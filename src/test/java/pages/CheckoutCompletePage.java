package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    private static final By CHECKOUT_COMPLETE_TITLE = By.cssSelector(".title");
    private static final By HEADER_TEXT = By.cssSelector(".complete-header");
    private static final By DESCRIPTION_TEXT = By.cssSelector(".complete-text");

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        isVisible(CHECKOUT_COMPLETE_TITLE);
        return true;
    }

    public String getHeader() {
        return driver.findElement(HEADER_TEXT).getText();
    }

    public String getDescription() {
        return driver.findElement(DESCRIPTION_TEXT).getText();
    }
}
