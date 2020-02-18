package com.data.generator.address;

import com.data.generator.ResourceList;
import com.data.generator.random.Number;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class PolishAddress implements Address {
    private static final String ADDRESS_FILE = "address/pl/address.txt";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    private static final List<AddressDto> ADDRESS_INFORMATIONS = new ArrayList<>();


    static {
        new ResourceList(ADDRESS_FILE).getResources()
                .forEach(line -> {
                    String[] values = line.split(";");
                    AtomicInteger index = new AtomicInteger(0);

                    AddressDto address = new AddressDto();
                    address.setState(values[index.getAndIncrement()]);
                    address.setCity(values[index.getAndIncrement()]);
                    address.setTelephoneAreaCode(values[index.getAndIncrement()]);
                    address.setStreetName(values[index.getAndIncrement()]);
                    address.setPostalCode(values[index.getAndIncrement()]);

                    ADDRESS_INFORMATIONS.add(address);
                });
    }

    private final Number number = new Number();
    private final AddressDto address;

    public PolishAddress() {
        address = ADDRESS_INFORMATIONS.get(
                number.randomNumber(1, ADDRESS_INFORMATIONS.size() - 1));
    }

    private String randomNumber() {
        return Integer.toString(
                number.randomNumber(MIN_NUMBER, MAX_NUMBER));
    }

    @Override
    public String street() {
        return address.getStreetName();
    }

    @Override
    public String flatNumber() {
        return randomNumber();
    }

    @Override
    public String houseNumber() {
        return randomNumber();
    }

    @Override
    public String postalCode() {
        return address.getPostalCode();
    }

    @Override
    public String city() {
        return address.getCity();
    }

    @Override
    public String areaCode() {
        return address.getTelephoneAreaCode();
    }

    @Override
    public String state() {
        return address.getState();
    }
}