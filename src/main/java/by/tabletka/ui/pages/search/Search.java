package by.tabletka.ui.pages.search;

import by.tabletka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Search {
    private WebDriver driver;

    public Search() {
        WebDriver driver = Driver.getDriver();
        this.driver = driver;
    }

    public Search clickOnListOfRegions() {
        driver.findElement(By.xpath(SearchXpath.LIST_OF_REGIONS_XPATH)).click();
        return this;
    }

    public Search selectRegionKopyl() {
        driver.findElement(By.xpath(SearchXpath.SELECT_REGION_KOPYL_XPATH));
        return this;
    }

    public Search inputSearchRequest(String searchRequest){
        driver.findElement(By.xpath(SearchXpath.INPUT_SEARCH_REQUEST_XPATH)).sendKeys(searchRequest);
        return this;
    }

    public Search clickSearchButton() {
        driver.findElement(By.xpath(SearchXpath.SEARCH_BUTTON_XPATH)).click();
        return this;
    }

    public WebElement getSearchResultTable() {
        return driver.findElement(By.xpath(SearchXpath.SEARCH_RESULT_TABLE));
    }

    public String getSearchPageTitle() {
      return driver.findElement(By.xpath(SearchXpath.SEARCH_RESULT_TITLE_XPATH)).getText();
    }

    public WebElement getSearchPageTitleNoResults() {
        return driver.findElement(By.xpath(SearchXpath.HEADER_NO_RESULTS_BY_THIS_REQUEST_XPATH));
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(By.xpath(SearchXpath.NAME_OF_ITEMS_IN_SEARCH_RESULT));
    }
}
