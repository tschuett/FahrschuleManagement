import EventStream.*;
import gui.MainController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

class Main {


    static final String FILE = "src/main/resources/Burg_Rabenstein.fit";

    void showStatistics() {
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        statisticsEventConsumer.doMath();

        List<CarEvent> events = fitCarEventStreamer.getEvents();
        Weather weather = new Weather();

        List<Weather.CustomerAndTemperature> l = weather.analyzeTemperature(events, 10);
        for (Weather.CustomerAndTemperature customerAndTemperature : l) {
            System.out.println(customerAndTemperature);
        }

        List<Weather.CarAndHumidity> humidity = weather.analyzeHumidity(events, 10);
        for (Weather.CarAndHumidity carAndHumidity : humidity) {
            System.out.println(carAndHumidity);
        }

        Braking braking = new Braking();
        List<LocalDateTime> brakes = braking.detectBraking(events);
        System.out.println("Number of braking points: " + brakes.size());
        for (LocalDateTime brake : brakes) {
            System.out.println(brake);
        }

        Mathematics mathematics = new Mathematics();
        Optional<GeoLocation> high = mathematics.getHighestPoint(events);
        Optional<GeoLocation> low = mathematics.getLowestPoint(events);
        if (high.isPresent() && low.isPresent()) {
            System.out.println("Note the E in the GeoLocations");
            System.out.println("High: " + high.get());
            System.out.println("Low: " + low.get());
            System.out.println("Distance: " + GeoLocation.distance(high.get(), low.get()));
        }
        else {
            System.out.println("No high or low point found.");
        }
    }

    void showGUI() {
        MainController controller = new MainController();
    }

    public static void main(String[] args) {
        Main main = new Main();

        //main.showStatistics();
        main.showGUI();
    }
}
