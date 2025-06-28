package com.example.messageservice.service;

import com.example.messageservice.entity.Country;
import com.example.messageservice.entity.Location;

public class GeoServiceImpl implements GeoService {
    @Override
    public Location byIp(String ip) {
        if (ip == null || ip.isEmpty()) {
            return new Location(Country.USA);
        }

        if (ip.startsWith("172.")) {
            return new Location(Country.RUSSIA);
        } else if (ip.startsWith("96.")) {
            return new Location(Country.USA);
        }

        return new Location(Country.USA);
    }
}