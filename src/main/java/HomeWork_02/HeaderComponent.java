package HomeWork_02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderComponent extends BasePage{

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }
    private By header = By.xpath("//*[@data-testid='cs-app-header']");


}
