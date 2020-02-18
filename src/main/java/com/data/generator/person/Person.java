package com.data.generator.person;

import java.time.LocalDate;

public interface Person {
    String firstName();

    String lastName();

    LocalDate birthDate();

    LocalDate birthDate(int age);

    String ssnNumber(int age);

    String ssnNumber();
}
