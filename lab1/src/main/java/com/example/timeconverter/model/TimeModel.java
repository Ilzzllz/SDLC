package com.example.timeconverter.model;

import java.util.Observable;

public class TimeModel extends Observable {
    private int waitingTimeMinutes = 0;

    public int getWaitingTimeMinutes() {
        return waitingTimeMinutes;
    }

    public void setWaitingTimeMinutes(int minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Время не может быть отрицательным");
        }
        this.waitingTimeMinutes = minutes;
        setChanged();
        notifyObservers();
    }
}