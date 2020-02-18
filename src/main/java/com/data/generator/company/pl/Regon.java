package com.data.generator.company.pl;

import com.data.generator.random.Regexp;

public class Regon {
    private static final String REGEXP_NUMBER_TEMPLATE = "[0-9]{%s}";
    private static final String WEIGHTS_SHORT = "89234567";
    private static final String WEIGHTS_LONG = "2485097361248";

    private static final int SHORT_REGON_SIZE = 6;
    private static final int LONG_REGON_SIZE = 11;

    private final Regexp regexp = new Regexp();

    public String generateShortRegon() {
        return createRegon(SHORT_REGON_SIZE, WEIGHTS_SHORT);
    }

    public String generateLongRegon() {
        return createRegon(LONG_REGON_SIZE, WEIGHTS_LONG);
    }

    private String createRegon(int size, String weights) {
        String regon = RegonTerritorialCodes.randomTerritorialCode();
        regon += regexp.randomStringFromRegexp(
                String.format(REGEXP_NUMBER_TEMPLATE, size));

        regon += calculateChecksum(
                calculateSum(regon, weights));

        return regon;
    }

    int calculateSum(String numbers, String weights) {
        int sum = 0;
        for (int i = 0; i < numbers.length(); ++i) {
            sum += Character.getNumericValue(weights.charAt(i)) * Character.getNumericValue(numbers.charAt(i));
        }

        return sum;
    }

    int calculateChecksum(int sum) {
        int checksum = sum % 11;
        return (checksum == 10) ? 0 : checksum;
    }
}