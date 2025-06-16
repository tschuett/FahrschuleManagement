package gui.panels;

import EventStream.FitCarEventStreamer;
import EventStream.StatisticsEventConsumer;
import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


public class TemperaturePanel extends DiagramPanel {

    public TemperaturePanel() {
        super(ChartFactory.createXYLineChart("Temperature", "Time", "Temperature", getDataset()));
    }

    static private XYDataset getDataset() {
        XYSeries series = new XYSeries("Temperature");
        FitCarEventStreamer fitCarEventStreamer = getEventStream();
        StatisticsEventConsumer statisticsEventConsumer = new StatisticsEventConsumer();
        fitCarEventStreamer.onEvent(statisticsEventConsumer);
        fitCarEventStreamer.awaitTermination();
        XYSeries speed = statisticsEventConsumer.getTemperatureXYSeries();
        return new XYSeriesCollection(speed);
    }
}
