package Pages;

import Base.BasePage;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {
    private final HeaderComponent header;

    private static final By EMAIL_FIELD = By.xpath("//*[@placeholder='Enter your email']");
    private static final By PASSWORD_FIELD = By.xpath("//*[@placeholder='Enter your password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@data-testid='cs-login-submit']");
    private static final By ERROR_LOGIN_MSG = By.xpath("//*[text()='Invalid email or password']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.header = new HeaderComponent(driver, wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public MyRequestPage login(String email, String password) {
        sendKeys(EMAIL_FIELD, email);
        sendKeys(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);

        if (waitForUrlContains("/dashboard")) {
            return new MyRequestPage(driver, wait);
        } else {
            getErrorLoginMsg();
        }
        return new MyRequestPage(driver, wait);
    }

    public String getErrorLoginMsg() {
        return getText(ERROR_LOGIN_MSG);
    }

    public String getPasswordFieldType() {
        return driver.findElement(PASSWORD_FIELD).getAttribute("type");
    }

    public String getEmailFieldValue() {
        return driver.findElement(EMAIL_FIELD).getAttribute("value");
    }

    public LoginPage enterEmail(String email) {
        sendKeys(EMAIL_FIELD, email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeys(PASSWORD_FIELD, password);
        return this;
    }

    public LoginPage clickLoginButton() {
        click(LOGIN_BUTTON);
        return this;
    }
}