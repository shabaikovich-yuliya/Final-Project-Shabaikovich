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
        driver.findElement(By.xpath(LoginPageXpath.BUTTON_LOGIN_ON_MAIN_PAGE_XPATH)).click();
        return this;
    }

    public LoginPage fillEmail(String email) {
        driver.findElement(By.xpath(LoginPageXpath.INPUT_EMAIL_XPATH)).sendKeys(email);
        return this;
    }

    public LoginPage fillPassword(String password) {
        driver.findElement(By.xpath(LoginPageXpath.INPUT_PASSWORD_XPATH)).sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton() {
        driver.findElement(By.xpath(LoginPageXpath.BUTTON_LOGIN_ON_FORM_XPATH)).click();
        return this;
    }

    public String getEmailErrorMessage() {
      return driver.findElement(By.xpath(LoginPageXpath.ERROR_MESSAGE_EMAIL_XPATH)).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(By.xpath(LoginPageXpath.ERROR_MESSAGE_REQUIRED_PASSWORD_XPATH)).getText();
    }

    public String getInvalidLoginDataErrorMessage() {
        return driver.findElement(By.xpath(LoginPageXpath.ERROR_MESSAGE_INVALID_LOGIN_DATA_XPATH)).getText();
    }

    public WebElement getNotConfirmedUserErrorMessage() {
        return driver.findElement(By.xpath(LoginPageXpath.ERROR_MESSAGE_NOT_CONFIRMED_USER_XPATH));
    }
}
