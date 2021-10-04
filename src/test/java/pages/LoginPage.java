package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.id("login-button");
    private static final By ERROR_TEXT = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isPageOpened() {
        driver.get(BASE_URL);
        isVisible(LOGIN_BUTTON);
        return true;
    }

    public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String getError() {
        return driver.findElement(ERROR_TEXT).getText();
    }
}

