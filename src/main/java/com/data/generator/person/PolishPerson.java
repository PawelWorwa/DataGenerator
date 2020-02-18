package com.data.generator.person;

import com.data.generator.ResourceList;
import com.data.generator.person.ssn.pl.PolishSsnNumber;
import java.time.LocalDate;

public class PolishPerson extends AbstractPerson {
    private static final int MIN_LEGAL_AGE = 18;
    private static final int MAX_LEGAL_AGE = 65;

    private static final ResourceList maleFirstNamesList = new ResourceList("person/pl/maleNames.txt");
    private static final ResourceList femaleFirstNamesList = new ResourceList("person/pl/femaleNames.txt");
    private static final ResourceList surnamesList = new ResourceList("person/pl/surnames.txt");

    private final PolishSsnNumber ssn = new PolishSsnNumber();

    public PolishPerson(Gender gender) {
        super(gender);
    }

    @Override
    public String firstName() {
        return (Gender.MALE == gender) ? maleFirstNamesList.randomResource() : femaleFirstNamesList.randomResource();
    }

    @Override
    public String lastName() {
        String surname = surnamesList.randomResource();
        if (isFemale() && isSurnameNotFeminine(surname)) {
            return feminineSurname(surname);
        }

        return surname;
    }

    @Override
    public LocalDate birthDate() {
        return birthDate(randomAge());
    }

    private static boolean isSurnameNotFeminine(String surname) {
        return surname.charAt(surname.length() - 1) == 'i';
    }

    private static String feminineSurname(String surname) {
        return surname.substring(0, surname.length() - 1) + 'a';
    }

    @Override
    public String ssnNumber(int age) {
        return ssn.generate(gender, age);
    }

    @Override
    public String ssnNumber() {
        return ssn.generate(gender, randomAge());
    }

    private int randomAge() {
        return number.randomNumber(MIN_LEGAL_AGE, MAX_LEGAL_AGE);
    }
}