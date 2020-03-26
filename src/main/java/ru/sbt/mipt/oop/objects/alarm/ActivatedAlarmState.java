package ru.sbt.mipt.oop.objects.alarm;

public class ActivatedAlarmState implements AlarmState {
    private String code;

    public ActivatedAlarmState(String code) {
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
        return this.alert();
    }

    @Override
    public AlarmState alert() {
        return new AlertAlarmState(code);
    }
}
