package by.tabletka.ui;

import by.tabletka.ui.pages.signup.SignUpPage;
import by.tabletka.ui.pages.signup.SignUpPageMessages;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SignUpPageUiTest extends BaseTest {

    @Test
    @DisplayName("Регистрация: Тест 1 - Все поля пустые")
    public void testAllFieldsAreEmpty() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .fillConfirmPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickSignUpButton();

        Assertions.assertAll(
                () -> assertEquals(SignUpPageMessages.EMAIL_FIELD_IS_REQUIRED_MESSAGE, signUpPage.getEmailErrorMessage()),
                () -> assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getPasswordErrorMessage()),
                () -> assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getNameErrorMessage()),
                () -> assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getConfirmPasswordErrorMessage()),
                () -> assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getConfirmCheckboxErrorMessage())
        );
    }

    @Test
    @DisplayName("Регистрация: Тест 2 - Пустое поле Email")
    public void testEmailIsEmpty() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.EMPTY_VALUE)
                .fillName(GenerationDataUtil.generateName())
                .fillPassword(GenerationDataUtil.generatePassword())
                .fillConfirmPassword(GenerationDataUtil.generatePassword())
                .clickConfirmCheckbox()
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.EMAIL_FIELD_IS_REQUIRED_MESSAGE, signUpPage.getEmailErrorMessage());
    }


    @Test
    @DisplayName("Регистрация: Тест 3 - Пустое поле Имя")
    public void testNameIsEmpty() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillName(GenerationDataUtil.EMPTY_VALUE)
                .fillPassword(GenerationDataUtil.generatePassword())
                .fillConfirmPassword(GenerationDataUtil.generatePassword())
                .clickConfirmCheckbox()
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getNameErrorMessage());
    }

    @Test
    @DisplayName("Регистрация: Тест 4 - Пустое поле Паролль")
    public void testPasswordIsEmpty() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillName(GenerationDataUtil.generateName())
                .fillPassword(GenerationDataUtil.EMPTY_VALUE)
                .fillConfirmPassword(GenerationDataUtil.generatePassword())
                .clickConfirmCheckbox()
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getPasswordErrorMessage());
    }

    @Test
    @DisplayName("Регистрация: Тест 5 - Пустое поле Подтверждение пароля")
    public void testConfirmPasswordIsEmpty() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillName(GenerationDataUtil.generateName())
                .fillPassword(GenerationDataUtil.generatePassword())
                .fillConfirmPassword(GenerationDataUtil.EMPTY_VALUE)
                .clickConfirmCheckbox()
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getConfirmPasswordErrorMessage());
    }

    @Test
    @DisplayName("Регистрация: Тест 6 - Не дано согласие")
    public void testNotConfirmedCheckbox() {
        String password = GenerationDataUtil.generatePassword();
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillName(GenerationDataUtil.generateName())
                .fillPassword(password)
                .fillConfirmPassword(password)
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.FIELD_IS_REQUIRED_MESSAGE, signUpPage.getConfirmCheckboxErrorMessage());
    }

    @Test
    @DisplayName("Регистрация: Тест 7 - Пароли не совпдают")
    public void testPasswordAreNotMatched() {
        SignUpPage signUpPage = new SignUpPage();
        signUpPage.openSignUpForm()
                .fillEmail(GenerationDataUtil.generateEmail())
                .fillName(GenerationDataUtil.generateName())
                .fillPassword(GenerationDataUtil.generatePassword())
                .fillConfirmPassword(GenerationDataUtil.generatePassword())
                .clickSignUpButton();

        assertEquals(SignUpPageMessages.PASSWORDS_ARE_NOT_MATCHED_MESSAGE, signUpPage.getConfirmPasswordErrorMessage());
    }
}