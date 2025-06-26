package com.example.messageservice.entity;

import com.example.messageservice.entity.Country;

public class Location {
    private Country country;

    public Location(Country country) {
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }
}