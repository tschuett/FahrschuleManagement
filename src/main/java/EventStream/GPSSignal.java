package EventStream;

import java.time.LocalDateTime;

public class GPSSignal {
    private GeoLocation location;
    private double speed;
    private LocalDateTime time;


    LocalDateTime getTime() {
        return time;
    }

    double getSpeed() {
        return speed;
    }
}
