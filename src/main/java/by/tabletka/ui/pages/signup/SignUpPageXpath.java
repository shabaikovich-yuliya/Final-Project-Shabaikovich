package by.tabletka.ui.pages.signup;

public class SignUpPageXpath {
    public static final String SIGNUP_BUTTON_XPATH_ON_LOGIN_MODAL = "//*[@data-modal='login']//*[@href='/signup']";
    public static final String EMAIL_INPUT_XPATH = "//*[@class='js-validate reg-form has-validation-callback']//*[@id='reg-email']";
    public static final String NAME_INPUT_XPATH = "//*[@class='js-validate reg-form has-validation-callback']//*[@id='reg-name']";
    public static final String PASSWORD_INPUT_XPATH = "//*[@class='js-validate reg-form has-validation-callback']//*[@id='reg-password']";
    public static final String CONFIRM_PASSWORD_INPUT_XPATH = "//*[@class='js-validate reg-form has-validation-callback']//*[@id='reg-confirm']";
    public static final String CONFIRM_CHECKBOX_XPATH = "//label[@for='reg-agree']";
    public static final String SIGNUP_BUTTON_ON_SIGNUP_FORM = "//*[@class='js-validate reg-form has-validation-callback']//*[@id='bttn-reg']";
    public static final String ERROR_MESSAGE_EMAIL_XPATH = "//*[@id='reg-email-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_NAME_XPATH = "//*[@id='reg-name-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_PASSWORD_XPATH = "//*[@id='reg-password-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_CONFIRM_PASSWORD_XPATH = "//*[@id='reg-confirm-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_AGREE_XPATH = "//*[@id='reg-agree-wrap']//*[@class='help-block form-error']";
    public static final String ERROR_MESSAGE_REGISTERED_USER_XPATH = "//*[@class='errors-login']";
}
