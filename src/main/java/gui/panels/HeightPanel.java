package gui.panels;

import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import static gui.panels.Settings.FILE;

public class HeightPanel extends ChartPanel {

    public HeightPanel() {
        super(ChartFactory.createXYLineChart("Height", "Time", "Height", getDataset()));
    }

    static private XYDataset getDataset() {
        FitCarEventStreamer fitCarEventStreamer = new FitCarEventStreamer(FILE);
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        XYSeries speed = statisticsEventConsumer.getHeightXYSeries();
        return new XYSeriesCollection(speed);
    }
}
