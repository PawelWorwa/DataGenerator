package com.data.generator.random;

import java.time.LocalDate;

public class Date {
    private static final int FIRST_DAY_IN_CALENDAR = 1;
    private static final int LAST_DAY_IN_CALENDAR = 365;

    private Number number = new Number();

    public LocalDate past(int yearsAgo) {
        return LocalDate.ofYearDay(LocalDate.now().getYear() - yearsAgo,
                number.randomNumber(FIRST_DAY_IN_CALENDAR, LAST_DAY_IN_CALENDAR));
    }
}