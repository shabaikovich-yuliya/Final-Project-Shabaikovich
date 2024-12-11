package by.tabletka.ui;

import by.tabletka.ui.driver.Driver;
import by.tabletka.ui.pages.login.LoginPage;
import by.tabletka.ui.pages.login.LoginPageMessages;
import by.tabletka.ui.pages.login.LoginPageXpath;
import by.tabletka.utils.FindElementByXpathUtil;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPageUiTest extends BaseTest {

    @Test
    @DisplayName("Тест 1 - Пустое поле E-mail + заполненный пароль")
    public void testEmptyEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword("any-password");

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Тест 2 - Некорректная форма E-mail + заполненный пароль")
    public void testInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test")
                .fillPassword("any-password");

        Assertions.assertEquals(LoginPageMessages.INVALID_EMAIL_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Тест 3 - Заполненный E-mail + пустое поле пароль")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Тест 4 - Неправильные данные для логина")
    public void testInvalidLoginData() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword("password-test")
                .clickLoginButton();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(FindElementByXpathUtil.findElementOnPageByXpath(LoginPageXpath.ERROR_MESSAGE_INVALID_LOGIN_DATA_XPATH)));

        Assertions.assertEquals(LoginPageMessages.INVALID_LOGIN_DATA_MESSAGE, loginPage.getInvalidLoginDataErrorMessage());
    }

    @Test
    @DisplayName("Тест 5 - Невалидная длина введёного пароля")
    public void testInvalidPasswordLength() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword("12")
                .clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.INVALID_PASSWORD_LENGTH_MESSAGE, loginPage.getPasswordErrorMessage());
    }
}
