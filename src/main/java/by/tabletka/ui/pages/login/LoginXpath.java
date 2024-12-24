package by.tabletka.ui.pages.login;

public class LoginXpath {
    public static final String BUTTON_LOGIN_ON_MAIN_PAGE_XPATH = "//*[@class='header-wrap js-header original']//*[@data-modal='login']";
    public static final String INPUT_EMAIL_XPATH = "//*[@data-modal='login']//*[@id='login-name']";
    public static final String INPUT_PASSWORD_XPATH = "//*[@data-modal='login']//*[@id='login-pass']";
    public static final String BUTTON_LOGIN_ON_FORM_XPATH = "//*[@data-modal='login']//*[@id='bttn-login']";
    public static final String ERROR_MESSAGE_EMAIL_XPATH = "//*[@id='login-name-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_REQUIRED_PASSWORD_XPATH = "//*[@id='login-pass-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_INVALID_LOGIN_DATA_XPATH = "//*[@class='errors-login']";
    public static final String ERROR_MESSAGE_NOT_CONFIRMED_USER_XPATH = "//*[@data-modal='login']//*[@class='errors-login']";
}
