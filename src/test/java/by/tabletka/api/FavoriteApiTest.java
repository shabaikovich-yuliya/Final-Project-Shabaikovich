package by.tabletka.api;

import by.tabletka.api.favorite.FavoriteApiRequest;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FavoriteApiTest extends BaseApiTest {
    FavoriteApiRequest favoriteApiRequest;

    @BeforeEach
    void setUp() {
        if (this.favoriteApiRequest == null) {
            this.favoriteApiRequest = new FavoriteApiRequest(BASE_URL);
        }
    }

    @Test
    @DisplayName("API. Аптечка: Тест 1 - Добавление продукта в аптечку")
    public void testAddFavorite() {

        given()
                .spec(this.favoriteApiRequest.initRequestSpecificationToAddFavorite())
                .body(this.favoriteApiRequest.getBodyAddFavoriteRequest(GenerationDataUtil.PRODUCT_ID))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_SUCCESS));
    }

    @Test
    @DisplayName("API. Аптечка: Тест 2 - Удаление одного продукта из аптечки")
    public void testRemoveFavorite() {
        given()
                .spec(this.favoriteApiRequest.initRequestSpecificationToAddFavorite())
                .body(this.favoriteApiRequest.getBodyAddFavoriteRequest(GenerationDataUtil.PRODUCT_ID))
                .when()
                .log().all()
                .post();

        given()
                .spec(this.favoriteApiRequest.initRequestSpecificationToRemoveFavorite())
                .body(this.favoriteApiRequest.getBodyRemoveFavoriteRequest(GenerationDataUtil.PRODUCT_ID))
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_SUCCESS));
    }

    @Test
    @DisplayName("API. Аптечка: Тест 3 - Удаление всех продуктов из аптечки")
    public void testRemoveAllFavorites() {
        given()
                .spec(this.favoriteApiRequest.initRequestSpecificationToAddFavorite())
                .body(this.favoriteApiRequest.getBodyAddFavoriteRequest(GenerationDataUtil.PRODUCT_ID))
                .when()
                .log().all()
                .post();

        given()
                .spec(this.favoriteApiRequest.initRequestSpecificationToRemoveAllFavorites())
                .body(this.favoriteApiRequest.getBodyRemoveAllFavoritesRequest())
        .when()
                .log().all()
                .post()
        .then()
                .log().all()
                .statusCode(200)
                .body("status", equalTo(BaseApiRequest.STATUS_RESPONSE_SUCCESS))
                .body("count", equalTo("0+0"));
    }
}
