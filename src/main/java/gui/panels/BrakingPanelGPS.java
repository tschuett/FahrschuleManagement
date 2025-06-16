package gui.panels;

import EventStream.*;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

public class BrakingPanelGPS extends DiagramPanel {

    static final double DIVIDEND = 1000000.0;

    public BrakingPanelGPS() {
        super(ChartFactory.createXYLineChart("Braking GPS", "Longitude", "Latitude", getDataset()));
    }

    static private XYDataset getDataset() {
        FitCarEventStreamer fitCarEventStreamer = getEventStream();
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        List<CarEvent> events = statisticsEventConsumer.getEvents();

        Braking brak = new Braking();
        List<GPSSignal> points = brak.detectBraking(events);

        XYSeries speedXYSeries = new XYSeries("Braking GPS");

        points.sort(new GPSSignalComparator());

        for (GPSSignal gps : points) {
            speedXYSeries.add(gps.getLocation().getLongitude() / DIVIDEND, gps.getLocation().getLatitude() / DIVIDEND);
        }


        return new XYSeriesCollection(speedXYSeries);
    }
}
