import java.time.LocalDateTime;
import java.util.Optional;


class CarEvent {
    private GeoLocation location;
    private LocalDateTime timestamp;
    private double height;
    private double speed;
    private double temperature;
    private double direction;
    private long driverId;
    private String carModel;
    private long carId;
    private Optional<Long> customerId;
    private Optional<Double> customerHearbeat;
}