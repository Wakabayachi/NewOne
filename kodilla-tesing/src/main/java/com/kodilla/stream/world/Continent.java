package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public class Continent {
    private String name;
    private List<Country> countries = new ArrayList<>();

    public Continent(String name) {
        this.name = name;
    }

    public void addCountry(Country country) {
        countries.add(country);
    }

    public List<Country> getCountries() {
        return countries;
    }
}