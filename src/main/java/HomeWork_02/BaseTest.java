package HomeWork_02;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://192.168.1.15:5173/login");

        var title = driver.getTitle();

        Assertions.assertEquals("City Services Portal", title);
        System.out.println("Current title is: " + title);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
