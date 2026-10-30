package LoginTest;


import HomeWork_02.BaseTest;
import HomeWork_02.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void loginOk() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("john@example.com");
        loginPage.enterPassword("password123");
        loginPage.clickLoginButton();
        loginPage.waiting();

        Assertions.assertEquals(
                "http://192.168.1.15:5173/dashboard",driver.getCurrentUrl() ,"User Not Logged in");
    }

    @Test
    void loginNok(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.enterEmail("john@example.com");
        loginPage.enterPassword("password1231");
        loginPage.clickLoginButton();
        loginPage.waiting();

        Assertions.assertEquals(
                "Invalid email or password",loginPage.getErrorLoginMsg(),"User Not Logged in");
    }

    }

