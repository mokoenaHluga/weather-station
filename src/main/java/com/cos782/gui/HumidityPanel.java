package com.cos782.gui;

import org.obsever.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Font;


public class HumidityPanel extends JPanel implements Observer<Float> {
    private final JLabel humidityLabel;

    public HumidityPanel() {
        setLayout(new BorderLayout());
        humidityLabel = new JLabel("Humidity: ");
        humidityLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(humidityLabel, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Humidity",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.BLUE
        ));
    }

    @Override
    public void update(Float humidity) {
        humidityLabel.setText("Humidity: " + String.format("%.2f", humidity) + "%");
    }
}
