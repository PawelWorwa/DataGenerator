package com.data.generator.address;

import com.data.generator.LocaleProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;

public final class AddressStrategy {
    private static final ImmutableMap<Locale, Address> ADDRESS_CLASSES = new ImmutableMap.Builder<Locale, Address>()
            .put(LocaleProvider.getLocale(LocaleProvider.POLISH), new PolishAddress())
            .build();

    private AddressStrategy() {
        throw new IllegalStateException("CompanyStrategy is utility class!");
    }

    public static Address provideAddress(Locale locale) {
        return ADDRESS_CLASSES.get(locale);
    }
}
