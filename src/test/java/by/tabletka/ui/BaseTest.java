package by.tabletka.ui;

import by.tabletka.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseTest {
    protected WebDriverWait wait;

    @BeforeEach
    public void startFromHome() {
        Driver.getDriver().get("https://tabletka.by/");

        this.wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(2));
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }
}
