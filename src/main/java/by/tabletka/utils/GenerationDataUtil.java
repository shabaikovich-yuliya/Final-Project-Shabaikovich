package by.tabletka.utils;

import com.github.javafaker.Faker;

public class GenerationDataUtil {

    public static String EMPTY_VALUE = "";

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
