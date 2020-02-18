package com.data.generator.address;

public class AddressDto {
    private String state;
    private String city;
    private String telephoneAreaCode;
    private String streetName;
    private String postalCode;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephoneAreaCode() {
        return telephoneAreaCode;
    }

    public void setTelephoneAreaCode(String telephoneAreaCode) {
        this.telephoneAreaCode = telephoneAreaCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
}
