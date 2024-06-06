package com.cos782.displays;


import org.obsever.Observer;

public class ForecastDisplay<T extends Number> implements Observer<T> {
    private final String type;
    private T previousValue;

    public ForecastDisplay(String type) {
        this.type = type;
    }

    @Override
    public void update(T data) {
        if (previousValue == null) {
            System.out.println("Forecast " + type + ": Data insufficient to predict.");
        } else {
            System.out.println("Forecast " + type + ": " + predict(data));
        }
        previousValue = data;
    }

    private String predict(T data) {
        if (data.doubleValue() > previousValue.doubleValue()) {
            return "Increasing trend";
        } else if (data.doubleValue() < previousValue.doubleValue()) {
            return "Decreasing trend";
        } else {
            return "No change";
        }
    }
}
