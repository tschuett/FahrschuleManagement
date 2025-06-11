package EventStream;

import org.jfree.data.xy.XYSeries;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/// Event consumer that collects statistics over the event stream.
public class StatisticsEventConsumer implements Consumer<CarEvent> {
    private final ArrayList<CarEvent> events = new ArrayList<>();


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

    public XYSeries getSpeedXYSeries() {
        XYSeries speedXYSeries = new XYSeries("Speed");
        for (CarEvent carEvent : events) {
            LocalDateTime localDateTime = carEvent.getTimeStamp();
            double timeStamp = getAsSeconds(localDateTime);
            speedXYSeries.add(timeStamp, carEvent.getSpeed());
        }
        return speedXYSeries;
    }


    public XYSeries getTemperatureXYSeries() {
        XYSeries speedXYSeries = new XYSeries("Temperature");
        for (CarEvent carEvent : events) {
            LocalDateTime localDateTime = carEvent.getTimeStamp();
            double timeStamp = getAsSeconds(localDateTime);
            speedXYSeries.add(timeStamp, carEvent.getTemperature());
        }
        return speedXYSeries;
    }

    public XYSeries getHeartBeatXYSeries() {
        XYSeries speedXYSeries = new XYSeries("Heartbeat");
        for (CarEvent carEvent : events) {
            LocalDateTime localDateTime = carEvent.getTimeStamp();
            double timeStamp = getAsSeconds(localDateTime);
            Optional<Double> heartBeat = carEvent.getCustomerHeartbeat();
            heartBeat.ifPresent((Double aDouble) -> speedXYSeries.add(timeStamp, aDouble));
        }
        return speedXYSeries;
    }

    public XYSeries getHeightXYSeries() {
        XYSeries speedXYSeries = new XYSeries("Temperature");
        for (CarEvent carEvent : events) {
            LocalDateTime localDateTime = carEvent.getTimeStamp();
            double timeStamp = getAsSeconds(localDateTime);
            speedXYSeries.add(timeStamp, carEvent.getHeight());
        }
        return speedXYSeries;
    }

    private double getAsSeconds(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.UTC);
    }

     public List<CarEvent> getEvents() {
        return events;
    }
}
