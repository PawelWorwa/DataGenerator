package com.data.generator.phone;

import com.data.generator.LocaleProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;

public final class PhoneNumberStrategy {
    private static final ImmutableMap<Locale, PhoneNumber> PHONE_NUMBER_CLASSES = new ImmutableMap.Builder<Locale, PhoneNumber>()
            .put(LocaleProvider.getLocale(LocaleProvider.POLISH), new PolishPhoneNumber())
            .build();

    private PhoneNumberStrategy() {
        throw new IllegalStateException("PhoneNumberStrategy is utility class!");
    }

    public static PhoneNumber providePhoneNumber(Locale locale) {
        return PHONE_NUMBER_CLASSES.get(locale);
    }
}