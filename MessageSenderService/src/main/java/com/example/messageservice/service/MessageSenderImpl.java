package com.example.messageservice.service;

public class MessageSenderImpl implements MessageSender {
    private final GeoService geoService;
    private final LocalizationService localizationService;

    public MessageSenderImpl(GeoService geoService, LocalizationService localizationService) {
        this.geoService = geoService;
        this.localizationService = localizationService;
    }

    @Override
    public String send(String ip) {
        var location = geoService.byIp(ip);
        return localizationService.locale(location.getCountry());
    }
}