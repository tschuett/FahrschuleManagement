package EventStream;

import java.util.Comparator;

public class GeoLocationComparator implements Comparator<GeoLocation> {
    @Override
    public int compare(GeoLocation o1, GeoLocation o2) {
        if (o1.getLatitude() == o2.getLatitude() && o1.getLongitude() == o2.getLongitude())
            return 0;
        if (o1.getLatitude() == o2.getLatitude() && o1.getLongitude() < o2.getLongitude())
            return -1;
        if (o1.getLatitude() == o2.getLatitude() && o1.getLongitude() > o2.getLongitude())
            return 1;
        if (o1.getLatitude() < o2.getLatitude())
            return -1;
        if (o1.getLatitude() > o2.getLatitude())
            return 1;
        return 0;
    }
}
