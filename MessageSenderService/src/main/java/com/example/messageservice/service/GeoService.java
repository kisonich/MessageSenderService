package com.example.messageservice.service;

import com.example.messageservice.entity.Location;

public interface GeoService {
    Location byIp(String ip);
}