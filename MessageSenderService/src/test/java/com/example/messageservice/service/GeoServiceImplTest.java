package com.example.messageservice.service;

import com.example.messageservice.entity.Country;
import com.example.messageservice.entity.Location;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {
    private final GeoService geoService = new GeoServiceImpl();

    @Test
    void byIp_shouldReturnRussiaForRussianIp() {
        Location location = geoService.byIp("172.123.45.67");
        assertEquals(Country.RUSSIA, location.getCountry());
    }

    @Test
    void byIp_shouldReturnUsaForAmericanIp() {
        Location location = geoService.byIp("96.123.45.67");
        assertEquals(Country.USA, location.getCountry());
    }

    @Test
    void byIp_shouldReturnUsaForOtherIp() {
        Location location = geoService.byIp("10.123.45.67");
        assertEquals(Country.USA, location.getCountry());
    }

    @Test
    void byIp_shouldReturnUsaForNullIp() {
        Location location = geoService.byIp(null);
        assertEquals(Country.USA, location.getCountry());
    }
}