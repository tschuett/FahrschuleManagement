package gui.panels;

import EventStream.FitCarEventStreamer;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

abstract class DiagramPanel extends ChartPanel {
    private static final String FILE = "src/main/resources/Burg_Rabenstein.fit";

    public DiagramPanel(JFreeChart chart) {
        super(chart);
    }

    public static FitCarEventStreamer getEventStream() {
        return new FitCarEventStreamer(FILE);
    }
}
