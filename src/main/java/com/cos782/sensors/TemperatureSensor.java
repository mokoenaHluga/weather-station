package com.cos782.sensors;


import org.obsever.Subject;

public class TemperatureSensor extends Subject<Float> {
    public void setTemperature(float temperature) {
        setState(temperature);
    }
}
