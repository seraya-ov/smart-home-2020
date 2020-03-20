package ru.sbt.mipt.oop;

import org.junit.Test;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;

import static org.junit.jupiter.api.Assertions.*;

public class AlarmTest {
    @Test
    public void isInitiallyDeactivated() {
        assertTrue((new SmartAlarm()).isDeactivated());
    }

    @Test
    public void activate() {
        SmartAlarm alarm = new SmartAlarm();
        alarm.activate("0");
        assertTrue(alarm.isActivated());
    }

    @Test
    public void deactivateWithTheRightCode() {
        SmartAlarm alarm = new SmartAlarm();
        alarm.activate("0");
        alarm.deactivate("0");
        assertTrue(alarm.isDeactivated());
    }

    @Test
    public void deactivateWithTheWrongCode() {
        SmartAlarm alarm = new SmartAlarm();
        alarm.activate("0");
        alarm.deactivate("1");
        assertTrue(alarm.isAlert());
    }

    @Test
    public void alert() {
        SmartAlarm alarm = new SmartAlarm();
        alarm.activate("0");
        alarm.alert();
        assertTrue(alarm.isAlert());
    }
}