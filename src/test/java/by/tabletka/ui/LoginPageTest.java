package by.tabletka.ui;

import by.tabletka.ui.pages.login.LoginPage;
import by.tabletka.ui.pages.login.LoginPageMessages;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginPageTest extends BaseTest {
    private String EMPTY_VALUE = "";

    @Test
    @DisplayName("Пустое поле E-mail")
    public void testEmptyEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail(EMPTY_VALUE)
                .clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
    }

}
