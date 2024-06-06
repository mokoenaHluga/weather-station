package com.cos782.sensors;


import org.obsever.Subject;

public class WindSpeedSensor extends Subject<Double> {
    public void setWindSpeed(double windSpeed) {
        setState(windSpeed);
    }
}
