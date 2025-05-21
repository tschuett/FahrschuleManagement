package EventStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoLocationTests {


    @Test
    void langitude() {
        GeoLocation location = new GeoLocation(6.0, 5.0);
        assertEquals(location.getLatitude(), 6.0);
    }

}
