package EventStream;

import com.garmin.fit.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class FitCarEventStreamer implements CarEventStream {
    private List<CarEvent> events = new ArrayList<>();
    private List<Consumer<CarEvent>> listeners = new ArrayList<>();

    public FitCarEventStreamer(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);

            System.out.println(inputStream.available());
            FitDecoder fitDecoder = new FitDecoder();
            FitMessages fitMessages =  fitDecoder.decode(inputStream);

            List<RecordMesg> msgs = fitMessages.getRecordMesgs();

            for (RecordMesg msg: msgs) {
                System.out.println(msg.getPositionLat());
                GeoLocation location = new GeoLocation(msg.getPositionLat(), msg.getPositionLong());
                LocalDateTime time = java.time.LocalDateTime.of(msg.get);
                events.add(new CarEvent(location, time, height, msg.getSpeed(), msg.getTemperature(),
                        windSpeed, windDirection, humidity, direction, driverId,
                        carModel, carId, customerId, msg.getHeartRate()));
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
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
}
