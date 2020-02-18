package com.data.generator.company.pl;

import com.data.generator.random.Number;
import com.data.generator.random.Regexp;
import java.util.ArrayList;
import java.util.List;

public class Nip {
    private static final String REGEXP_NUMBER_TEMPLATE = "[0-9]{%s}";
    private static final String WEIGHTS = "657234567";
    private static final int PARTIAL_NIP_SIZE = 6;
    private static final int EXPECTED_NIP_SIZE = 10;
    private static final int FIRST_OFFICE_CODE_NUMBER = 101;
    private static final int LAST_OFFICE_CODE_NUMBER = 998;
    private static final int CHECKSUM_MODIFIER = 11;

    private static List<String> taxOfficeCodes = new ArrayList<>();

    private final Regexp regexp = new Regexp();
    private final Number number = new Number();

    public Nip() {
        if (taxOfficeCodes.isEmpty()) {
            populateOfficeCodesList();
        }
    }

    int calculateSum(String numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length(); ++i) {
            sum += Character.getNumericValue(WEIGHTS.charAt(i)) * Character.getNumericValue(numbers.charAt(i));
        }

        return sum;
    }

    private void populateOfficeCodesList() {
        for (int taxOfficeCode = FIRST_OFFICE_CODE_NUMBER; taxOfficeCode <= LAST_OFFICE_CODE_NUMBER; taxOfficeCode++) {
            if (!isTaxOfficeCodeExcluded(taxOfficeCode)) {
                taxOfficeCodes.add(
                        String.valueOf(taxOfficeCode));
            }
        }
    }

    // List of accepted tax office codes:
    // codes list: http://www.krs-online.com.pl/sprawdzanie_nip.html
    boolean isTaxOfficeCodeExcluded(int taxOfficeCode) {
        return taxOfficeCode % 10 == 0 ||
                taxOfficeCode == 299 ||
                (taxOfficeCode >= 303 && taxOfficeCode <= 309) ||
                (taxOfficeCode >= 401 && taxOfficeCode <= 409) ||
                taxOfficeCode == 515 ||
                taxOfficeCode == 517 ||
                taxOfficeCode == 518 ||
                (taxOfficeCode >= 702 && taxOfficeCode <= 709) ||
                (taxOfficeCode >= 801 && taxOfficeCode <= 809) ||
                (taxOfficeCode >= 901 && taxOfficeCode <= 909);
    }

    public String generateNIP() {
        String nip = generateUnverifiedNip();
        while (nip.length() != EXPECTED_NIP_SIZE) {
            nip = generateUnverifiedNip();
        }

        return nip;
    }

    private String generateUnverifiedNip() {
        String nip = taxOfficeCodes.get(
                number.randomNumber(taxOfficeCodes.size()));

        nip += regexp.randomStringFromRegexp(
                String.format(REGEXP_NUMBER_TEMPLATE, PARTIAL_NIP_SIZE));

        nip += calculateSum(nip) % CHECKSUM_MODIFIER;

        return nip;
    }
}