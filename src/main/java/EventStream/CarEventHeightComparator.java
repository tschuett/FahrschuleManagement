package EventStream;

import java.util.Comparator;

public class CarEventHeightComparator implements Comparator<CarEvent> {
    @Override
    public int compare(CarEvent o1, CarEvent o2) {
        if (o1.getHeight() < o2.getHeight())
            return -1;
        if (o1.getHeight() == o2.getHeight())
            return 0;
        return 1;
    }
}
