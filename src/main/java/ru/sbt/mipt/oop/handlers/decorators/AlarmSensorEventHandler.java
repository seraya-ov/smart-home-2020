package ru.sbt.mipt.oop.handlers.decorators;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.handlers.SensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;

import java.util.List;

public class AlarmSensorEventHandler implements SensorEventHandler {
    private final SmartAlarm alarm;
    private final List<SensorEventHandler> handlers;

    public AlarmSensorEventHandler(SmartAlarm alarm, List<SensorEventHandler> handlers) {
        this.alarm = alarm;
        this.handlers = handlers;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (alarm.isActivated()) {
            alarm.alert();
            System.out.println("Sending sms");
        } else if (alarm.isDeactivated()) {
            for (SensorEventHandler handler : handlers) {
                handler.handleEvent(event);
            }
        }
    }
}
