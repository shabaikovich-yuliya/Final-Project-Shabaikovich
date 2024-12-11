package by.tabletka.api;

import by.tabletka.api.login.LoginApiRequest;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignupApiTest {
    @BeforeEach
    void setUp() {
        LoginApiRequest.initRequestSpecificationToSignup();
    }

    @Test
    @DisplayName("API. Тест 1 - Регистрация пользователя со всеми пустыми полями")
    public void testSignupWithAllEmptyFields() {
        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBodySignupRequest(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE,
                        GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE, true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("ошибка параметров пользователя"));
    }
}
