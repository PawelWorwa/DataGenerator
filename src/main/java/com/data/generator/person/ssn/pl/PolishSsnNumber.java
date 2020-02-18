package com.data.generator.person.ssn.pl;

import com.data.generator.person.Gender;
import com.data.generator.person.ssn.SsnNumber;
import com.data.generator.random.Date;
import com.data.generator.random.Number;
import com.data.generator.random.Regexp;
import java.time.LocalDate;

public class PolishSsnNumber implements SsnNumber {
    private static final String NUMBERS_REGEXP_TEMPLATE = "[0-9]{3}";
    private static final String WEIGHTS = "1379137913";
    private static final String MALE_ORDINAL_NUMBERS = "13579";
    private static final String FEMALE_ORDINAL_NUMBERS = "02468";

    private Number number = new Number();
    private Regexp regexp = new Regexp();
    private Date randomDate = new Date();

    private static String addLeadingZeroIfRequired(String value) {
        if (value.length() == 1) {
            return "0" + value;
        }

        return value;
    }

    int getAssignedMarkerForCentury(int year) {
        for (Century century : Century.values()) {
            if (century.isCentury(year)) {
                return century.getCenturyMarker();
            }
        }

        throw new IllegalStateException("There is no predefined century for provided year!");
    }

    String calculateChecksum(String ssn) {
        int sum = 0;
        for (int i = 0; i < ssn.length(); ++i) {
            int wage = Character.getNumericValue(WEIGHTS.charAt(i));
            int digit = Character.getNumericValue(ssn.charAt(i));
            sum += wage * digit;
        }

        sum %= 10;
        sum = 10 - sum;
        sum %= 10;

        return Integer.toString(sum);
    }

    private String getMaleOrdinalNumber() {
        int index = number.randomNumber(MALE_ORDINAL_NUMBERS.length());
        return String.valueOf(MALE_ORDINAL_NUMBERS.charAt(index));
    }

    private String getFemaleOrdinalNumber() {
        int index = number.randomNumber(FEMALE_ORDINAL_NUMBERS.length());
        return String.valueOf(FEMALE_ORDINAL_NUMBERS.charAt(index));
    }

    @Override
    public String generate(Gender gender, int age) {
        StringBuilder ssn = new StringBuilder();
        LocalDate birthDate = randomDate.past(age);
        ssn.append(
                String.valueOf(birthDate.getYear()).substring(2, 4));

        String month = String.valueOf(
                getAssignedMarkerForCentury(birthDate.getYear()) + birthDate.getMonthValue());

        ssn.append(addLeadingZeroIfRequired(month));

        String day = String.valueOf(birthDate.getDayOfMonth());
        ssn.append(addLeadingZeroIfRequired(day));
        ssn.append(regexp.randomStringFromRegexp(NUMBERS_REGEXP_TEMPLATE));
        ssn.append((Gender.MALE == gender) ? getMaleOrdinalNumber() : getFemaleOrdinalNumber());
        ssn.append(calculateChecksum(ssn.toString()));

        return ssn.toString();
    }
}