package com.data.generator.random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NumberTest {
    private static final int MIN_NUMBER = 0;
    private static final int MAX_NUMBER = 10;

    private Number number = new Number();

    @Test
    void testRandomNumber() {
        verifyBoundaries(number.randomNumber(MAX_NUMBER));
    }

    @Test
    void testRandomNumberForBothBoundaries() {
        verifyBoundaries(number.randomNumber(MIN_NUMBER, MAX_NUMBER));
    }

    private void verifyBoundaries(int number) {
        Assertions.assertTrue(number >= MIN_NUMBER,
                "Generated number is higher that expected!");

        Assertions.assertTrue(number <= MAX_NUMBER,
                "Generated number is lesser that expected!");
    }
}