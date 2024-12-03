package by.tabletka.ui.pages.login;

import by.tabletka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage() {
        WebDriver driver = Driver.getDriver();
        this.driver = driver;
    }

    public LoginPage openLoginForm() {
        By buttonOpenLoginFormBy = By.xpath(LoginPageXpath.BUTTON_LOGIN_ON_MAIN_PAGE_XPATH);
        WebElement buttonOpenLoginFormWebElement = this.driver.findElement(buttonOpenLoginFormBy);
        buttonOpenLoginFormWebElement.click();
        return this;
    }

    public LoginPage fillEmail(String email) {
        By inputEmailBy = By.xpath(LoginPageXpath.INPUT_EMAIL_XPATH);
        WebElement inputEmailWebElement = this.driver.findElement(inputEmailBy);
        inputEmailWebElement.sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        By inputPasswordBy = By.xpath(LoginPageXpath.INPUT_PASSWORD_XPATH);
        WebElement inputPasswordWebElement = this.driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        By buttonLoginBy = By.xpath(LoginPageXpath.BUTTON_LOGIN_ON_FORM_XPATH);
        WebElement buttonLoginWebElement = this.driver.findElement(buttonLoginBy);
        buttonLoginWebElement.click();
        return this;
    }

    public String getEmailErrorMessage() {
        By emailErrorMessageBy = By.xpath(LoginPageXpath.ERROR_MESSAGE_EMAIL);
        WebElement emailErrorMessageWebElement = this.driver.findElement(emailErrorMessageBy);

        return emailErrorMessageWebElement.getText();
    }

    public String getPasswordErrorMessage() {
        By passwordErrorMessageBy = By.xpath(LoginPageXpath.ERROR_MESSAGE_REQUIRED_PASSWORD);
        WebElement passwordErrorMessageWebElement = this.driver.findElement(passwordErrorMessageBy);

        return passwordErrorMessageWebElement.getText();
    }
    public String getInvalidLoginDataErrorMessage() {
        By invalidLoginDataErrorMessageBy = By.xpath(LoginPageXpath.ERROR_MESSAGE_INVALID_LOGIN_DATA);
        WebElement invalidLoginDataErrorMessageWebElement = this.driver.findElement(invalidLoginDataErrorMessageBy);

        return invalidLoginDataErrorMessageWebElement.getText();
    }
}
