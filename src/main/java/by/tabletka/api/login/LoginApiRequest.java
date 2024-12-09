package by.tabletka.api.login;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class LoginApiRequest {
    public static RequestSpecification requestSpecification;

    public static void initRequestSpecification() {
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://tabletka.by/")
                .setBasePath("ajax-request/login")
                .setContentType("application/x-www-form-urlencoded; charset=UTF-8")
                .addCookie("PHPSESSID=sn3lduti1bcgr0j067kdbnvjem; _csrf=5f79393169d6d1dd663e5835b400145970558c8b1071cc61e563ae1cb44379b2a%3A2%3A%7Bi%3A0%3Bs%3A5%3A%22_csrf%22%3Bi%3A1%3Bs%3A32%3A%22SUKKXsEYZjIIRRpuZOj7r4JjZhayzYBm%22%3B%7D; _ga=GA1.1.1948258482.1730994936; allow-cookies=; _ym_uid=1732206771965883905; _ym_d=1732206771; _ym_isad=2; _ym_visorc=b; regionId=0; _ga_S6LL4MRH46=GS1.1.1733686216.14.1.1733686631.0.0.0")
                .addHeader("X-Requested-With", "XMLHttpRequest")
                .build();
    }

    public static String getBody(String email, String password) {
        return "_csrf=kT96ufzuKLLm3zGw7HXmqA3KHAXnhrVvBiPYRNJ68UrCajHypJ1t67y1ePm-J5bdV4V2MpWy_wVcS7k9qCOzJw%3D%3D&email=" + email + "&password=" + password + "&rememberMe=on";
    }
}
