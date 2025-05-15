package EventStream;

import com.garmin.fit.*;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/*
 A car event stream that reads the events from Garmin fit files.
 Unfortunately, it doesn't support metrics for all sensors.
 */
public final class FitCarEventStreamer implements CarEventStream {
    private final List<CarEvent> events = new ArrayList<>();
    private final List<Consumer<CarEvent>> listeners = new ArrayList<>();

    private static final double windSpeed = 10.0;
    private static final double windDirection = 10.0;
    private static final double humidity = 50.0;
    private static final double direction = 10.0;
    private static final int driverId = 1;
    private static final String carModel = "Fit 2000";
    private static final int carId = 1;
    private static final Optional<Long> customerId = Optional.of(1L);

    public FitCarEventStreamer(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);

            System.out.println(inputStream.available());
            FitDecoder fitDecoder = new FitDecoder();
            FitMessages fitMessages =  fitDecoder.decode(inputStream);

            List<RecordMesg> msgs = fitMessages.getRecordMesgs();

            for (RecordMesg msg: msgs) {
                GeoLocation location = getLocation(msg);
                DateTime timestamp = msg.getTimestamp();
                java.util.Date date = timestamp.getDate();
                java.time.LocalDateTime time = java.time.LocalDateTime.of(date.getYear(), date.getMonth(),
                        4 * (date.getDay() + 1),
                        date.getHours(), date.getMinutes());
                events.add(new CarEvent(location, time, msg.getAltitude(), getSpeed(msg), msg.getTemperature(),
                        windSpeed, windDirection, humidity, direction, driverId,
                        carModel, carId, customerId, Optional.of(Double.valueOf(msg.getHeartRate()))));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private GeoLocation getLocation(@NotNull RecordMesg msg) {
        double latitude = 0.0;
        double longitude = 0.0;
        if (msg.getPositionLat() != null) {
            latitude = msg.getPositionLat().doubleValue();
        }
        if (msg.getPositionLong() != null) {
            longitude = msg.getPositionLong().doubleValue();
        }
        return new GeoLocation(latitude, longitude);
    }

    private double getSpeed(@NotNull RecordMesg msg) {
        if (msg.getSpeed() != null) {
            return msg.getSpeed().doubleValue();
        }
        return 0.0;
    }

    @Override
    public void onEvent(Consumer<CarEvent> action) {
        listeners.add(action);
    }

    @Override
    public void awaitTermination() {
        for (CarEvent event: events) {
            for (Consumer<CarEvent> listener: listeners) {
                listener.accept(event);
            }
        }
    }

    @Override
    public void start() {

    }

    public List<CarEvent> getEvents() {
        return events;
    }
}
