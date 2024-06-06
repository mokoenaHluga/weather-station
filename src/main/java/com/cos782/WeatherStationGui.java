package com.cos782;

import com.cos782.gui.HumidityPanel;
import com.cos782.gui.TemperaturePanel;
import com.cos782.sensors.TemperatureSensor;
import com.cos782.gui.PressurePanel;
import com.cos782.gui.WindSpeedPanel;
import com.cos782.sensors.HumiditySensor;
import com.cos782.sensors.PressureSensor;
import com.cos782.sensors.WindSpeedSensor;
import com.cos782.testing.DataGenerator;

import javax.swing.*;
import java.awt.*;

public class WeatherStationGui extends JFrame {
    private final TemperatureSensor temperatureSensor;
    private final HumiditySensor humiditySensor;
    private final PressureSensor pressureSensor;
    private final WindSpeedSensor windSpeedSensor;

    public WeatherStationGui() {
        setTitle("Weather Station");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10)); // Adding some spacing between panels

        // Set a default font for the entire application
        setDefaultFont(new Font("Arial", Font.PLAIN, 14));

        temperatureSensor = new TemperatureSensor();
        humiditySensor = new HumiditySensor();
        pressureSensor = new PressureSensor();
        windSpeedSensor = new WindSpeedSensor();

        TemperaturePanel temperaturePanel = new TemperaturePanel();
        HumidityPanel humidityPanel = new HumidityPanel();
        PressurePanel pressurePanel = new PressurePanel();
        WindSpeedPanel windSpeedPanel = new WindSpeedPanel();

        temperatureSensor.addObserver(temperaturePanel);
        humiditySensor.addObserver(humidityPanel);
        pressureSensor.addObserver(pressurePanel);
        windSpeedSensor.addObserver(windSpeedPanel);

        add(temperaturePanel);
        add(humidityPanel);
        add(pressurePanel);
        add(windSpeedPanel);

        DataGenerator dataGenerator = new DataGenerator(temperatureSensor, humiditySensor, pressureSensor, windSpeedSensor);
        dataGenerator.startGenerating();
    }

    public static void main(String[] args) {
        WeatherStationGui gui = new WeatherStationGui();
        gui.setVisible(true);
    }

    private void setDefaultFont(Font font) {
        UIManager.put("Label.font", font);
        UIManager.put("Button.font", font);
        UIManager.put("TextField.font", font);
        UIManager.put("TextArea.font", font);
        UIManager.put("ComboBox.font", font);
        UIManager.put("List.font", font);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
        UIManager.put("TitledBorder.font", font);
        UIManager.put("ToolTip.font", font);
        UIManager.put("Tree.font", font);
    }
}