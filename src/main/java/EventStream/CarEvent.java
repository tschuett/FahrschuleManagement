package EventStream;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Optional;

/// The central car event class. It contains fields for all sensor data.
/// CarEventStream creates a stream of instances of this class.
public final class CarEvent {
    private GeoLocation location;
    private LocalDateTime timestamp;
    private double height;
    private double speed;
    private double temperature;
    private double windSpeed;
    private double windDirection;
    private double humidity;
    private double direction;
    private long driverId;
    private String carModel;
    private long carId;
    private Optional<Long> customerId;
    private Optional<Double> customerHearbeat;

    public CarEvent(GeoLocation location, LocalDateTime timestamp, double height, double speed, double temperature,
                    double windSpeed, double windDirection, double humidity, double direction, long driverId, String carModel,
                    long carId, Optional<Long> customerId, Optional<Double> customerHearbeat) {
        this.location = location;
        this.timestamp = timestamp;
        this.height = height;
        this.speed = speed;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.humidity = humidity;
        this.direction = direction;
        this.driverId = driverId;
        this.carModel = carModel;
        this.carId = carId;
        this.customerId = customerId;
        this.customerHearbeat = customerHearbeat;
    }

    double getWindSpeed() {
        return windSpeed;
    }

    double getTemperature() {
        return temperature;
    }

    boolean hasCustomer() {
        return customerId.isPresent();
    }

    Long getCustomer() throws NoSuchElementException {
        return customerId.orElseThrow();
    }

    double getSpeed() {
        return speed;
    }

    LocalDateTime getTimeStamp() {
        return timestamp;
    }

    double getHumidity() {
        return humidity;
    }

    String getCarModel() {
        return carModel;
    }

    double getAltitude() {
        return height;
    }

    public double getHeight() {
        return height;
    }

    public GeoLocation getLocation() {
        return location;
    }
}