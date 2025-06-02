package EventStream;

import java.time.LocalDateTime;

public final class GPSSignal {
    private final GeoLocation location;
    private final double speed;
    private final LocalDateTime time;

    GPSSignal(GeoLocation location, double speed, LocalDateTime time) {
        this.location = location;
        this.speed = speed;
        this.time = time;
    }

    LocalDateTime getTime() {
        return time;
    }

    double getSpeed() {
        return speed;
    }
}
