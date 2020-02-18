package com.data.generator.person;

public class PolishPersonProvider implements PersonProvider {
    @Override
    public AbstractPerson male() {
        return new PolishPerson(Gender.MALE);
    }

    @Override
    public AbstractPerson female() {
        return new PolishPerson(Gender.FEMALE);
    }
}