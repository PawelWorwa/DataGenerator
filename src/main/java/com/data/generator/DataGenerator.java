package com.data.generator;

import com.data.generator.address.Address;
import com.data.generator.address.AddressStrategy;
import com.data.generator.company.AbstractCompany;
import com.data.generator.company.CompanyStrategy;
import com.data.generator.person.PersonProvider;
import com.data.generator.person.PersonStrategy;
import com.data.generator.phone.PhoneNumber;
import com.data.generator.phone.PhoneNumberStrategy;
import com.data.generator.random.LoremIpsum;
import com.data.generator.random.Number;
import com.data.generator.random.Regexp;
import java.util.Locale;

public class DataGenerator {
    private final Locale locale;

    private final LoremIpsum loremIpsum = new LoremIpsum();
    private final Number number = new Number();
    private final Regexp regexp = new Regexp();

    public DataGenerator(String localeCountry) {
        this.locale = LocaleProvider.getLocale(localeCountry);
    }

    public DataGenerator() {
        this.locale = LocaleProvider.getLocale(LocaleProvider.POLISH);
    }

    public LoremIpsum loremIpsum() {
        return loremIpsum;
    }

    public Number number() {
        return number;
    }

    public Regexp regexp() {
        return regexp;
    }

    public PhoneNumber phoneNumber() {
        return PhoneNumberStrategy.providePhoneNumber(locale);
    }

    public PersonProvider person() {
        return PersonStrategy.providePerson(locale);
    }

    public AbstractCompany company() {
        return CompanyStrategy.provideCompany(locale);
    }

    public Address address() {
        return AddressStrategy.provideAddress(locale);
    }
}