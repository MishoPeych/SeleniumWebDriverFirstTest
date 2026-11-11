package Tests;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.MyRequestPage;
import Pages.NewRequestPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NewRequestTest extends BaseTest {

    @Test
    void submitNewRequest() {

        String message = new LoginPage(driver, wait)
                .login("john@example.com", "password123")
                .header()
                .clickOnNewRequest()
                .getTitlePage();

        Assertions.assertEquals("Submit New Service Request", message, "User is not on New Request Page");

        new NewRequestPage(driver, wait)
                .inputBasicInformation("This is short Description", "This is the long description you ever seen in your life. So you are the best!")
                .localDetails("zhk.'Druzhba 11, A, 23", "Dobrich", "9300", "No description")
                .contactInformation("astoundtest10@gmail.com", "0883360633")
                .additionalDetails()
                .reviewAndSubmit();

        String checkTitleMsg = new MyRequestPage(driver, wait).checkTitle();

        String checkPriorityMsg = new MyRequestPage(driver, wait)
                .checkPriority();

        Assertions.assertEquals("This is short Description", checkTitleMsg, "The new request was not successful!");
        Assertions.assertEquals("High", checkPriorityMsg, "The Priority is incorrect");
    }

}
