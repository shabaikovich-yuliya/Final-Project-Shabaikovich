package by.tabletka.api;

import by.tabletka.api.login.LoginApiRequest;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest {

    @BeforeEach
    void setUp() {
        LoginApiRequest.initRequestSpecification();
    }

    @Test
    @DisplayName("API. Тест 1 - Авторизация с невалидным email и невалидным паролем")
    public void testAuthorizationWithInvalidEmailAndInvalidPassword() {
        String email = GenerationDataUtil.generateEmail();
        String password = GenerationDataUtil.generatePassword();

        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBody(email, password))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }

    @Test
    @DisplayName("API. Тест 2 - Авторизация с пустым полем email и с пустым полем пароль")
    public void testAuthorizationWithEmptyEmailAndEmptyPassword() {
        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBody(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(-1))
                .body("log", equalTo("Не найден пользователь или неправильный пароль."));
    }


}
