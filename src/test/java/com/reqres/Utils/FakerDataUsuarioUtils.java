package com.reqres.Utils;

import com.github.javafaker.Faker;

public class FakerDataUsuarioUtils {



    private static final Faker faker = new Faker();

    public static String gerarRandomName() {
        return faker.name().firstName();
    }

    public static String gerarRandomJob() {
        return faker.job().title();
    }

}
