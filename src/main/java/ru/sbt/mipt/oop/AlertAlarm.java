package ru.sbt.mipt.oop;

public class AlertAlarm implements Alarm {
    private final String code;

    public AlertAlarm(String code) {
        this.code = code;
    }

    @Override
    public Alarm activate(String code) {
        return this;
    }

    @Override
    public Alarm deactivate(String code) {
        if (code.equals(this.code)) {
            return new DeactivatedAlarm();
        }
        return this;
    }

    @Override
    public Alarm alert() {
        return this;
    }
}
