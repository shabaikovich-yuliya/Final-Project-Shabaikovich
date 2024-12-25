package by.tabletka.utils;

import com.github.javafaker.Faker;

public class GenerationDataUtil {

    public static String EMPTY_VALUE = "";
    public static String SEARCH_REQUEST = "аспирин кардио";
    public static String SEARCH_REQUEST_FOR_NO_RESULTS = "этот запрос получает отсутсвие результата поиска";
    public static String EMAIL_REGISTERED_AND_CONFIRMED_USER = "yuliya.test@mailinator.com";
    public static String PASSWORD_REGISTERED_AND_CONFIRMED_USER = "0123456";
    public static int PRODUCT_ID = 1111;

    public static String generateEmail() {
        Faker fakerEmail = new Faker();
        return fakerEmail.internet().emailAddress();
    }

    public static String generatePassword() {
        Faker fakerPassword = new Faker();
        return fakerPassword.internet().password();
    }

    public static String generateName() {
        Faker fakerName = new Faker();
        return fakerName.name().name();
    }
}
