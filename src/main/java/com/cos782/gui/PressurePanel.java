package com.cos782.gui;

import org.obsever.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import java.awt.Font;

public class PressurePanel extends JPanel implements Observer<Float> {
    private final JLabel pressureLabel;

    public PressurePanel() {
        setLayout(new BorderLayout());
        pressureLabel = new JLabel("Pressure: ");
        pressureLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(pressureLabel, BorderLayout.CENTER);

        setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                "Pressure",
                TitledBorder.CENTER,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 16),
                Color.BLUE
        ));
    }

    @Override
    public void update(Float pressure) {
        pressureLabel.setText("Pressure: " + String.format("%.2f", pressure) + " hPa");
    }
}
