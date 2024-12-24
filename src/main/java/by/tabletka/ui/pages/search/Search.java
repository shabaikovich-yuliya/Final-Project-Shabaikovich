package by.tabletka.ui.pages.search;

import by.tabletka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
