package com.cos782.gui;

import org.obsever.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Font;

public class TemperaturePanel extends JPanel implements Observer<Float> {
    private final JLabel temperatureLabel;

    public TemperaturePanel() {
        setLayout(new BorderLayout());
        temperatureLabel = new JLabel("Temperature: ");
        temperatureLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(temperatureLabel, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Temperature",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.BLUE
        ));
    }

    @Override
    public void update(Float temperature) {
        temperatureLabel.setText("Temperature: " + String.format("%.2f", temperature) + "°C");
    }
}
