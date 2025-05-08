package EventStream;


import java.util.*;
import java.util.stream.Collectors;

public class Weather {

    static class Car {
        String model;
        int driverId;
        int studentId;
    }

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

    record CustomerAndTemperature(Long customer, Double temperature) {}

    class CustomerAndTemperaturComparator implements Comparator<CustomerAndTemperature> {

        @Override
        public int compare(CustomerAndTemperature o1, CustomerAndTemperature o2) {
            return o1.temperature.compareTo(o2.temperature);
        }
    }

    void analyzeTemperature(List<CarEvent> events) {
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

        ArrayList<CustomerAndTemperature> averageTemperatures = new ArrayList<>();

        for (Map.Entry<Long, List<Double>> temperature: temperaturePerCustomer.entrySet()) {
            Double averageTemperature = temperature.getValue().stream().collect(Collectors.averagingDouble(Double::doubleValue));
            averageTemperatures.add(new CustomerAndTemperature(temperature.getKey(), averageTemperature));
        }

        Collections.sort(averageTemperatures, new CustomerAndTemperaturComparator());

    }
}
