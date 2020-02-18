package com.data.generator.phone;

public interface PhoneNumber {
    String countryCode();

    String phoneNumber();

    String phoneNumber(String areaCode);

    String mobilePhoneNumber();
}