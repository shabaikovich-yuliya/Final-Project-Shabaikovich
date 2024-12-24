package by.tabletka.ui.pages.login;

import by.tabletka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login {
    private WebDriver driver;

    public Login() {
        WebDriver driver = Driver.getDriver();
        this.driver = driver;
    }

    public Login openLoginForm() {
        driver.findElement(By.xpath(LoginXpath.BUTTON_LOGIN_ON_MAIN_PAGE_XPATH)).click();
        return this;
    }

    public Login fillEmail(String email) {
        driver.findElement(By.xpath(LoginXpath.INPUT_EMAIL_XPATH)).sendKeys(email);
        return this;
    }

    public Login fillPassword(String password) {
        driver.findElement(By.xpath(LoginXpath.INPUT_PASSWORD_XPATH)).sendKeys(password);
        return this;
    }

    public Login clickLoginButton() {
        driver.findElement(By.xpath(LoginXpath.BUTTON_LOGIN_ON_FORM_XPATH)).click();
        return this;
    }

    public String getEmailErrorMessage() {
      return driver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_EMAIL_XPATH)).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_REQUIRED_PASSWORD_XPATH)).getText();
    }

    public WebElement getInvalidLoginDataErrorMessageWebElement() {
        return driver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_INVALID_LOGIN_DATA_XPATH));
    }

    public WebElement getNotConfirmedUserErrorMessageWebElement() {
        return driver.findElement(By.xpath(LoginXpath.ERROR_MESSAGE_NOT_CONFIRMED_USER_XPATH));
    }
}
