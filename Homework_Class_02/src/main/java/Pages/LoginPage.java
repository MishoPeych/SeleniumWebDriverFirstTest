package Pages;

import Base.BaseTest;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BaseTest {
    private final HeaderComponent header;

    private static final By EMAIL_FIELD = By.xpath("//*[@placeholder='Enter your email']");
    private static final By PASSWORD_FIELD = By.xpath("//*[@placeholder='Enter your password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@data-testid='cs-login-submit']");
    private static final By ERROR_LOGIN_MSG = By.xpath("//*[text()='Invalid email or password']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.header = new HeaderComponent(driver,wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public MyRequestPage login(String email, String password) {

        driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();

        if (wait.until(ExpectedConditions.urlContains("/dashboard"))) {
            return new MyRequestPage(driver,wait);
        }
        else {
            String errorLoginMsg = getErrorLoginMsg();
        }
        return new MyRequestPage(driver, wait);
    }

    public String getErrorLoginMsg() {

        String errorMsg;
        errorMsg = driver.findElement(ERROR_LOGIN_MSG).getText();
        return errorMsg;
    }

}