package by.tabletka.api.favorite;

import by.tabletka.api.BaseApiRequest;
import io.restassured.specification.RequestSpecification;

public class FavoriteApiRequest extends BaseApiRequest {
    public FavoriteApiRequest(String baseUrl) {
        super(baseUrl);
    }

    public RequestSpecification initRequestSpecificationToAddFavorite() {
        return this.initRequestSpecification().basePath("ajax-request/add-kit-drug");
    }

    public RequestSpecification initRequestSpecificationToRemoveFavorite() {
        return this.initRequestSpecification().basePath("ajax-request/remove-kit-drug");
    }

    public RequestSpecification initRequestSpecificationToRemoveAllFavorites() {
        return this.initRequestSpecification().basePath("ajax-request/remove-kit-drug-all");
    }

    public String getBodyAddFavoriteRequest(int productId) {
        return "_csrf="+this.csrfTokenBody+"&id=" + productId;
    }

    public String getBodyRemoveFavoriteRequest(int productId) {
        return "_csrf="+this.csrfTokenBody+"&id=" + productId;
    }

    public String getBodyRemoveAllFavoritesRequest() {
        return "_csrf="+this.csrfTokenBody;
    }
}
