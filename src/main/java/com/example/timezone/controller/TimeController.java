package com.example.timezone.controller;

import org.springframework.web.bind.annotation.*;
import java.time.*;
import java.time.format.DateTimeFormatter;

@RestController
public class TimeController {

    @PostMapping("/timezone/localtime")
    public String getLocalTime(@RequestBody TimeZoneRequest request) {
        // Utilisation du time zone venant du body de la requête
        String timeZoneId = request.getTimezone();

        // Obtention de la date et heure dans le fuseau horaire spécifié
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(timeZoneId));

        // Formater la date et l'heure pour un affichage plus lisible
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy, HH:mm:ss");
        String formattedDate = dateTime.format(formatter);

        // Retourner la réponse formatée
        return "Current time in " + timeZoneId + ": " + formattedDate;
    }
}

class TimeZoneRequest {
    private String timezone;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
