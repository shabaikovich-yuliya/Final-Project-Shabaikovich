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
}
