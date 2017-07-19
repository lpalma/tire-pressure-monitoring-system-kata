package com.codurance.tirePressureMonitoringSystem;

public class Threshold {
    private final double low;
    private final double high;

    public Threshold(double low, double high) {
        this.low = low;
        this.high = high;
    }

    public double low() {
        return low;
    }

    public double high() {
        return high;
    }
}
