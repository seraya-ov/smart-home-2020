package ru.sbt.mipt.oop.handlers.alarm_event_handlers;

import ru.sbt.mipt.oop.events.AlarmEvent;
import ru.sbt.mipt.oop.objects.alarm.Alarm;

import static ru.sbt.mipt.oop.types.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.types.AlarmEventType.ALARM_DEACTIVATE;

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
