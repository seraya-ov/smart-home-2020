package ru.sbt.mipt.oop;

import static ru.sbt.mipt.oop.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.AlarmEventType.ALARM_DEACTIVATE;

public class AlarmEventHandler {
    private Alarm alarm;

    public AlarmEventHandler(Alarm alarm) {
        this.alarm = alarm;
    }

    public void handleEvent(AlarmEvent event) {
        if (event.getAlarmEventType() == ALARM_ACTIVATE) {
            alarm.activate(event.getCode());
        } else if (event.getAlarmEventType() == ALARM_DEACTIVATE) {
            alarm.deactivate(event.getCode());
        }
    }
}
