package com.tienda.samuelfhz.entity.ennumerations;

public enum Countries {
    SPAIN("Spain"),
    PORTUGAL("Portugal"),
    THE_UNITED_KINGDOM("The United Kingdom");

    private String countryString;

    Countries(String countryString) {
        this.countryString = countryString;
    }

    public String getCountryString() {
        return countryString;
    }
}
