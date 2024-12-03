package by.tabletka.ui;

import by.tabletka.ui.driver.Driver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {
    @BeforeEach
    public void startFromHome() {
        Driver.getDriver().get("https://tabletka.by/");
    }

    @AfterEach
    public void tearDown() {
        Driver.quit();
    }
}
