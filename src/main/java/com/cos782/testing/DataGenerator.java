package com.cos782.testing;

import com.cos782.sensors.TemperatureSensor;
import com.cos782.sensors.HumiditySensor;
import com.cos782.sensors.PressureSensor;
import com.cos782.sensors.WindSpeedSensor;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;
public class DataGenerator {
    private final TemperatureSensor temperatureSensor;
    private final HumiditySensor humiditySensor;
    private final PressureSensor pressureSensor;
    private final WindSpeedSensor windSpeedSensor;
    private final Timer timer;

    public DataGenerator(TemperatureSensor temperatureSensor, HumiditySensor humiditySensor,
                         PressureSensor pressureSensor, WindSpeedSensor windSpeedSensor) {
        this.temperatureSensor = temperatureSensor;
        this.humiditySensor = humiditySensor;
        this.pressureSensor = pressureSensor;
        this.windSpeedSensor = windSpeedSensor;
        this.timer = new Timer(true);
    }

    public void startGenerating() {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                generateData();
            }
        }, 0, 3000); // Update every 3 seconds
    }

    private void generateData() {
        float temperature = ThreadLocalRandom.current().nextFloat() * 40; // Random temperature between 0 and 40
        float humidity = ThreadLocalRandom.current().nextFloat() * 100;   // Random humidity between 0 and 100
        float pressure = 950 + ThreadLocalRandom.current().nextFloat() * 100; // Random pressure between 950 and 1050
        double windSpeed = ThreadLocalRandom.current().nextDouble() * 30; // Random wind speed between 0 and 30

        temperatureSensor.setTemperature(temperature);
        humiditySensor.setHumidity(humidity);
        pressureSensor.setPressure(pressure);
        windSpeedSensor.setWindSpeed(windSpeed);
    }
}
