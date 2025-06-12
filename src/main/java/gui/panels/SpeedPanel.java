package gui.panels;

import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static gui.panels.Settings.FILE;

public class SpeedPanel extends ChartPanel {

    public SpeedPanel() {
        super(ChartFactory.createXYLineChart("Speed", "Time", "Speed", getDataset()));
    }

    static private XYDataset getDataset() {
        XYSeries series = new XYSeries("Speed");
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        XYSeries speed = statisticsEventConsumer.getSpeedXYSeries();
        return new XYSeriesCollection(speed);
    }
}
