package EventStream;

import java.util.Comparator;

public class GPSSignalComparator implements Comparator<GPSSignal> {
    @Override
    public int compare(GPSSignal o1, GPSSignal o2) {
        if (o1.getLocation() == o2.getLocation() && o1.getTime() == o2.getTime() && o1.getSpeed() == o2.getSpeed()) {
            return 0;
        }
        if (o1.getLocation() == o2.getLocation() && o1.getTime() == o2.getTime() && o1.getSpeed() < o2.getSpeed()) {
            return -1;
        }
        if (o1.getLocation() == o2.getLocation() && o1.getTime() == o2.getTime() && o1.getSpeed() > o2.getSpeed()) {
            return 1;
        }
        if (o1.getLocation() == o2.getLocation() && o1.getTime().isBefore(o2.getTime())) {
            return -1;
        }
        if (o1.getLocation() == o2.getLocation() && o1.getTime().isAfter(o2.getTime())) {
            return 1;
        }
        GeoLocationComparator comparator = new GeoLocationComparator();
        int compare = comparator.compare(o1.getLocation(), o2.getLocation());
        if (compare < 0) {
            return -1;
        }
        if (compare > 0) {
            return 1;
        }
        return 0;
    }
}
