package by.tabletka.ui;

import by.tabletka.ui.pages.search.Search;
import by.tabletka.ui.pages.search.SearchMessages;
import by.tabletka.utils.GenerationDataUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchUiTest extends BaseTest {

    @Test
    @DisplayName("Поиск: Тест 1 - Поиск по валидному запросу")
    public void testValidSearchRequest() {
        Search search = new Search();

        search.clickOnListOfRegions()
                .selectRegionKopyl()
                .inputSearchRequest(GenerationDataUtil.SEARCH_REQUEST)
                .clickSearchButton();

        this.wait.until(ExpectedConditions.visibilityOf(search.getSearchResultTable()));

        String searchPageTitle = search.getSearchPageTitle().toLowerCase();
        List<WebElement> searchResults = search.getSearchResults();

        Assertions.assertAll(
                () -> assertTrue(searchPageTitle.contains(GenerationDataUtil.SEARCH_REQUEST)),
                () -> assertFalse(searchResults.isEmpty())
        );
        searchResults.forEach(
                (searchResult) -> assertTrue(searchResult.getText().toLowerCase().contains(GenerationDataUtil.SEARCH_REQUEST))
        );
    }

    @Test
    @DisplayName("Поиск: Тест 2 - Поиск по запросу с пустым результатом поиска")
    public void testSearchRequestWithNoResults() {
        Search search = new Search();

        search.clickOnListOfRegions()
                .selectRegionKopyl()
                .inputSearchRequest(GenerationDataUtil.SEARCH_REQUEST_FOR_NO_RESULTS)
                .clickSearchButton();

        Assertions.assertEquals(SearchMessages.NO_RESULTS_BY_THIS_REQUEST, search.getSearchPageTitleNoResults().getText());
    }
}
