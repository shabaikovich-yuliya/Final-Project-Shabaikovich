package by.tabletka.api;

import by.tabletka.api.signup.SignUpApiRequest;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class SignupApiTest extends BaseApiTest {
    SignUpApiRequest signUpApiRequest;

    @BeforeEach
    void setUp() {
        if (this.signUpApiRequest == null) {
            this.signUpApiRequest = new SignUpApiRequest(BASE_URL);
        }
    }

    @Test
    @DisplayName("API. Тест 1 - Регистрация со всеми пустыми полями")
    public void testSignupWithAllEmptyFields() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE,
                        GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE, true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 2 - Регистрация с пустым полем Email")
    public void testSignupWithEmptyEmail() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.generateName(),
                        GenerationDataUtil.generatePassword(), GenerationDataUtil.generatePassword(), true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 3 - Регистрация с невалидным полем Email")
    public void testSignupWithInvalidEmail() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest("testemail", GenerationDataUtil.generateName(),
                        GenerationDataUtil.generatePassword(), GenerationDataUtil.generatePassword(), true))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 4 - Регистрация с пустым полем Имя")
    public void testSignupWithEmptyName() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.EMPTY_VALUE,
                        GenerationDataUtil.generatePassword(), GenerationDataUtil.generatePassword(), true))
                .when()
                .log().all()
                .post()
                .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 5 - Регистрация с пустыми полями Пароль и подтверждение пароля")
    public void testSignupWithEmptyPasswords() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.EMPTY_VALUE, true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 6 - Регистрация с пустым полем подтверждение пароля")
    public void testSignupWithEmptyConfirmPassword() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        GenerationDataUtil.generatePassword(), GenerationDataUtil.EMPTY_VALUE, true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 7 - Регистрация с пустым полем Пароль")
    public void testSignupWithEmptyPassword() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        GenerationDataUtil.EMPTY_VALUE, GenerationDataUtil.generatePassword(), true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 8 - Регистрация с несовпадающими паролями")
    public void testSignupWithNotMatchedPasswords() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        GenerationDataUtil.generatePassword(), "1234567" , true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 9 - Регистрация с недостаточным количеством символов в пароле")
    public void testSignupWithInvalidPassword() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        "12", "12", true))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("ошибка параметров пользователя"));
    }

    @Test
    @DisplayName("API. Тест 10 - Регистрация с незаполненным согласием")
    public void testSignupWithoutAgree() {
        given()
                .spec(this.signUpApiRequest.initRequestSpecificationToSignup())
                .body(this.signUpApiRequest.getBodySignupRequest(GenerationDataUtil.generateEmail(), GenerationDataUtil.generateName(),
                        GenerationDataUtil.generatePassword(), GenerationDataUtil.generatePassword(), false))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_FAILED))
                .body("log", equalTo("нет согласия на обработку  персональных данных"));
    }
}
