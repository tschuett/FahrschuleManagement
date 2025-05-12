package EventStream;

import java.util.List;
import java.util.stream.Collectors;

public class Mathematics {


    Double dotProductSpeedAndTemperature(List<CarEvent> events) {
        return events.stream().map((CarEvent event) -> event.getSpeed() * event.getTemperature()).reduce(0.0, Double::sum);
    }

    // Returns the angle between speed and temperature.
    Double angleProductSpeedAndTemperature(List<CarEvent> events) {
        // The dot product of the speed and temperature vectors.
        Double dot = events.stream().map((CarEvent event) -> event.getSpeed() * event.getTemperature()).reduce(0.0, Double::sum);
        double div = dot / (events.size() * events.size());
        return Math.acos(div); // the arc cosine of a value
    }

    // Returns the angle between speed and altitude.
    Double angleProductSpeedAndAltitude(List<CarEvent> events) {
        // The dot product of the speed and altitude vectors.
        Double dot = events.stream().map((CarEvent event) -> event.getSpeed() * event.getAltitude()).reduce(0.0, Double::sum);
        double div = dot / (events.size() * events.size());
        return Math.acos(div); // the arc cosine of a value
    }

    Double getAverageSpeed(List<CarEvent> events) {
        return events.stream().map(CarEvent::getSpeed).collect(Collectors.averagingDouble(Double::doubleValue));
    }
}
