package com.data.generator.person.ssn.pl;

import com.data.generator.person.Gender;
import com.data.generator.person.ssn.pl.PolishSsnNumber;
import java.time.Year;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PolishSsnNumberTest {
    private static final int SSN_LENGTH = 11;
    private static final int PERSON_AGE = 50;
    private static final String MALE_ORDINAL_NUMBERS = "13579";
    private static final String FEMALE_ORDINAL_NUMBERS = "02468";

    private PolishSsnNumber ssn = new PolishSsnNumber();

    @Test
    void testMaleSsnNumber() {
        validateSsnNumber(Gender.MALE);
    }

    @Test
    void testFemaleSsnNumber() {
        validateSsnNumber(Gender.FEMALE);
    }

    private void validateLength(String ssnNumber) {
        Assertions.assertEquals(SSN_LENGTH, ssnNumber.length(),
                "Polish SSN length is different that expected!");
    }

    private void validateYear(String ssnNumber) {
        String expectedShortYearOfBirth = Integer.toString(calculatePersonYearOfBirth())
                .substring(2, 4);

        Assertions.assertEquals(expectedShortYearOfBirth, ssnNumber.substring(0, 2),
                "Different short year of birth in Polish SSN number!");
    }

    private void validateMonth(String ssnNumber) {
        int yearAdjustment = ssn.getAssignedMarkerForCentury(calculatePersonYearOfBirth());
        int month = Integer.parseInt(ssnNumber.substring(2, 4));

        Assertions.assertTrue(month >= yearAdjustment + 1 && month <= yearAdjustment + 12,
                "Month digits in Polish SSN number are invalid!");
    }

    private void validateDay(String ssnNumber) {
        String day = ssnNumber.substring(4, 6);
        Assertions.assertTrue(Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31,
                "Day digits in Polish SSN number are invalid!");
    }

    private void validateRandomNumbers(String ssnNumber) {
        String randomNumbers = ssnNumber.substring(6, 9);
        Assertions.assertTrue(Integer.parseInt(randomNumbers) >= 0 && Integer.parseInt(randomNumbers) <= 999,
                "Random digits in Polish SSN number are invalid!");
    }

    private void validateOrdinal(Gender gender, String ssnNumber) {
        String ordinalNumber = ssnNumber.substring(9, 10);
        boolean isValidOrdinalNumber = Gender.MALE == gender
                ? MALE_ORDINAL_NUMBERS.contains(ordinalNumber) : FEMALE_ORDINAL_NUMBERS.contains(ordinalNumber);

        Assertions.assertTrue(isValidOrdinalNumber,
                "Wrong ordinal number for provided gender in Polish SSN number!");
    }

    private void validateChecksum(String ssnNumber) {
        String checksum = ssnNumber.substring(10, 11);
        String rawSsn = ssnNumber.substring(0, 10);
        Assertions.assertEquals(ssn.calculateChecksum(rawSsn), checksum,
                "Calculated checksum in Polish SSN number is different that expected!");
    }

    private void validateSsnNumber(Gender gender) {
        String ssnNumber = ssn.generate(gender, PERSON_AGE);
        Assertions.assertTrue(ssnNumber.matches("\\d+?"),
                "Polish SSN number contains illegal characters!");

        validateLength(ssnNumber);
        validateDay(ssnNumber);
        validateMonth(ssnNumber);
        validateYear(ssnNumber);
        validateRandomNumbers(ssnNumber);
        validateOrdinal(gender, ssnNumber);
        validateChecksum(ssnNumber);
    }

    private int calculatePersonYearOfBirth() {
        return Year.now().getValue() - PERSON_AGE;
    }
}