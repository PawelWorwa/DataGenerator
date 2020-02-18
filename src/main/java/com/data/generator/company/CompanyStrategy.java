package com.data.generator.company;

import com.data.generator.LocaleProvider;
import com.google.common.collect.ImmutableMap;
import java.util.Locale;

public final class CompanyStrategy {
    private static final ImmutableMap<Locale, AbstractCompany> COMPANY_CLASSES = new ImmutableMap.Builder<Locale, AbstractCompany>()
            .put(LocaleProvider.getLocale(LocaleProvider.POLISH), new PolishCompany())
            .build();

    private CompanyStrategy() {
        throw new IllegalStateException("CompanyStrategy is utility class!");
    }

    public static AbstractCompany provideCompany(Locale locale) {
        return COMPANY_CLASSES.get(locale);
    }
}