package Pages;

import Base.BaseTest;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRequestPage extends BaseTest {
    private final HeaderComponent header;

    private static final By TITLE = By.xpath("//h1");
    private static final By REQUEST_TITLE_FIELD = By.xpath("//*[@name='title']");
    private static final By DESCRIPTION_FIELD = By.xpath("//*[@name='description']");
    private static final By DATE_FIELD = By.xpath("//*[@name='dateOfRequest']");
    private static final By CLICK_DROPDOWN_CATEGORY = By.xpath("//*[@id='mui-component-select-category']");
    private static final By SELECT_CATEGORY = By.xpath("//*[text()='Waste Management']");
    private static final By SELECT_PRIORITY = By.xpath("//*[@type='radio'][@value='HIGH']");
    private static final By NEXT_BUTTON = By.xpath("//*[@data-testid='cs-new-request-wizard-next']");
    private static final By ADDRESS_FIELD = By.xpath("//*[@name='streetAddress']");
    private static final By CITY_FIELD = By.xpath("//*[@name='city']");
    private static final By POSTAL_CODE_FIELD = By.xpath("//*[@name='postalCode']");
    private static final By LOCAL_DESCRIPTION_FIELD = By.xpath("//*[@name='locationText']");
    private static final By PREFERRED_CONTACT_METHOD_DROPDOWN = By.xpath("//*[@data-testid='ArrowDropDownIcon']");
    private static final By EMAIL_FIELD = By.xpath("//*[@name='email']");
    private static final By PHONE_FIELD = By.xpath("//*[@name='phone']");
    private static final By CHECK_BOX = By.xpath("//*[@data-testid='cs-new-request-agree-terms']");
    private static final By SUBMIT_REQUEST_BUTTON = By.xpath("//*[@data-testid='cs-new-request-wizard-submit']");
    private static final By SUBMIT_REQUEST_ERROR = By.xpath("//*[@data-testid='cs-submit-error']");
    private static final By IS_EMERGENCY = By.xpath("//*[@data-testid='cs-new-request-emergency']");

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.header = new HeaderComponent(driver, wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public String getTitlePage() {

        String titleMsg;
        titleMsg = driver.findElement(TITLE).getText();
        return titleMsg;
    }

    public NewRequestPage inputBasicInformation(String shortTitle, String description) {
        wait.until(ExpectedConditions.elementToBeClickable(REQUEST_TITLE_FIELD)).sendKeys(shortTitle);
        //driver.findElement(REQUEST_TITLE_FIELD).sendKeys(shortTitle);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(description);
        driver.findElement(CLICK_DROPDOWN_CATEGORY).click();
        driver.findElement(SELECT_CATEGORY).click();
        driver.findElement(SELECT_PRIORITY).click();
        //driver.findElement(IS_EMERGENCY).click();
        driver.findElement(NEXT_BUTTON).click();
        return this;

    }

    public NewRequestPage localDetails(String address, String city, String postalCode, String localDescription) {
        wait.until(ExpectedConditions.elementToBeClickable(ADDRESS_FIELD)).sendKeys(address);
        // driver.findElement(ADDRESS_FIELD).sendKeys(address);
        driver.findElement(CITY_FIELD).sendKeys(city);
        driver.findElement(POSTAL_CODE_FIELD).sendKeys(postalCode);
        driver.findElement(LOCAL_DESCRIPTION_FIELD).sendKeys(localDescription);
        driver.findElement(NEXT_BUTTON).click();
        return this;

    }

    public NewRequestPage contactInformation(String email, String phone) {
        wait.until(ExpectedConditions.elementToBeClickable(EMAIL_FIELD)).sendKeys(email);
        //driver.findElement(EMAIL_FIELD).sendKeys(email);
        driver.findElement(PHONE_FIELD).sendKeys(phone);
        driver.findElement(NEXT_BUTTON).click();
        return this;

    }

    public NewRequestPage additionalDetails() {
        wait.until(ExpectedConditions.elementToBeClickable(CHECK_BOX)).click();
        //driver.findElement(CHECK_BOX).click();
        driver.findElement(NEXT_BUTTON).click();
        return this;

    }


    public MyRequestPage reviewAndSubmit() {
        driver.findElement(SUBMIT_REQUEST_BUTTON).click();
        return new MyRequestPage(driver, wait);

    }



}
