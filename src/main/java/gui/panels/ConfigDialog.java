package gui.panels;

import javax.swing.*;
import java.awt.*;

public final class ConfigDialog extends JDialog {

    public ConfigDialog(JFrame owner) {
        super(owner, true);

        setTitle("Config");

        JTabbedPane tabbedPane = new JTabbedPane();

        addPrinterTab(tabbedPane);
        addNetworkTab(tabbedPane);

        setContentPane(tabbedPane);
    }

    private void addPrinterTab(JTabbedPane tabbedPane) {
        JPanel printer = new JPanel( new GridLayout(4, 3));
        printer.add(new JLabel("Printer"));
        final String[] printerTypes = {"Canon 34UF", "HP 23Slow", "HP 60 Fast"};
        JComboBox<String> printerComboBox = new JComboBox<>(printerTypes);
        printer.add(printerComboBox);
        tabbedPane.addTab("Printer", printer);
    }

    private void addNetworkTab(JTabbedPane tabbedPane) {
        JPanel network = new JPanel();
        network.add(new JLabel("Network"));

        ButtonGroup group = new ButtonGroup();
        JRadioButton wifi = new JRadioButton("Wifi");
        JRadioButton ipv4 = new JRadioButton("Ethernet IPV4");
        JRadioButton ipv6 = new JRadioButton("Ethernet IPV6");
        group.add(wifi);
        group.add(ipv4);
        group.add(ipv6);

        network.add(wifi);
        network.add(ipv4);
        network.add(ipv6);
        wifi.setSelected(true);
        tabbedPane.addTab("Network", network);
    }
}
