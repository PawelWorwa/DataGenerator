package com.data.generator.random;

import net.moznion.random.string.RandomStringGenerator;

public class Regexp {
    private final RandomStringGenerator stringGenerator = new RandomStringGenerator();

    public String randomStringFromRegexp(String regexp) {
        return stringGenerator.generateByRegex(regexp);
    }
}