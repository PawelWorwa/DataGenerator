package com.data.generator.company;

import com.data.generator.company.pl.Nip;
import com.data.generator.company.pl.Regon;

public class PolishCompany extends AbstractCompany {
    private final Regon regon = new Regon();
    private final Nip nip = new Nip();

    @Override
    public String vatIdentificationNumber() {
        return nip.generateNIP();
    }

    @Override
    public String registrationNumber() {
        return regon.generateShortRegon();
    }

    @Override
    public String shortRegistrationNumber() {
        return regon.generateShortRegon();
    }

    @Override
    public String longRegistrationNumber() {
        return regon.generateLongRegon();
    }
}