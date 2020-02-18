package com.data.generator.person;

import com.data.generator.LocaleProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;

public final class PersonStrategy {
    private static final ImmutableMap<Locale, PersonProvider> PERSON_PROVIDER_CLASSES = new ImmutableMap.Builder<Locale, PersonProvider>()
            .put(LocaleProvider.getLocale(LocaleProvider.POLISH), new PolishPersonProvider())
            .build();

    private PersonStrategy() {
        throw new IllegalStateException("PersonStrategy is utility class!");
    }

    public static PersonProvider providePerson(Locale locale) {
        return PERSON_PROVIDER_CLASSES.get(locale);
    }
}