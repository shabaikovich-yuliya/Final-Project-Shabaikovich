package by.tabletka.utils;

import by.tabletka.ui.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FindElementByXpath {

    public static WebElement findElementOnPageByXpath(String xpath) {
        By elementOnPageBy = By.xpath(xpath);
        WebElement elementOnPageWebElement = Driver.getDriver().findElement(elementOnPageBy);

        return elementOnPageWebElement;
    }
}
