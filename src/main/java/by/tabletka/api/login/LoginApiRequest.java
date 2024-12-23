package by.tabletka.api.login;

import by.tabletka.api.BaseApiRequest;
import io.restassured.specification.RequestSpecification;

public class LoginApiRequest extends BaseApiRequest {
    public LoginApiRequest(String baseUrl) {
        super(baseUrl);
    }

    public RequestSpecification initRequestSpecificationToLogin() {
        return this.initRequestSpecification().basePath("ajax-request/login");
    }

    public String getBodyLoginRequest(String email, String password) {
        return "_csrf="+this.csrfTokenBody+"&email="
                + email + "&password=" + password + "&rememberMe=on";
    }

   /* public RequestSpecification initRequestSpecificationToSignup() {
        return this.initRequestSpecification().basePath("ajax-request/signup");
    }

    public String getBodySignupRequest(String regEmail, String regName, String regPassword, String regConfirmPassword, boolean regAgree) {
        String regAgreeString = regAgree ? "on" : "off";

        return "_csrf=" + this.csrfTokenBody
                + "&reg-email=" + regEmail
                + "&reg-name=" + regName
                + "&reg-password=" + regPassword
                + "&reg-confirm=" + regPassword
                + "&reg-agree=" + regAgreeString;
    }*/
}
