package by.tabletka.api;

import by.tabletka.ui.driver.Driver;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseApiRequest {
    public static final int STATUS_RESPONSE_SUCCESS = 1;
    public static final int STATUS_RESPONSE_FAILED = -1;

    protected String baseUrl;

    protected String csrfTokenCookie;
    protected String csrfTokenBody;

    public BaseApiRequest(String baseUrl) {
        this.baseUrl = baseUrl;

        this.initCsrfTokens();
    }

    public void initCsrfTokens() {
        if (this.csrfTokenCookie != null && this.csrfTokenBody != null) {
            return;
        }

        WebDriver driver = Driver.getDriver();
        driver.get(this.baseUrl);

        this.csrfTokenCookie = driver.manage().getCookieNamed("_csrf").getValue();
        this.csrfTokenBody = driver.findElement(By.xpath("//meta[@name='csrf-token']")).getAttribute("content");
    }

    public RequestSpecification initRequestSpecification() {
         return new RequestSpecBuilder()
                .setBaseUri(this.baseUrl)
                .setContentType("application/x-www-form-urlencoded; charset=UTF-8")
                .addCookie("_csrf", this.csrfTokenCookie)
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .build();
    }
}
