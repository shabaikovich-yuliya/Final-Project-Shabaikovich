package by.tabletka.ui;

import by.tabletka.ui.pages.login.LoginPage;
import by.tabletka.ui.pages.login.LoginPageMessages;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageUiTest extends BaseTest {

    @Test
    @DisplayName("Логин: Тест 1 - Пустое поле E-mail + заполненный пароль")
    public void testEmptyEmail() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword("any-password");

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 2 - Некорректная форма E-mail + заполненный пароль")
    public void testInvalidEmailFormat() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test")
                .fillPassword("any-password");

        Assertions.assertEquals(LoginPageMessages.INVALID_EMAIL_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 3 - Заполненный E-mail + пустое поле пароль")
    public void testEmptyPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 4 - Неправильные данные для логина")
    public void testInvalidLoginData() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword("password-test")
                .clickLoginButton();

        WebElement invalidLoginDataErrorMessageWebElement = loginPage.getInvalidLoginDataErrorMessageWebElement();

        this.wait.until(ExpectedConditions.visibilityOf(invalidLoginDataErrorMessageWebElement));

        Assertions.assertEquals(LoginPageMessages.INVALID_LOGIN_DATA_MESSAGE, invalidLoginDataErrorMessageWebElement.getText());
    }

    @Test
    @DisplayName("Логин: Тест 5 - Невалидная длина введёного пароля")
    public void testInvalidPasswordLength() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test@test.com")
                .fillPassword("12")
                .clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.INVALID_PASSWORD_LENGTH_MESSAGE, loginPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 6 - Не подтверждённый пользователь")
    public void testNotConfirmedUser() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm()
                .fillEmail("test1@test.com")
                .fillPassword("test1@test.com")
                .clickLoginButton();

        WebElement errorMessageWebElement = loginPage.getNotConfirmedUserErrorMessageWebElement();

        this.wait.until(ExpectedConditions.visibilityOf(errorMessageWebElement));

        Assertions.assertEquals(LoginPageMessages.NOT_CONFIRMED_USER_MESSAGE, errorMessageWebElement.getText());
    }

    @Test
    @DisplayName("Логин: Тест 7: Пустое поле E-mail и пустое поле Пароль")
    public void testEmptyEmailAndEmptyPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.openLoginForm().clickLoginButton();

        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
        Assertions.assertEquals(LoginPageMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getPasswordErrorMessage());
    }
}
