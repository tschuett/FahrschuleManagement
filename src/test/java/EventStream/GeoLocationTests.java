package EventStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeoLocationTests {


    @Test
    void langitude() {
        GeoLocation location = new GeoLocation(6.0, 5.0);
        assertEquals(6.0, location.getLatitude());
    }

    @Test
    void longitude() {
        GeoLocation location = new GeoLocation(6.0, 7.2);
        assertEquals(7.2, location.getLongitude());
    }

    @Test
    void distance() {
        GeoLocation a = new GeoLocation(1, 1);
        GeoLocation b = new GeoLocation(2, 2);
        assertEquals(2.0, GeoLocation.distance(a, b));
    }

    @Test
    void toStringTest() {
        GeoLocation location = new GeoLocation(6.0, 5.0);
        assertEquals("GeoLocation{latitude=6.0, longitude=5.0}", location.toString());
    }
}
