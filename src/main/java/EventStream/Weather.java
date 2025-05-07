package EventStream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Weather {



    void analyzeHumidity(List<CarEvent> events) {
        Map<String, List<Double>> humidityPerCarModel = new HashMap<>();

        for (CarEvent event: events) {
            if (humidityPerCarModel.containsKey(event.getCarModel())) {
                List<Double> humidity = humidityPerCarModel.get(event.getCarModel());
                humidity.add(event.getHumidity());
                humidityPerCarModel.put(event.getCarModel(), humidity);
            } else {
                humidityPerCarModel.put(event.getCarModel(), new ArrayList<>());
            }
        }

        for (Map.Entry<String, List<Double>> entry: humidityPerCarModel.entrySet()) {

           //Double sum = entry.getValue().stream().sum();
        }
    }
}
