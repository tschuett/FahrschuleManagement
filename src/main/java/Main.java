import EventStream.*;
import gui.MainController;

import java.time.LocalDateTime;
import java.util.List;

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
        for (LocalDateTime brake : brakes) {
            System.out.println(brake);
        }
    }

    void showGUI() {
        MainController controller = new MainController();
    }

    public static void main(String[] args) {
        Main main = new Main();

        main.showStatistics();
    }
}