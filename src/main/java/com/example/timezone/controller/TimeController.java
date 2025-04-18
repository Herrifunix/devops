package com.example.timezone;
import org.springframework.web.bind.annotation.*;
import java.time.*;

@RestController
public class TimezoneController {

    @PostMapping("/timezone/localtime")
    public String getLocalTime(@RequestBody TimeZoneRequest request) {
        // Use the time zone from the request
        String timeZoneId = request.getTimezone();

        // Get current time in the specified time zone
        ZonedDateTime dateTime = ZonedDateTime.now(ZoneId.of(timeZoneId));

        // Return the formatted response
        return "Current time in " + timeZoneId + " is " + dateTime.toString();
    }
}

class TimeZoneRequest {
    private String timezone;

    // Getter and setter for timezone
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
