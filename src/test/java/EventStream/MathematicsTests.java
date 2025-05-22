package EventStream;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathematicsTests {

    private CarEvent getCarEventWithSpeed(double speed) {
        GeoLocation location = new GeoLocation(1, 1);
        LocalDateTime timeStamp = LocalDateTime.now();
        return new CarEvent(location, timeStamp, 99.0, speed, 30.0, 32.0, 15.0, 99.0,
                20.0, 5, "Tesla Model Y", 7, Optional.empty(), Optional.empty());
    }

    @Test
    void averageSpeed() {
        Mathematics mathematics = new Mathematics();
        ArrayList<CarEvent> events = new ArrayList<>(Arrays.asList(getCarEventWithSpeed(50.0), getCarEventWithSpeed(100.0)));
        Double averageSpeed = mathematics.getAverageSpeed(events);
        assertEquals(75.0, averageSpeed);
    }
}
