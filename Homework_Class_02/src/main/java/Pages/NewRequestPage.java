package Pages;

import Base.BasePage;
import Components.HeaderComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewRequestPage extends BasePage {
    private final HeaderComponent header;

    private static final By TITLE = By.xpath(".//h1");
    private static final By REQUEST_TITLE_FIELD = By.xpath(".//*[@name='title']");
    private static final By DESCRIPTION_FIELD = By.xpath(".//*[@name='description']");
    private static final By DATE_FIELD = By.xpath(".//*[@name='dateOfRequest']");
    private static final By CLICK_DROPDOWN_CATEGORY = By.xpath(".//*[@id='mui-component-select-category']");
    private static final By SELECT_CATEGORY = By.xpath(".//*[text()='Waste Management']");
    private static final By SELECT_PRIORITY = By.xpath(".//label[contains(., 'High')]//input[@value='HIGH']");
    private static final By NEXT_BUTTON = By.xpath(".//*[@data-testid='cs-new-request-wizard-next']");
    private static final By ADDRESS_FIELD = By.xpath(".//*[@name='streetAddress']");
    private static final By CITY_FIELD = By.xpath(".//*[@name='city']");
    private static final By POSTAL_CODE_FIELD = By.xpath(".//*[@name='postalCode']");
    private static final By LOCAL_DESCRIPTION_FIELD = By.xpath(".//*[@name='locationText']");
    private static final By PREFERRED_CONTACT_METHOD_DROPDOWN = By.xpath(".//*[@data-testid='ArrowDropDownIcon']");
    private static final By EMAIL_FIELD = By.xpath(".//*[@name='email']");
    private static final By PHONE_FIELD = By.xpath(".//*[@name='phone']");
    private static final By CHECK_BOX = By.xpath(".//*[@data-testid='cs-new-request-agree-terms']");
    private static final By SUBMIT_REQUEST_BUTTON = By.xpath(".//*[@data-testid='cs-new-request-wizard-submit']");
    private static final By SUBMIT_REQUEST_ERROR = By.xpath(".//*[@data-testid='cs-submit-error']");
    private static final By IS_EMERGENCY = By.xpath(".//*[@data-testid='cs-new-request-emergency']");

    public NewRequestPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        this.header = new HeaderComponent(driver, wait);
    }

    public HeaderComponent header() {
        return header;
    }

    public String getTitlePage() {
        return getText(TITLE);
    }

    public NewRequestPage inputBasicInformation(String shortTitle, String description) {
        sendKeys(REQUEST_TITLE_FIELD, shortTitle);
        sendKeys(DESCRIPTION_FIELD, description);
        click(CLICK_DROPDOWN_CATEGORY);
        click(SELECT_CATEGORY);
        click(SELECT_PRIORITY);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage localDetails(String address, String city, String postalCode, String localDescription) {
        sendKeys(ADDRESS_FIELD, address);
        sendKeys(CITY_FIELD, city);
        sendKeys(POSTAL_CODE_FIELD, postalCode);
        sendKeys(LOCAL_DESCRIPTION_FIELD, localDescription);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage contactInformation(String email, String phone) {
        sendKeys(EMAIL_FIELD, email);
        sendKeys(PHONE_FIELD, phone);
        click(NEXT_BUTTON);
        return this;
    }

    public NewRequestPage additionalDetails() {
        click(CHECK_BOX);
        click(NEXT_BUTTON);
        return this;
    }

    public MyRequestPage reviewAndSubmit() {
        click(SUBMIT_REQUEST_BUTTON);

        if (isDisplayed(SUBMIT_REQUEST_ERROR)) {
            String errorMessage = getText(SUBMIT_REQUEST_ERROR);
            throw new AssertionError("Submit failed with error: " + errorMessage);
        }

        return new MyRequestPage(driver, wait);
    }
}
