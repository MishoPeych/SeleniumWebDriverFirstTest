package Pages;

import Base.BaseTest;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRequestPage extends BaseTest {
    private final HeaderComponent header;

    private static final By NEW_REQUEST_TITLE = By.xpath("//div[@role='row' and @data-rowindex='0']//div[@data-field='title']");
    private static final By NEW_PRIORITY = By.xpath("//div[@role='row' and @data-rowindex='0']//div[@data-field='priority']");
    private static final By SEARCH_FIELD = By.xpath("//input[@placeholder='Search by title, description, or ID']");
    private static final By FIRST_FILTER_DROPDOWN = By.xpath("(//div[@role='combobox'])[1]");
    private static final By SECOND_FILTER_DROPDOWN = By.xpath("(//div[@role='combobox'])[2]");
    private static final By THIRD_FILTER_DROPDOWN = By.xpath("(//div[@role='combobox'])[3]");
    private static final By ROWS_PER_PAGE_DROPDOWN = By.xpath("//div[@role='combobox' and contains(@class,'MuiTablePagination-select')]");
    private static final By CLICK_NEW_REQUEST = By.xpath("//*[@href='/citizen/requests/new']");

    public MyRequestPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.header = new HeaderComponent(driver, wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public String checkTitle() {
        wait.until(ExpectedConditions.elementToBeClickable(NEW_REQUEST_TITLE));
        String checkTitleMsg;
        checkTitleMsg = driver.findElement(NEW_REQUEST_TITLE).getText();
        return checkTitleMsg;
    }

    public String checkPriority() {
        wait.until(ExpectedConditions.elementToBeClickable(NEW_PRIORITY));

        String checkPriorityMsg;
        checkPriorityMsg = driver.findElement(NEW_PRIORITY).getText();
        return checkPriorityMsg;

    }

    public NewRequestPage clickNewRequest() {
        driver.findElement(CLICK_NEW_REQUEST).click();
        return new NewRequestPage(driver, wait);

    }

}
