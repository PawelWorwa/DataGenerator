package com.data.generator.phone;

import com.data.generator.address.PolishAddress;
import com.data.generator.random.Regexp;

public class PolishPhoneNumber implements PhoneNumber {
    private static final String POLISH_COUNTRY_CODE = "+48";
    private static final String PHONE_NUMBER_REGEXP = "[0-9]{7}";
    private static final String MOBILE_PHONE_NUMBER_REGEXP = "[0-9]{9}";

    private final Regexp regexp = new Regexp();

    @Override
    public String countryCode() {
        return POLISH_COUNTRY_CODE;
    }

    @Override
    public String phoneNumber() {
        return new PolishAddress().areaCode() + this.regexp.randomStringFromRegexp(PHONE_NUMBER_REGEXP);
    }

    @Override
    public String phoneNumber(String areaCode) {
        return areaCode + regexp.randomStringFromRegexp(PHONE_NUMBER_REGEXP);
    }

    @Override
    public String mobilePhoneNumber() {
        return regexp.randomStringFromRegexp(MOBILE_PHONE_NUMBER_REGEXP);
    }
}