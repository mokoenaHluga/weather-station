package com.cos782.gui;

import org.obsever.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Font;
public class WindSpeedPanel extends JPanel implements Observer<Double> {
    private final JLabel windSpeedLabel;

    public WindSpeedPanel() {
        setLayout(new BorderLayout());
        windSpeedLabel = new JLabel("Wind Speed: ");
        windSpeedLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(windSpeedLabel, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Wind Speed",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.BLUE
        ));
    }

    @Override
    public void update(Double windSpeed) {
        windSpeedLabel.setText("Wind Speed: " + String.format("%.2f", windSpeed) + " m/s");
    }
}
