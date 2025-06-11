package gui.panels;

import EventStream.Braking;
import EventStream.CarEvent;
import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Comparator;
import java.util.List;

public class BrakingPanel extends ChartPanel {

    private static final int NON_BRAKING = 1000;
    private static final int BRAKING = 4000;

    private static final String FILE = "src/main/resources/Burg_Rabenstein.fit";

    public BrakingPanel() {
        super(ChartFactory.createXYLineChart("Braking", "Time", "Brake!", getDataset()));
    }

    static private XYDataset getDataset() {
        XYSeries series = new XYSeries("Braking");
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        List<CarEvent> events = statisticsEventConsumer.getEvents();

        Braking brak = new Braking();
        List<LocalDateTime> points = brak.detectBraking(events);

        XYSeries speedXYSeries = new XYSeries("Braking");

        points.sort(Comparator.naturalOrder());

        for (int i = 1; i < points.size(); i++) {
            Duration diff = Duration.between(points.get(i - 1), points.get(i));
            Duration middle = diff.dividedBy(2);
            speedXYSeries.add(getAsSeconds(points.get(i-1)), BRAKING);
            speedXYSeries.add(getAsSeconds((LocalDateTime) middle.addTo(points.get(i-1))), NON_BRAKING);
        }
        speedXYSeries.add(getAsSeconds(points.getLast()), BRAKING);


        return new XYSeriesCollection(speedXYSeries);
    }

    private static double getAsSeconds(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.UTC);
    }
}
