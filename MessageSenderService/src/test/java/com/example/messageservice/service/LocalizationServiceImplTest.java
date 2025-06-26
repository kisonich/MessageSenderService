package com.example.messageservice.service;

import com.example.messageservice.entity.Country;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {
    private final LocalizationService localizationService = new LocalizationServiceImpl();

    @Test
    void locale_shouldReturnRussianTextForRussia() {
        String result = localizationService.locale(Country.RUSSIA);
        assertEquals("Добро пожаловать", result);
    }

    @Test
    void locale_shouldReturnEnglishTextForUsa() {
        String result = localizationService.locale(Country.USA);
        assertEquals("Welcome", result);
    }

    @Test
    void locale_shouldReturnEnglishTextForOtherCountries() {
        String result = localizationService.locale(Country.BRAZIL);
        assertEquals("Welcome", result);
    }
}