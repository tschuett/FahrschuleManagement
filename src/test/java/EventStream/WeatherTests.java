package EventStream;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherTests {

    private CarEvent getCarEventWithTemperature(double temperature) {
        GeoLocation location = new GeoLocation(1, 1);
        LocalDateTime timeStamp = LocalDateTime.now();
        return new CarEvent(location, timeStamp, 5.0, 100.0, temperature, 32.0, 15.0, 99.0, 20.0, 5, "Tesla Model Y", 7, Optional.empty(), Optional.empty());
    }

    @Test
    void getAverageTemperature() {
        Weather weather = new Weather();
        List<CarEvent> events = Arrays.asList(getCarEventWithTemperature(50.0), getCarEventWithTemperature(100.0));
        assertEquals(75.0, weather.getAverageTemperature(events));
    }
}
