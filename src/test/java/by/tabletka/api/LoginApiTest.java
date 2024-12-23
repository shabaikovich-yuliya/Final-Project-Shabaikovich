package by.tabletka.api;

import by.tabletka.api.login.LoginApiRequest;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginApiTest {

    @BeforeEach
    void setUp() {
        LoginApiRequest.initRequestSpecificationToLogin();
    }

    @Test
    @DisplayName("API. Тест 1 - Авторизация с невалидным email и невалидным паролем")
    public void testAuthorizationWithInvalidEmailAndInvalidPassword() {

        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBodyLoginRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generatePassword()))
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
                .body(LoginApiRequest.getBodyLoginRequest(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE))
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
    @DisplayName("API. Тест 3 - Авторизация с пустым полем email и заолненным паролем")
    public void testAuthorizationWithEmptyEmailAndFilledPassword() {

        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBodyLoginRequest(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.generatePassword()))
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
    @DisplayName("API. Тест 4 - Авторизация с заполненным полем email и пустым паролем")
    public void testAuthorizationWithFilledEmailAndEmptyPassword() {

        given()
                .spec(LoginApiRequest.requestSpecification)
                .body(LoginApiRequest.getBodyLoginRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.EMPTY_VALUE))
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
