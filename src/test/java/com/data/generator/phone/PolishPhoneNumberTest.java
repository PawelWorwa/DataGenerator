package com.data.generator.phone;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolishPhoneNumberTest {
    private static final String WARSAW_AREA_CODE = "22";
    private static final String POLISH_COUNTRY_CODE = "+48";
    private static final int STATIONARY_PHONE_NUMBER_LENGTH = 9;
    private static final int MOBILE_PHONE_NUMBER_LENGTH = 9;

    private PolishPhoneNumber number = new PolishPhoneNumber();

    @Test
    void testCountryCode() {
        Assertions.assertEquals(POLISH_COUNTRY_CODE, number.countryCode(),
                "Polish country code is different that expected!");
    }

    @Test
    void testPhoneNumber() {
        verifyStationaryPhoneNumberLength(number.phoneNumber());
    }

    @Test
    void testPhoneNumberForAreaCode() {
        String phoneNumber = number.phoneNumber(WARSAW_AREA_CODE);
        verifyStationaryPhoneNumberLength(phoneNumber);

        Assertions.assertEquals(WARSAW_AREA_CODE, phoneNumber.substring(0, WARSAW_AREA_CODE.length()),
                "Created phone number area code is different that expected!");

    }

    @Test
    void testMobilePhoneNumber() {
        Assertions.assertEquals(MOBILE_PHONE_NUMBER_LENGTH, number.mobilePhoneNumber().length(),
                "Created mobile phone number area code is different that expected!");
    }

    private void verifyStationaryPhoneNumberLength(String phoneNumber) {
        Assertions.assertEquals(STATIONARY_PHONE_NUMBER_LENGTH, phoneNumber.length(),
                "Created phone number is longer that expected!");
    }
}