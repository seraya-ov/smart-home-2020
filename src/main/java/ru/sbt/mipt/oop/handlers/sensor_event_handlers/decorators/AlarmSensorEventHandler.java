package ru.sbt.mipt.oop.handlers.sensor_event_handlers.decorators;

import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.handlers.sensor_event_handlers.SensorEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;

public class AlarmSensorEventHandler implements SensorEventHandler {
    private final SmartAlarm alarm;
    private final SensorEventHandler handler;

    public AlarmSensorEventHandler(SmartAlarm alarm, SensorEventHandler handler) {
        this.alarm = alarm;
        this.handler = handler;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (alarm.isDeactivated()) {
            handler.handleEvent(event);
        }
        else {
            alarm.alert();
            System.out.println("Sending sms");
        }
    }
}
