package Pages;

import Base.BasePage;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyRequestPage extends BasePage {
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
        super(driver, wait);
        this.header = new HeaderComponent(driver, wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public String checkTitle() {
        return getText(NEW_REQUEST_TITLE);
    }

    public String checkPriority() {
        return getText(NEW_PRIORITY);
    }

    public NewRequestPage clickNewRequest() {
        click(CLICK_NEW_REQUEST);
        return new NewRequestPage(driver, wait);
    }
}

