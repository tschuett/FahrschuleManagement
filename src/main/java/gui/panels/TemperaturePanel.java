package gui.panels;

import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static gui.panels.Settings.FILE;

public class TemperaturePanel extends ChartPanel {

    public TemperaturePanel() {
        super(ChartFactory.createXYLineChart("Temperature", "Time", "Temperature", getDataset()));
    }

    static private XYDataset getDataset() {
        XYSeries series = new XYSeries("Temperature");
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        XYSeries speed = statisticsEventConsumer.getTemperatureXYSeries();
        return new XYSeriesCollection(speed);
    }
}
