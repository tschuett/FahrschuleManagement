package Database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarTests {

    @Test
    void id() {
        Car car = new Car(1, 1, 1);
        assertEquals(1, car.id());
    }

    @Test
    void studentId() {
        Car car = new Car(1, 1, 2);
        assertEquals(2, car.studentId());
    }
}
