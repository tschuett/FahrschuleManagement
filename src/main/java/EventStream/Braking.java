package EventStream;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class Braking {

    static final double BRAKING_LIMIT = 0.01;

    /**
     * Given a list of car events, detect hard braking points.
     * @param signals
     * @return
     */
    public List<LocalDateTime> detectBraking(List<CarEvent> signals) {
        ArrayList<CarEvent> brakingSignals = new ArrayList<>(signals);
        // first sort signals by time
        brakingSignals.sort(Comparator.comparing(CarEvent::getTimeStamp));


        ArrayList<LocalDateTime> brakePoints = new ArrayList<>();
        for (int i = 0; i < brakingSignals.size() - 2; i++) {
            CarEvent current = brakingSignals.get(i);
            CarEvent next = brakingSignals.get(i + 1);

            // differences of the current and next event in speed and time
            double speedDifference = current.getSpeed() - next.getSpeed();
            double secondsDifference = ChronoUnit.SECONDS.between(current.getTimeStamp(), next.getTimeStamp());

            // speed dropped && the events had a time difference?
            if (speedDifference > 0.0 && secondsDifference > 0.0) {
                double speedReductionPerSecond = speedDifference / secondsDifference;
                if (speedReductionPerSecond > BRAKING_LIMIT) {
                    brakePoints.add(current.getTimeStamp());
                }
            }
        }

        return brakePoints;
    }
}
