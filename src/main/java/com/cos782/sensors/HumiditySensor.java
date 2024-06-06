package com.cos782.sensors;

import org.obsever.Subject;

public class HumiditySensor extends Subject<Float> {
    public void setHumidity(float humidity) {
        setState(humidity);
    }
}
