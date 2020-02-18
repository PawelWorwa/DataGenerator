package com.data.generator.company.pl;

import com.data.generator.random.Number;
import com.google.common.collect.ImmutableList;

final class RegonTerritorialCodes {
    private static final Number number = new Number();
    private static final ImmutableList<String> TERRITORIAL_CODES_MAP = new ImmutableList.Builder<String>()
            .add("02") //DOLNOŚLĄSKIE
            .add("04") //KUJAWSKO-POMORSKIE
            .add("06") //LUBELSKIE
            .add("08") //LUBUSKIE
            .add("10") //ŁÓDZKIE
            .add("12") //MAŁOPOLSKIE
            .add("14") //MAZOWIECKIE
            .add("16") //OPOLSKIE
            .add("18") //PODKARPACKIE
            .add("20") //PODLASKIE
            .add("22") //POMORSKIE
            .add("24") //ŚLĄSKIE
            .add("26") //ŚWIĘTOKRZYSKIE
            .add("28") //WARMIŃSKO-MAZURSKIE
            .add("30") //WIELKOPOLSKIE
            .add("32") //ZACHODNIOPOMORSKIE
            .build();

    private RegonTerritorialCodes() {
        throw new IllegalStateException("RegonTerritorialCodes is utility class!");
    }

    public static String randomTerritorialCode() {
        return TERRITORIAL_CODES_MAP.get(
                number.randomNumber(TERRITORIAL_CODES_MAP.size()));
    }
}