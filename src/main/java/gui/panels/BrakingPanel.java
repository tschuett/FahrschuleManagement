package gui.panels;

import EventStream.*;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

public class BrakingPanel extends DiagramPanel {

    private static final int NON_BRAKING = 1000;
    private static final int BRAKING = 4000;


    public BrakingPanel() {
        super(ChartFactory.createXYLineChart("Braking", "Time", "Brake!", getDataset()));
    }

    static private XYDataset getDataset() {
        FitCarEventStreamer fitCarEventStreamer = getEventStream();
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        List<CarEvent> events = statisticsEventConsumer.getEvents();

        Braking brak = new Braking();
        List<GPSSignal> points = brak.detectBraking(events);

        XYSeries speedXYSeries = new XYSeries("Braking");

        points.sort(new GPSSignalComparator());

        for (int i = 1; i < points.size(); i++) {
            Duration diff = Duration.between(points.get(i - 1).getTime(), points.get(i).getTime());
            Duration middle = diff.dividedBy(2);
            speedXYSeries.add(getAsSeconds(points.get(i - 1).getTime()), BRAKING);
            speedXYSeries.add(getAsSeconds((LocalDateTime) middle.addTo(points.get(i - 1).getTime())), NON_BRAKING);
        }
        speedXYSeries.add(getAsSeconds(points.getLast().getTime()), BRAKING);


        return new XYSeriesCollection(speedXYSeries);
    }

    private static double getAsSeconds(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.UTC);
    }
}
