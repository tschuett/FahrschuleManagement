package gui.panels;

import EventStream.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.List;

import static gui.panels.Settings.FILE;

public class BrakingPanelGPS extends ChartPanel {

    public BrakingPanelGPS() {
        super(ChartFactory.createXYLineChart("Braking GPS", "Longitude", "Latitude", getDataset()));
    }

    static private XYDataset getDataset() {
        XYSeries series = new XYSeries("Braking GPS");
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        List<CarEvent> events = statisticsEventConsumer.getEvents();

        Braking brak = new Braking();
        List<GPSSignal> points = brak.detectBraking(events);

        XYSeries speedXYSeries = new XYSeries("Braking GPS");

        points.sort(new GPSSignalComparator());

        for (GPSSignal gps : points) {
            speedXYSeries.add(gps.getLocation().getLongitude(), gps.getLocation().getLatitude());
        }


        return new XYSeriesCollection(speedXYSeries);
    }
}
