package com.cos782.displays;

import org.obsever.Observer;

public class CurrentConditionsDisplay<T> implements Observer<T> {
    private final String type;

    public CurrentConditionsDisplay(String type) {
        this.type = type;
    }

    @Override
    public void update(T data) {
        System.out.println("Current " + type + ": " + data);
    }
}
