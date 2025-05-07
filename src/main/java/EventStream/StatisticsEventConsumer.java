package EventStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

/// Event consumer that collects statistics over the event stream.
///
/// It collects a histogram over the reported temperature events.
public class StatisticsEventConsumer implements Consumer<CarEvent> {
    Map<Double, Integer> histogramTemperature = new HashMap<>();
    Map<Long, ArrayList<Double>> averageSpeedPerCustomer = new HashMap<>();


    @Override
    public void accept(CarEvent carEvent) {
        histogramTemperature.put(carEvent.getTemperature(),
                histogramTemperature.getOrDefault(carEvent.getTemperature(), 0) + 1);
       // if (carEvent.hasCustomer()) {
       //     averageSpeedPerCustomer.put(carEvent.getCustomer(),
       //             averageSpeedPerCustomer.getOrDefault(carEvent.getCustomer(), new ArrayList<>()).add(carEvent.getSpeed()));
       // }
    }
}
