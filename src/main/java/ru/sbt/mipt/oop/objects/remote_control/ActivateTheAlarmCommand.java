package ru.sbt.mipt.oop.objects.remote_control;

import ru.sbt.mipt.oop.events.AlarmEvent;
import ru.sbt.mipt.oop.handlers.AlarmEventHandler;
import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;
import ru.sbt.mipt.oop.types.AlarmEventType;

public class ActivateTheAlarmCommand implements Command {
    private final SmartAlarm alarm;

    public ActivateTheAlarmCommand(SmartAlarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        String code = "default code";
        AlarmEvent event = new AlarmEvent(AlarmEventType.ALARM_ACTIVATE, code);
        AlarmEventHandler handler = new AlarmEventHandler(alarm);
        handler.handleEvent(event);
    }
}
