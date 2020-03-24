package ru.sbt.mipt.oop.objects.alarm;

public class AlertAlarmState implements AlarmState {
    private final String code;

    public AlertAlarmState(String code) {
        this.code = code;
    }

    @Override
    public AlarmState activate(String code) {
        return this;
    }

    @Override
    public AlarmState deactivate(String code) {
        if (code.equals(this.code)) {
            return new DeactivatedAlarmState();
        }
        return this;
    }

    @Override
    public AlarmState alert() {
        return this;
    }
}
