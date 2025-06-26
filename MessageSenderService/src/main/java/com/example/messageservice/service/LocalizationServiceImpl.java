package com.example.messageservice.service;

import com.example.messageservice.entity.Country;

public class LocalizationServiceImpl implements LocalizationService {
    @Override
    public String locale(Country country) {
        if (country == Country.RUSSIA) {
            return "Добро пожаловать";
        }
        return "Welcome";
    }
}