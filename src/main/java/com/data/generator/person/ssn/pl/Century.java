package com.data.generator.person.ssn.pl;

public enum Century {
    XIX(80, 1800, 1899),
    XX(0, 1900, 1999),
    XXI(20, 2000, 2099),
    XXII(40, 2100, 2199),
    XXIII(60, 2200, 2299);

    private final int yearFrom;
    private final int yearTo;
    private final int centuryMarker;

    Century(int centuryMarker, int yearFrom, int yearTo) {
        this.centuryMarker = centuryMarker;
        this.yearFrom = yearFrom;
        this.yearTo = yearTo;
    }

    public boolean isCentury(int year) {
        return year >= this.yearFrom && year <= this.yearTo;
    }

    public int getCenturyMarker() {
        return centuryMarker;
    }
}