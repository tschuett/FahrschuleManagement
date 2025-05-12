package EventStream;

import java.util.ArrayList;
import java.util.function.Consumer;

/// Event consumer that collects statistics over the event stream.
public class StatisticsEventConsumer implements Consumer<CarEvent> {
    ArrayList<CarEvent> events = new ArrayList<>();


    @Override
    public void accept(CarEvent carEvent) {
        events.add(carEvent);
    }

    public void doMath() {
        Mathematics mathematics = new Mathematics();
        Double angle = mathematics.angleProductSpeedAndTemperature(events);
        System.out.println("Angle between speed and temperature: " + angle);

        Double angleAlt = mathematics.angleProductSpeedAndAltitude(events);
        System.out.println("Angle between speed and altitude: " + angleAlt);

        Weather weather = new Weather();
        System.out.println("Average temperature: " + weather.getAverageTemperature(events));
        System.out.println("Average speed: " + mathematics.getAverageSpeed(events));
    }
}
