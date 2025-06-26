package com.example.messageservice.service;

import com.example.messageservice.entity.Country;

public interface LocalizationService {
    String locale(Country country);
}