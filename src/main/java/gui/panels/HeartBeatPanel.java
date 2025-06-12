package gui.panels;

import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static gui.panels.Settings.FILE;

public class HeartBeatPanel extends ChartPanel {

    public HeartBeatPanel() {
        super(ChartFactory.createXYLineChart("Heartbeat", "Time", "Heartbeat", getDataset()));
    }

    static private XYDataset getDataset() {
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        XYSeries speed = statisticsEventConsumer.getHeartBeatXYSeries();
        return new XYSeriesCollection(speed);
    }
}
