package EventStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GPSSignalTests {

    @Test
    void speed() {
        GPSSignal signal = new GPSSignal(new GeoLocation(1, 1), 10, null);
        assertEquals(10.0, signal.getSpeed());
    }
}
