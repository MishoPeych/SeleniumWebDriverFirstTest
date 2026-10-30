package HomeWork_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {


    private By emailField = By.xpath("//*[@placeholder='Enter your email']");
    private By passwordField = By.xpath("//*[@placeholder='Enter your password']");
    private By loginButton = By.xpath("//*[@data-testid='cs-login-submit']");
    private By errorLoginMsg = By.xpath("//*[text()='Invalid email or password']");

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void waiting() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }

    public void enterEmail(String email) {

        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public HeaderComponent clickLoginButton() {

        driver.findElement(loginButton).click();

        return new HeaderComponent(driver);
    }

    public String getErrorLoginMsg() {

        String errorMsg;
        errorMsg = driver.findElement(errorLoginMsg).getText();

        return errorMsg;
    }

}