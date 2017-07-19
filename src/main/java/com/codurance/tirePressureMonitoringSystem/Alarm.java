package com.codurance.tirePressureMonitoringSystem;

public class Alarm
{
    private final double LowPressureThreshold;
    private final double HighPressureThreshold;

    Sensor sensor;

    boolean alarmOn = false;

    public Alarm() {
        this(new Sensor(), new Threshold(17, 21));
    }

    public Alarm(Sensor sensor, Threshold threshold) {
        LowPressureThreshold = threshold.low();
        HighPressureThreshold = threshold.high();
        this.sensor = sensor;
    }

    public void check()
    {
        double psiPressureValue = sensor.popNextPressurePsiValue();

        if (psiPressureValue < LowPressureThreshold || HighPressureThreshold < psiPressureValue)
        {
            alarmOn = true;
        }
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
