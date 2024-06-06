package com.cos782.displays;


import org.obsever.Observer;

import java.util.ArrayList;
import java.util.List;

public class StatisticsDisplay<T extends Number> implements Observer<T> {
    private final List<T> values = new ArrayList<>();
    private final String type;

    public StatisticsDisplay(String type) {
        this.type = type;
    }

    @Override
    public void update(T data) {
        values.add(data);
        System.out.println("Average " + type + ": " + calculateAverage());
    }

    private double calculateAverage() {
        double sum = 0;
        for (T value : values) {
            sum += value.doubleValue();
        }
        return sum / values.size();
    }
}
