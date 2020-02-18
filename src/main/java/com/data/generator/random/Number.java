package com.data.generator.random;

import java.util.concurrent.ThreadLocalRandom;

public class Number {
    public int randomNumber(int min, int max) {
            return ThreadLocalRandom.current().nextInt(min, max);
    }

    public int randomNumber(int max) {
        return randomNumber(0, max);
    }
}