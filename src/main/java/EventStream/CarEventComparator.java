package EventStream;

import java.util.Comparator;

public final class CarEventComparator implements Comparator<CarEvent> {
    @Override
    public int compare(CarEvent o1, CarEvent o2) {
        return o1.getTimeStamp().compareTo(o2.getTimeStamp());
    }
}
