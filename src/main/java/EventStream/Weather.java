package EventStream;


import java.util.*;
import java.util.stream.Collectors;

public class Weather {

    public record CarAndHumidity(String carModel, Double humidity) {}

    public class CarAndHumidityComperator implements Comparator<CarAndHumidity> {

        @Override
        public int compare(CarAndHumidity o1, CarAndHumidity o2) {
            return o1.humidity.compareTo(o2.humidity);
        }
    }

    public List<CarAndHumidity> analyzeHumidity(List<CarEvent> events, int k) {
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

        PriorityQueue<CarAndHumidity> queue = new PriorityQueue<>(new CarAndHumidityComperator());
        for (Map.Entry<String, List<Double>> entry: humidityPerCarModel.entrySet()) {
          Double averageHumidity = entry.getValue().stream().collect(Collectors.averagingDouble(Double::doubleValue));
          queue.add(new CarAndHumidity(entry.getKey(), averageHumidity));
        }

        ArrayList<CarAndHumidity> result = new ArrayList<>();
        int upperBound = Math.min(k, queue.size());
        for (int i = 0; i < upperBound; i++) {
            result.add(queue.poll());
        }

        return result;
    }

    public record CustomerAndTemperature(Long customer, Double temperature) {}

    public class CustomerAndTemperaturComparator implements Comparator<CustomerAndTemperature> {

        @Override
        public int compare(CustomerAndTemperature o1, CustomerAndTemperature o2) {
            return o1.temperature.compareTo(o2.temperature);
        }
    }

   public List<CustomerAndTemperature> analyzeTemperature(List<CarEvent> events, int k) {
        Map<Long, List<Double>> temperaturePerCustomer = new HashMap<>();

        for (CarEvent event: events) {
            if (temperaturePerCustomer.containsKey(event.getCustomer())) {
                List<Double> temperature = temperaturePerCustomer.get(event.getCustomer());
                temperature.add(event.getTemperature());
                temperaturePerCustomer.put(event.getCustomer(), temperature);
            } else {
                temperaturePerCustomer.put(event.getCustomer(), new ArrayList<>());
            }
        }


        PriorityQueue<CustomerAndTemperature> queue = new PriorityQueue<>(new CustomerAndTemperaturComparator());
        for (Map.Entry<Long, List<Double>> temperature: temperaturePerCustomer.entrySet()) {
            Double averageTemperature = temperature.getValue().stream().collect(Collectors.averagingDouble(Double::doubleValue));
            queue.add(new CustomerAndTemperature(temperature.getKey(), averageTemperature));
        }

        ArrayList<CustomerAndTemperature> result = new ArrayList<>();
        int upperBound = Math.min(k, queue.size());
        for (int i = 0; i < upperBound; i++) {
            result.add(queue.poll());
        }

        return result;
    }

    Double getAverageTemperature(List<CarEvent> events) {
        return events.stream().map(CarEvent::getTemperature).collect(Collectors.averagingDouble(Double::doubleValue));
    }
}
