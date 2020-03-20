package ru.sbt.mipt.oop;

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
