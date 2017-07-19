package com.codurance.tirePressureMonitoringSystem;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class AlarmShould {

    @Mock
    private Sensor sensor;

    @Test
    public void have_alarm_set_off_by_default() {
        Alarm alarm = new Alarm();
        assertEquals(false, alarm.isAlarmOn());
    }

    @Test
    public void set_on_when_pressure_is_below_threshold() {

        Alarm alarm = new Alarm(sensor);

        given(sensor.popNextPressurePsiValue()).willReturn(16d);

        alarm.check();
        assertThat(alarm.isAlarmOn(), equalTo(true));
    }

    @Test
    public void set_on_when_pressure_is_above_threshold() {

        Alarm alarm = new Alarm(sensor);

        given(sensor.popNextPressurePsiValue()).willReturn(22d);

        alarm.check();
        assertThat(alarm.isAlarmOn(), equalTo(true));
    }

    @Test
    public void set_off_when_pressure_is_within_threshold() {

        Alarm alarm = new Alarm(sensor);

        given(sensor.popNextPressurePsiValue()).willReturn(19d);

        alarm.check();
        assertThat(alarm.isAlarmOn(), equalTo(false));
    }
}
