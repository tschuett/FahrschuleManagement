package Database;

import EventStream.CarEvent;
import EventStream.CarEventHeightComparator;
import EventStream.GeoLocation;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarEventHeightComparatorTests {

    private CarEvent getCarEventWithHeight(double height) {
        GeoLocation location = new GeoLocation(1, 1);
        LocalDateTime timeStamp = LocalDateTime.now();
        return new CarEvent(location, timeStamp, height, 100.0, 30.0, 32.0, 15.0, 99.0, 20.0, 5, "Tesla Model Y", 7, Optional.empty(), Optional.empty());
    }

    @Test
    void smaller() {
        CarEvent smallerHeight = getCarEventWithHeight(4.0);
        CarEvent largerHeight = getCarEventWithHeight(90.0);
        CarEventHeightComparator comparator = new CarEventHeightComparator();
        assertEquals(-1, comparator.compare(smallerHeight, largerHeight));
    }

    @Test
    void equals() {
        CarEvent smallerHeight = getCarEventWithHeight(90.0);
        CarEvent largerHeight = getCarEventWithHeight(90.0);
        CarEventHeightComparator comparator = new CarEventHeightComparator();
        assertEquals(0, comparator.compare(smallerHeight, largerHeight));
    }

    @Test
    void larger() {
        CarEvent smallerHeight = getCarEventWithHeight(4.0);
        CarEvent largerHeight = getCarEventWithHeight(90.0);
        CarEventHeightComparator comparator = new CarEventHeightComparator();
        assertEquals(1, comparator.compare(largerHeight, smallerHeight));
    }
}
