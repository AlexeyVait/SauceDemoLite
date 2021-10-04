package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    private static final By CHECKOUT_TITLE = By.cssSelector(".title");
    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_CODE_INPUT = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.id("continue");
    private static final By ERROR_TEXT = By.cssSelector("[data-test=error]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        isVisible(CHECKOUT_TITLE);
        return true;
    }

    public void submit(String firstName, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_TEXT).getText();
    }
}
