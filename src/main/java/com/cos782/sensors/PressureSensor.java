package com.cos782.sensors;


import org.obsever.Subject;

public class PressureSensor extends Subject<Float> {
    public void setPressure(float pressure) {
        setState(pressure);
    }
}