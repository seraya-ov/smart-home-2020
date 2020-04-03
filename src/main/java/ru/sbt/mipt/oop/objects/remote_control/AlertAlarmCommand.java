package ru.sbt.mipt.oop.objects.remote_control;

import ru.sbt.mipt.oop.objects.alarm.SmartAlarm;

public class AlertAlarmCommand implements Command {
    private final SmartAlarm alarm;

    public AlertAlarmCommand(SmartAlarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.alert();
    }
}
