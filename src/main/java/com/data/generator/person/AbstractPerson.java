package com.data.generator.person;

import com.data.generator.random.Date;
import com.data.generator.random.Number;
import java.time.LocalDate;

public abstract class AbstractPerson implements Person {
    protected final Number number = new Number();
    private final Date date = new Date();

    protected Gender gender;

    public AbstractPerson(Gender gender) {
        this.gender = gender;
    }

    public LocalDate birthDate(int age) {
        return date.past(age);
    }

    public boolean isMale() {
        return gender == Gender.MALE;
    }

    public boolean isFemale() {
        return gender == Gender.FEMALE;
    }
}