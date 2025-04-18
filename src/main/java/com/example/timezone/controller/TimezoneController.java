package com.example.timezone.controller;

import com.example.timezone.model.GeoLocation;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@RestController
@RequestMapping("/timezone")
public class TimezoneController {

    @PostMapping("/localtime")
    public String getLocalTime(@RequestBody GeoLocation geo) {
        // Utilisation de "Europe/Paris" pour l'exemple, tu peux le remplacer par un calcul basé sur les coordonnées
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of("Europe/Paris"));
        return "Current time at lat: " + geo.getLat() + ", lon: " + geo.getLon() + " => " + dateTime.toString();
    }
}
