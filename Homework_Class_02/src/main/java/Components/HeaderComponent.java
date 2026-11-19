package Components;

import Pages.LoginPage;
import Pages.NewRequestPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderComponent {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final By LOGO_LINK = By.xpath("//header[@data-testid='cs-app-header']//a[@href='/dashboard']");
    private static final By DASHBOARD_LINK = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-nav-dashboard']");
    private static final By RESOLVED_CASES_LINK = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-nav-resolved-cases']");
    private static final By RANKLIST_LINK = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-nav-ranklist']");
    private static final By MY_REQUESTS_LINK = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-nav-my-requests']");
    private static final By NEW_REQUEST_LINK = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-nav-new-request']");
    private static final By LANGUAGE_SWITCHER = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-language-switcher']");
    private static final By USER_MENU_BUTTON = By.xpath("//header[@data-testid='cs-app-header']//*[@data-testid='cs-user-menu-button']");
    private static final By LOGOUT_BUTTON = By.xpath("//*[@data-testid='cs-user-menu-logout']");

    public HeaderComponent(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public NewRequestPage clickOnNewRequest() {
        wait.until(ExpectedConditions.elementToBeClickable(NEW_REQUEST_LINK)).click();
        //driver.findElement(NEW_REQUEST_LINK).click();
        return new NewRequestPage(driver, wait);
    }

    public LoginPage logout() {
        wait.until(ExpectedConditions.elementToBeClickable(USER_MENU_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_BUTTON)).click();
        return new LoginPage(driver, wait);
    }
}
