package ru.sbt.mipt.oop.handlers;

import ru.sbt.mipt.oop.events.AlarmEvent;
import ru.sbt.mipt.oop.events.SensorEvent;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;

import static ru.sbt.mipt.oop.types.AlarmEventType.ALARM_ACTIVATE;
import static ru.sbt.mipt.oop.types.AlarmEventType.ALARM_DEACTIVATE;

public class AlarmEventHandler implements SensorEventHandler{
    private SmartAlarm alarm;

    public AlarmEventHandler(SmartAlarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void handleEvent(SensorEvent event) {
        if (event instanceof AlarmEvent) {
            if (((AlarmEvent)event).getAlarmEventType() == ALARM_ACTIVATE) {
                alarm.activate(((AlarmEvent)event).getCode());
            } else if (((AlarmEvent)event).getAlarmEventType() == ALARM_DEACTIVATE) {
                alarm.deactivate(((AlarmEvent)event).getCode());
            }
        }
    }
}
