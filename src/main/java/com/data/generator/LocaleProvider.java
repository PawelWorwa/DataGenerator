package com.data.generator;

import com.google.common.collect.ImmutableMap;
import java.util.Locale;

public final class LocaleProvider {
    public static final String POLISH = "pl";

    private static final ImmutableMap<String, Locale> LOCALES = new ImmutableMap.Builder<String, Locale>()
            .put(POLISH, new Locale("pl"))
            .build();

    private LocaleProvider() {
        throw new IllegalStateException("ExtendedLocale is utility class!");
    }

    public static Locale getLocale(String key) {
        if (LOCALES.containsKey(key)) {
            return LOCALES.get(key);
        }

        throw new IllegalStateException(
                String.format("Not supported locale for country: %s", key));
    }
}