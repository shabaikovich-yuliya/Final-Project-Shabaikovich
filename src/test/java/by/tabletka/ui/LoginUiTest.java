package by.tabletka.ui;

import by.tabletka.ui.pages.login.Login;
import by.tabletka.ui.pages.login.LoginMessages;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginUiTest extends BaseTest {

    @Test
    @DisplayName("Логин: Тест 1 - Пустое поле E-mail + заполненный пароль")
    public void testEmptyEmail() {
        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword(GenerationDataUtil.generatePassword());

        Assertions.assertEquals(LoginMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 2 - Некорректная форма E-mail + заполненный пароль")
    public void testInvalidEmailFormat() {
        String invalidEmail = "test1";

        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(invalidEmail)
                .fillPassword(GenerationDataUtil.generatePassword());

        Assertions.assertEquals(LoginMessages.INVALID_EMAIL_MESSAGE, loginPage.getEmailErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 3 - Заполненный E-mail + пустое поле пароль")
    public void testEmptyPassword() {
        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickLoginButton();

        Assertions.assertEquals(LoginMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 4 - Неправильные данные для логина")
    public void testInvalidLoginData() {
        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillPassword(GenerationDataUtil.generatePassword())
                .clickLoginButton();

        WebElement invalidLoginDataErrorMessageWebElement = loginPage.getInvalidLoginDataErrorMessageWebElement();

        this.wait.until(ExpectedConditions.visibilityOf(invalidLoginDataErrorMessageWebElement));

        Assertions.assertEquals(LoginMessages.INVALID_LOGIN_DATA_MESSAGE, invalidLoginDataErrorMessageWebElement.getText());
    }

    @Test
    @DisplayName("Логин: Тест 5 - Невалидная длина введёного пароля")
    public void testInvalidPasswordLength() {
        String invalidPassword = "12";

        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillPassword(invalidPassword)
                .clickLoginButton();

        Assertions.assertEquals(LoginMessages.INVALID_PASSWORD_LENGTH_MESSAGE, loginPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Логин: Тест 6 - Не подтверждённый пользователь")
    public void testNotConfirmedUser() {
        String registeredNotConfirmedUserCredentials = "test1@test.com";

        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(registeredNotConfirmedUserCredentials)
                .fillPassword(registeredNotConfirmedUserCredentials)
                .clickLoginButton();

        WebElement errorMessageWebElement = loginPage.getNotConfirmedUserErrorMessageWebElement();

        this.wait.until(ExpectedConditions.visibilityOf(errorMessageWebElement));

        Assertions.assertEquals(LoginMessages.NOT_CONFIRMED_USER_MESSAGE, errorMessageWebElement.getText());
    }

    @Test
    @DisplayName("Логин: Тест 7: Пустое поле E-mail и пустое поле Пароль")
    public void testEmptyEmailAndEmptyPassword() {
        Login loginPage = new Login();
        loginPage.openLoginForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickLoginButton();

        Assertions.assertEquals(LoginMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getEmailErrorMessage());
        Assertions.assertEquals(LoginMessages.FIELD_IS_REQUIRED_MESSAGE, loginPage.getPasswordErrorMessage());
    }
}
