package com.example.messageservice.service;

import com.example.messageservice.entity.Country;
import com.example.messageservice.entity.Location;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplTest {
    @Mock
    private GeoService geoService;

    @Mock
    private LocalizationService localizationService;

    @InjectMocks
    private MessageSenderImpl messageSender;

    @Test
    void send_shouldReturnRussianTextForRussianIp() {
        when(geoService.byIp("172.123.45.67"))
                .thenReturn(new Location(Country.RUSSIA));
        when(localizationService.locale(Country.RUSSIA))
                .thenReturn("Добро пожаловать");

        String result = messageSender.send("172.123.45.67");

        assertEquals("Добро пожаловать", result);
        verify(geoService).byIp("172.123.45.67");
        verify(localizationService).locale(Country.RUSSIA);
    }

    @Test
    void send_shouldReturnEnglishTextForAmericanIp() {
        when(geoService.byIp("96.123.45.67"))
                .thenReturn(new Location(Country.USA));
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        String result = messageSender.send("96.123.45.67");

        assertEquals("Welcome", result);
        verify(geoService).byIp("96.123.45.67");
        verify(localizationService).locale(Country.USA);
    }

    @Test
    void send_shouldReturnEnglishTextForOtherIp() {
        when(geoService.byIp("10.123.45.67"))
                .thenReturn(new Location(Country.USA));
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        String result = messageSender.send("10.123.45.67");

        assertEquals("Welcome", result);
        verify(geoService).byIp("10.123.45.67");
        verify(localizationService).locale(Country.USA);
    }

    @Test
    void send_shouldReturnEnglishTextForNullIp() {
        when(geoService.byIp(null))
                .thenReturn(new Location(Country.USA));
        when(localizationService.locale(Country.USA))
                .thenReturn("Welcome");

        String result = messageSender.send(null);

        assertEquals("Welcome", result);
        verify(geoService).byIp(null);
        verify(localizationService).locale(Country.USA);
    }
}