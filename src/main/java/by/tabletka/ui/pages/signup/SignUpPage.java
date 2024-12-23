package by.tabletka.ui.pages.signup;

import by.tabletka.ui.driver.Driver;
import by.tabletka.ui.pages.login.LoginPageXpath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage() {
        WebDriver driver = Driver.getDriver();
        this.driver = driver;
    }

    public SignUpPage openSignUpForm() {
        driver.findElement(By.xpath(LoginPageXpath.BUTTON_LOGIN_ON_MAIN_PAGE_XPATH)).click();
        driver.findElement(By.xpath(SignUpPageXpath.SIGNUP_BUTTON_XPATH_ON_LOGIN_MODAL)).click();
        return this;
    }

    public SignUpPage fillEmail(String email) {
        driver.findElement(By.xpath(SignUpPageXpath.EMAIL_INPUT_XPATH)).sendKeys(email);
        return this;
    }

    public SignUpPage fillName(String name) {
        driver.findElement(By.xpath(SignUpPageXpath.NAME_INPUT_XPATH)).sendKeys(name);
        return this;
    }

    public SignUpPage fillPassword(String password) {
        driver.findElement(By.xpath(SignUpPageXpath.PASSWORD_INPUT_XPATH)).sendKeys(password);
        return this;
    }

    public SignUpPage fillConfirmPassword(String confirmPassword) {
        driver.findElement(By.xpath(SignUpPageXpath.CONFIRM_PASSWORD_INPUT_XPATH)).sendKeys(confirmPassword);
        return this;
    }

    public SignUpPage clickConfirmCheckbox() {
        driver.findElement(By.xpath(SignUpPageXpath.CONFIRM_CHECKBOX_XPATH)).click();
        return this;
    }

    public SignUpPage clickSignUpButton() {
        driver.findElement(By.xpath(SignUpPageXpath.SIGNUP_BUTTON_ON_SIGNUP_FORM)).click();
        return this;
    }

    public String getEmailErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_EMAIL_XPATH)).getText();
    }

    public String getNameErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_NAME_XPATH)).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_PASSWORD_XPATH)).getText();
    }

    public String getConfirmPasswordErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_CONFIRM_PASSWORD_XPATH)).getText();
    }

    public String getConfirmCheckboxErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_AGREE_XPATH)).getText();
    }

    public String getRegisteredUserErrorMessage() {
        return driver.findElement(By.xpath(SignUpPageXpath.ERROR_MESSAGE_REGISTERED_USER_XPATH)).getText();
    }
}

