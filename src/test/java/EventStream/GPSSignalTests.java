package EventStream;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPSSignalTests {

    @Test
    void speed() {
        GPSSignal signal = new GPSSignal(new GeoLocation(1, 1), 10, null);
        assertEquals(10.0, signal.getSpeed());
    }

    @Test
    void time() {
        LocalDateTime time = LocalDateTime.now();
        GPSSignal signal = new GPSSignal(new GeoLocation(1, 1), 10, time);
        assertEquals(time, signal.getTime());
    }
}
