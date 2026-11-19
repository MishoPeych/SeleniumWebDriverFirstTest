package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected static final String BASE_URL = "http://localhost:5173/login";

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
    }

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        waitForElementToBeVisible(locator).sendKeys(text);
    }

    protected String getText(By locator) {
        return waitForElementToBeVisible(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement waitForElementToBePresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    protected boolean waitForUrlContains(String urlPart) {
        return wait.until(ExpectedConditions.urlContains(urlPart));
    }

}
