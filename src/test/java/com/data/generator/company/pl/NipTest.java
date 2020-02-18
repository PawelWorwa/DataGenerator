package com.data.generator.company.pl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NipTest {
    private static final int EXPECTED_NIP_SIZE = 10;
    private static final int CHECKSUM_MODIFIER = 11;

    private Nip nip = new Nip();

    @Test
    void testGenerateNIP() {
        String nipNumber = nip.generateNIP();
        Assertions.assertEquals(EXPECTED_NIP_SIZE, nipNumber.length(),
                "Polish Vat Identification Number has wrong length!");

        Assertions.assertTrue(nipNumber.matches("\\d+?"),
                "Polish Vat Identification Number contains illegal characters!");

        String taxOfficeCode = nipNumber.substring(0, 3);
        Assertions.assertFalse(nip.isTaxOfficeCodeExcluded(Integer.parseInt(taxOfficeCode)),
                String.format("Polish Vat Identification Number has wrong (not existing) tax office code: %s!", taxOfficeCode));

        String rawNipNumber = nipNumber.substring(0, 9);
        Assertions.assertEquals(nip.calculateSum(rawNipNumber) % CHECKSUM_MODIFIER,
                Integer.parseInt(nipNumber.substring(9, 10)),
                "Polish Vat Identification Number has wrong checksum!");
    }
}