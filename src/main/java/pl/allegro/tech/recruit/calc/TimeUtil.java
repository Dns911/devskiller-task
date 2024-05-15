package pl.allegro.tech.recruit.calc;

import java.time.ZonedDateTime;

public class TimeUtil {
    private final ZonedDateTime zonedDateTime = ZonedDateTime.now();

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }
}
