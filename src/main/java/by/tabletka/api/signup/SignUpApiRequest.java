package by.tabletka.api.signup;

import by.tabletka.api.BaseApiRequest;
import io.restassured.specification.RequestSpecification;

public class SignUpApiRequest extends BaseApiRequest {

    public SignUpApiRequest(String baseUrl) {
        super(baseUrl);
    }

    public RequestSpecification initRequestSpecificationToSignup() {
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
    }
}
