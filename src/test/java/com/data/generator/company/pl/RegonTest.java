package com.data.generator.company.pl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegonTest {
    private static final String WEIGHTS_SHORT = "89234567";
    private static final String WEIGHTS_LONG = "2485097361248";
    private static final int SHORT_REGON_SIZE = 9;
    private static final int LONG_REGON_SIZE = 14;

    private Regon regon = new Regon();

    @Test
    void testGenerateShortRegon() {
        validateRegonNumber(regon.generateShortRegon(), SHORT_REGON_SIZE, WEIGHTS_SHORT);
    }

    @Test
    void testGenerateLongRegon() {
        validateRegonNumber(regon.generateLongRegon(), LONG_REGON_SIZE, WEIGHTS_LONG);
    }

    void validateRegonNumber(String regonNumber, int expectedSize, String weights) {
        Assertions.assertTrue(regonNumber.matches("\\d+?"),
                "Polish Registration Number contains illegal characters!");

        Assertions.assertEquals(expectedSize, regonNumber.length(),
                "Short Polish Registration Number length is wrong!");

        String rawRegon = regonNumber.substring(0, expectedSize - 1);
        int expectedChecksum = regon.calculateChecksum(
                regon.calculateSum(rawRegon, weights));

        Assertions.assertEquals(expectedChecksum,
                Integer.parseInt(regonNumber.substring(expectedSize - 1, expectedSize)),
                "Short Polish Registration Number has wrong checksum!");
    }
}